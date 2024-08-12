package com.lgs.backend.api;

import com.lgs.backend.model.User;
import com.lgs.backend.service.UserService;
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
    public List<User> getUserAll() {
        LOGGER.info("查询全部信息");
        return userService.getUserAll();
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
