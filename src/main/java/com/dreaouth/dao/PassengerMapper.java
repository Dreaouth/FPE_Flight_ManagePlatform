package com.dreaouth.dao;

import com.dreaouth.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Passenger record);

    Passenger selectByPrimaryKey(Integer id);

    List<Passenger> selectAll();

    int updateByPrimaryKey(Passenger record);
}