package com.dreaouth.service;

import com.dreaouth.dao.CityMapper;
import com.dreaouth.dao.CompanyMapper;
import com.dreaouth.dao.PlaneMapper;
import com.dreaouth.encrypt.FinalFunction;
import com.dreaouth.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneMapper planeMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CompanyMapper companyMapper;

    public static int last_id = 4144;

    private byte[] key = {(byte) 0x2B, (byte) 0x7E, (byte) 0x15, (byte) 0x16, (byte) 0x28, (byte) 0xAE, (byte) 0xD2,
            (byte) 0xA6, (byte) 0xAB, (byte) 0xF7, (byte) 0x15, (byte) 0x88, (byte) 0x09, (byte) 0xCF, (byte) 0x4F,
            (byte) 0x3C};

    public List<Plane> getList() {
        List<Plane> list = planeMapper.selectAll();
        FinalFunction.DecryForPlanes(list, key);
        return list;
    }

    public List<Plane> select(Plane plane) {
        List<Plane> planes=new ArrayList<>();
        List<Plane> list = getList();
        for (Plane plane1:list){
            if (plane1.getStartDrome().equals(plane.getStartDrome()) && plane1.getArriveDrome().equals(plane.getArriveDrome())){
                planes.add(plane1);
            }
        }
        return planes;
    }

    public boolean delete(String id) {
        planeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public int insert(Plane plane) {
        plane.setId(last_id);
        if (cityMapper.selectByCityCode(plane.getStartDrome()) == null || cityMapper.selectByCityCode(plane.getArriveDrome()) == null) {
            return -1;
        }
        if (companyMapper.selectByCode(plane.getCompany()) == null) {
            return -2;
        }
        FinalFunction.EncryForPlane(plane, key);
        planeMapper.insert(plane);
        last_id ++ ;
        return 1;
    }

    public int update(Plane plane) {
        if (cityMapper.selectByCityCode(plane.getStartDrome()) == null || cityMapper.selectByCityCode(plane.getArriveDrome()) == null) {
            return -1;
        }
        if (companyMapper.selectByCode(plane.getCompany()) == null) {
            return -2;
        }
        FinalFunction.EncryForPlane(plane, key);
        planeMapper.updateByPrimaryKey(plane);
        return 1;
    }
}
