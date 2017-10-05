package com.dreaouth.controller;

import com.dreaouth.model.City;
import com.dreaouth.model.Company;
import com.dreaouth.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("queryCompany")
    public String queryCompanyList(HttpServletRequest request){

    }



}
