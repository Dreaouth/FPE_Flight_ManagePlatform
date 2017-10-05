package com.dreaouth.controller;

import com.dreaouth.model.User;
import com.dreaouth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    public static User user;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("registerOK", "no");
        return "login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request) {
        request.setAttribute("username", "admin");
        return "register";
    }

    @RequestMapping("/check_login")
    public String check_login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        int status = loginService.checktUsers(user);
        if (status == -2) {
            request.setAttribute("check", "-2");
            request.setAttribute("registerOK", "no");
            return "login";
        } else if (status == -1) {
            request.setAttribute("check", "-1");
            request.setAttribute("registerOK", "no");
            return "login";
        } else {
            user = loginService.getUser(user.getName());
            this.user = user;
            return "redirect:welcome";
        }
    }

    @RequestMapping("/check_register")
    public String check_register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String e_mail = request.getParameter("e_mail");
        String password = request.getParameter("password");
        String passowrd2 = request.getParameter("password2");
        if (!passowrd2.equals(password)) {
            request.setAttribute("check", "3");
            return "register";
        }
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*@[0-9A-Za-z.]+$");
        Matcher matcher = pattern.matcher(e_mail);
        if (!matcher.matches()) {
            request.setAttribute("check", "2");
            return "register";
        }
        User user = new User(username, password, e_mail, "user");
        if (loginService.register(user)) {
            request.setAttribute("registerOK", "ok");
            return "login";
        } else {
            request.setAttribute("check", "1");
            return "register";
        }
    }

}
