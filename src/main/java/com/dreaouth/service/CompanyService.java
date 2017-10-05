package com.dreaouth.service;

import com.dreaouth.dao.CompanyMapper;
import com.dreaouth.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    public boolean insert(Company company){
        if (companyMapper.selectByCode(company.getCode())==null){
            companyMapper.insert(company);
            return true;
        }else {
            return false;
        }
    }

    public List<Company> getList(){
        return companyMapper.selectAll();
    }

    public boolean delete(String id){
        companyMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public Company select(String code){
        return companyMapper.selectByCode(code);
    }

    public boolean update(Company company){
        companyMapper.updateByPrimaryKey(company);
        return true;
    }
}
