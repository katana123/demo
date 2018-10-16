package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {

        User user = userService.finduser(username, password);

        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && user != null) {
            session.setAttribute("loginUser", username);
            session.setAttribute("loginId", user.getId());
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

    @GetMapping(value = "/user/signout")
    public String signout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.removeAttribute("loginId");
        return "redirect:/";
    }
}
