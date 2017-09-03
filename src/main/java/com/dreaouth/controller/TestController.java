package com.dreaouth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {
    @RequestMapping("index")
    public String testIndex(){
        return  "testIndex";
    }
}
