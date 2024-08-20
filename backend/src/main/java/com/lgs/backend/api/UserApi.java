package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Account;
import com.lgs.backend.model.User;
import com.lgs.backend.service.UserService;
import com.lgs.backend.utils.JwtUtils;
import com.lgs.backend.utils.PaginateInfo;
import com.wf.captcha.SpecCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json;charset=utf-8")
public class UserApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
    private static PasswordEncryptor encryptor = new StrongPasswordEncryptor();
    @Value("${jwt.secret.key}")
    private String secretKey;
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Map<String,Object> getUserAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                         @RequestParam(defaultValue = "1000") Integer pageSize, User user) {
        LOGGER.info("查询全部管理员信息");
        PaginateInfo paginateInfo = new PaginateInfo(pageNo,pageSize);
        List<User> users = userService.getUserAll(paginateInfo,user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        Map<String,Object> map = Map.of("pageNo",pageInfo.getPageNum(),"pageSize",pageInfo.getPageSize(),"total",pageInfo.getTotal());
        return  Map.of("success",true,"rows", users,"pi",map);
   }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Account account, HttpSession session){
        if(!StringUtils.hasText(account.getCaptcha())){
            return Map.of("success", false, "error", "验证码不可为空");
        }
        String captcha = session.getAttribute("captcha").toString();
        if(!account.getCaptcha().equalsIgnoreCase(captcha)){
            return Map.of("success", false, "error", "验证码错误");
        }
        if(!StringUtils.hasText(account.getUsername())){
            return Map.of("success", false, "error", "用户名不可为空");
        }
        User user = userService.findUserByUsername(account.getUsername());
        if (user == null) {
            return Map.of("success", false, "error", "用户名不存在");
        }
//        System.out.println(user.getPassword()+" "+account.getPassword());
//        System.out.println(encryptor.encryptPassword("123456"));
        if(!encryptor.checkPassword(account.getPassword(), user.getPassword())){
            return Map.of("success", false, "error", "密码错误");
        }
        //颁发token
        Map<String,Object> data = Map.of("password", account.getPassword());
        String jwt = JwtUtils.encode(data,secretKey,user.getUsername());
        return Map.of("success", true, "jwt", jwt);
    }
    @GetMapping("/captcha")
    public void captcha(HttpServletResponse resp, HttpSession session) throws IOException {
        //生成验证码
        SpecCaptcha cap = new SpecCaptcha(170, 35, 4);
        //设置响应头
        resp.setContentType("image/gif");
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0L);
        //存储验证码到session
        session.setAttribute("captcha", cap.text().toLowerCase());
        cap.out(resp.getOutputStream());
    }
    @GetMapping("/username")
    public String getUsernameFromToken()  {
        LOGGER.info("获取用户名");
        String username = JwtUtils.getUsernameFromToken();
//        System.out.println("username: " + username);
       return username;
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
        user.setPassword(encryptor.encryptPassword(user.getPassword()));
        boolean success = userService.addUser(user);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Integer id) {
        boolean success = userService.deleteUser(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user) {
        boolean success = userService.updateUser(user);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping("/password")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody User user) {
        user.setPassword(encryptor.encryptPassword(user.getPassword()));
        boolean success = userService.updatePassword(user);
        return ResponseEntity.ok(Map.of("success", success));
    }

}
