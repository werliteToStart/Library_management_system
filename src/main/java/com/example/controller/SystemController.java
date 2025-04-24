package com.example.controller;

import com.example.bean.User;
import com.example.bean.UserAndRole;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SystemController {

    @Autowired
    UserService userService;

    @RequestMapping("/system/queryAllUser")
    public String queryAllUser(Model model){
        List<User> users = userService.queryAllUser();
        List<UserAndRole> userRoles = new ArrayList<>();
        for (User user : users) {
            userRoles.add(new UserAndRole(user,userService.queryRoleById(user.getRole_id())));
        }
        model.addAttribute("userRoles",userRoles);
        return "user_update";
    }

    @RequestMapping("/system/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/system/queryAllUser";
    }
}
