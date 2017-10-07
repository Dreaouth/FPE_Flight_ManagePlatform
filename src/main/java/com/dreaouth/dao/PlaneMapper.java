package com.dreaouth.dao;

import com.dreaouth.model.Plane;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plane record);

    Plane selectByPrimaryKey(Integer id);

    List<Plane> selectByDrome(Plane record);

    List<Plane> selectAll();

    int updateByPrimaryKey(Plane record);
}