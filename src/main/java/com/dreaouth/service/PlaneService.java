package com.dreaouth.service;

import com.dreaouth.dao.CityMapper;
import com.dreaouth.dao.CompanyMapper;
import com.dreaouth.dao.PlaneMapper;
import com.dreaouth.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneMapper planeMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CompanyMapper companyMapper;

    public List<Plane> getList() {
        return planeMapper.selectAll();
    }

    public List<Plane> select(Plane plane) {
        return planeMapper.selectByDrome(plane);
    }

    public boolean delete(String id) {
        planeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public int insert(Plane plane) {
        if (cityMapper.selectByCityCode(plane.getStartDrome()) == null || cityMapper.selectByCityCode(plane.getArriveDrome()) == null) {
            return -1;
        }
        if (companyMapper.selectByCode(plane.getCompany()) == null) {
            return -2;
        }
        planeMapper.insert(plane);
        return 1;
    }

    public int update(Plane plane) {
        if (cityMapper.selectByCityCode(plane.getStartDrome()) == null || cityMapper.selectByCityCode(plane.getArriveDrome()) == null) {
            return -1;
        }
        if (companyMapper.selectByCode(plane.getCompany()) == null) {
            return -2;
        }
        planeMapper.updateByPrimaryKey(plane);
        return 1;
    }
}
