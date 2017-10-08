package com.dreaouth.controller;

import com.dreaouth.model.User;
import com.dreaouth.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("queryAdmin")
    public String queryAdmin(HttpServletRequest request){
        List<User> list=adminService.getList();
        for(User user:list){
            if (user.getPermission().equals("admin")){
                user.setPermission("超级管理员");
            }
            else {
                user.setPermission("普通管理员");
            }
        }
        request.setAttribute("adminlist",list);
        request.setAttribute("check","no");
        return "admin_show";
    }

    @RequestMapping("insertAdmin")
    public String insertAdmin(HttpServletRequest request){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String permission=request.getParameter("permission");
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*@[0-9A-Za-z.]+$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            request.setAttribute("information", "邮箱的格式不符");
            return "failure";
        }
        User user=new User(name,password,email,permission);
        if (adminService.insertUser(user)){
            List<User> list=adminService.getList();
            for(User user1:list){
                if (user1.getPermission().equals("admin")){
                    user1.setPermission("超级管理员");
                }
                else {
                    user1.setPermission("普通管理员");
                }
            }
            request.setAttribute("adminlist",list);
            request.setAttribute("check","add");
            return "admin_show";
        }else {
            request.setAttribute("information", "该用户名已存在");
            return "failure";
        }
    }

    @RequestMapping("deleteAdmin")
    public void deleteAdmin(HttpServletRequest request){
        String id=request.getParameter("sta_id");
        adminService.delete(id);
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("password",request.getParameter("password"));
        request.setAttribute("email",request.getParameter("email"));
        request.setAttribute("permission",request.getParameter("permission"));
        request.setAttribute("id",request.getParameter("id"));
        return "admin_update";
    }

    @RequestMapping("updateAdmin")
    public String updateAdmin(HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String permission=request.getParameter("permission");
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*@[0-9A-Za-z.]+$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            request.setAttribute("information", "邮箱的格式不符");
            return "failure";
        }
        User user=new User(Integer.parseInt(id),name,password,email,permission);
        if (adminService.update(user)){
            List<User> list=adminService.getList();
            for(User user1:list){
                if (user1.getPermission().equals("admin")){
                    user1.setPermission("超级管理员");
                }
                else {
                    user1.setPermission("普通管理员");
                }
            }
            request.setAttribute("adminlist",list);
            request.setAttribute("check","update");
            return "admin_show";
        }else {
            request.setAttribute("information", "输入格式不符");
            return "failure";
        }
    }
}
