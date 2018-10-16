package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String Users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/userlist";
    }

    @PostMapping(value = "/user")
    public String addUser(User user) {
        user.setLevel(1);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/user")
    public String toAddPage() {
        return "user/add";
    }

    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "user/add";
    }

    @PutMapping("/user")
    public String updateEmployee(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    //员工删除
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
