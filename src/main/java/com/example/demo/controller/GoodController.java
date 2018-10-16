package com.example.demo.controller;

import com.example.demo.entity.Good;
import com.example.demo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodController {

    @Autowired
    GoodService goodService;

    @GetMapping(value = "/goods")
    public String Users(Model model, HttpSession session) {
        List<Good> goods = goodService.findAll();
        Integer uid = (Integer) session.getAttribute("loginId");
        System.out.println(uid);
        model.addAttribute("goods", goods);
        return "good/goodlist";
    }

    @GetMapping(value = "/good")
    public String toAddPage() {
        return "good/add";
    }

    @PostMapping(value = "/good")
    public String addGood(Good user) {
        goodService.saveGood(user);
        return "redirect:/goods";
    }

    @GetMapping("/good/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Good good = goodService.get(id);
        model.addAttribute("good", good);
        return "good/add";
    }

    @PutMapping("/good")
    public String updateEmployee(Good good) {
        goodService.saveGood(good);
        return "redirect:/goods";
    }

    //员工删除
    @DeleteMapping("/good/{id}")
    public String deleteGood(@PathVariable("id") Integer id) {
        goodService.delete(id);
        return "redirect:/goods";
    }
}
