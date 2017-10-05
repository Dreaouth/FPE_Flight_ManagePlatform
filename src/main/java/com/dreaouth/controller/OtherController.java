package com.dreaouth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OtherController {
    @RequestMapping("/load")
    public String load(HttpServletRequest request) {
        return "load";
    }

    @RequestMapping("/forbid")
    public String forbid(HttpServletRequest request) {
        return "forbid";
    }

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        request.setAttribute("users", LoginController.user);
        return "welcome";
    }
}
