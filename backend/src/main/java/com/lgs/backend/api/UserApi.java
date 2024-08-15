package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.User;
import com.lgs.backend.service.UserService;
import com.lgs.backend.utils.PaginateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json;charset=utf-8")
public class UserApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);
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
    @PostMapping
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
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

}
