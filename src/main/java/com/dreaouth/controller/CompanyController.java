package com.dreaouth.controller;

import com.dreaouth.model.Company;
import com.dreaouth.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("queryCompany")
    public String queryCompanyList(HttpServletRequest request){
        List<Company> list=companyService.getList();
        request.setAttribute("companylist",list);
        request.setAttribute("check","no");
        return "company_show";
    }

    @RequestMapping("selectCompany")
    public String queryCompany(HttpServletRequest request){
        String code=request.getParameter("sta_name");
        List<Company> companyList=new ArrayList<>();
        Company company=companyService.select(code);
        companyList.add(company);
        request.setAttribute("companylist",companyList);
        request.setAttribute("check","no");
        return "company_show";
    }

    @RequestMapping("deleteCompany")
    public void delete(HttpServletRequest request){
        String id=request.getParameter("id");
        companyService.delete(id);
    }

    @RequestMapping("insert")
    public String insert(){
        return "company_add";
    }

    @RequestMapping("insertCompany")
    public String insertCompany(HttpServletRequest request){
        String name=request.getParameter("name");
        String code=request.getParameter("code");
        if (code.length()!=2){
            request.setAttribute("information","输入的航空公司代码不符，代码长度为两个字符！");
            return "failure";
        }
        Company company=new Company(name,code);
        if (companyService.insert(company)){
            List<Company> list=companyService.getList();
            request.setAttribute("companylist",list);
            request.setAttribute("check","add");
            return "company_show";
        }else {
            request.setAttribute("information","已存在该航空公司");
            return "failure";
        }
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("code",request.getParameter("code"));
        request.setAttribute("name",request.getParameter("name"));
        return "company_update";
    }

    @RequestMapping("updateCompany")
    public String updateCompany(HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String code=request.getParameter("code");
        if (code.length()!=2){
            request.setAttribute("information","输入的航空公司代码不符，代码长度为两个字符！");
            return "failure";
        }
        Company company=new Company(Integer.parseInt(id),name,code);
        companyService.update(company);
        List<Company> list=companyService.getList();
        request.setAttribute("companylist",list);
        request.setAttribute("check","update");
        return "company_show";
    }


}
