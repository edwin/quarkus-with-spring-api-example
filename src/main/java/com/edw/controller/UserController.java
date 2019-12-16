package com.edw.controller;

import com.edw.entity.User;
import com.edw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <pre>
 *     com.edw.controller.UserController
 * </pre>
 *
 * @author Muhammad Edwin < emuhamma at redhat dot com >
 * 16 Des 2019 11:53
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping("/")
    public String index() {
        return "hello world";
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return userService.insert(user);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        userService.delete(id);
        return Boolean.TRUE;
    }

    @GetMapping("/exist/{id}")
    public Boolean exist(@PathVariable("id") String id) {
        return userService.exist(id);
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

}
