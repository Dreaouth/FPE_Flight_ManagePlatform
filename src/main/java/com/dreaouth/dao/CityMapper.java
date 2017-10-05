package com.dreaouth.dao;

import com.dreaouth.model.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    City selectByPrimaryKey(Integer id);

    List<City> selectAll();

    int updateByPrimaryKey(City record);

    City selectByCityName(String cityname);

    List<City> selectByProvince(String province);

    City selectByDrome(String dromename);
}