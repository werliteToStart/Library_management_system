package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping({"/","/login"})
    public String Login(){

        return  "login";
    }
    @RequestMapping("/login/submit")
    public String submit(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        User user = userService.queryUserByUsername(username);

        if (user != null&&user.getPassword().equals(password)){

            session.setAttribute("user",user);
            if (user.getRole_id() == 1){
                return "redirect:/index";
            } else if (user.getRole_id() == 2) {
                return "redirect:/admin/queryAllBook";
            }else if (user.getRole_id() == 3){
                return "redirect:/admin/queryAllBook";
            }
        }
        model.addAttribute("msg","用户名或者密码错误");
        return "login";
    }

    @RequestMapping("/login/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/login/updateUserById")
    public String updateUserById(HttpSession session,User user){
        userService.updateUserById(user);
        User user_Role = (User) session.getAttribute("user");
        if (user_Role.getRole_id() == 1){
            return "redirect:/index";
        }else {
            return "redirect:/admin/queryAllBook";
        }
    }

    @RequestMapping("/login/updateUserPassword")
    public String updateUserById(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        User userMysql = userService.queryUserById(user.getId());
        model.addAttribute("userMysql",userMysql);
        return "user_update_password";
    }
}
