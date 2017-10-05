package com.dreaouth.service;

import com.dreaouth.dao.CityMapper;
import com.dreaouth.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public int insert(City city) {
        if (cityMapper.selectByProvince(city.getProvince()).size() > 0) {
            if (cityMapper.selectByDrome(city.getDromename()) == null) {
                cityMapper.insert(city);
                return 1;
            }
            return -1;
        }
        return -2;
    }

    public List<City> getList() {
        return cityMapper.selectAll();
    }

    public boolean delete(String id) {
        cityMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public City select(String cityname) {
        return cityMapper.selectByCityName(cityname);
    }

    public int update(City city) {
        if (cityMapper.selectByProvince(city.getProvince()).size() > 0) {
            cityMapper.updateByPrimaryKey(city);
            return 1;
        }
        return -2;
    }
}
