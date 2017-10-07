package com.dreaouth.service;

import com.dreaouth.dao.PassengerMapper;
import com.dreaouth.dao.PlaneMapper;
import com.dreaouth.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerMapper passengerMapper;
    @Autowired
    private PlaneMapper planeMapper;

    public int insert(Passenger passenger){
        if (passengerMapper.selectByCard(passenger.getCard())==null){
            if (passenger.getPlaneId()>planeMapper.selectAll().size()){
                return -2;
            }
            passengerMapper.insert(passenger);
            return 1;
        }else {
            return -1;
        }
    }

    public List<Passenger> getList(){
        return passengerMapper.selectAll();
    }

    public boolean delete(String id){
        passengerMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public Passenger select(String card){
        return passengerMapper.selectByCard(card);
    }

    public boolean update(Passenger passenger){
        if (passenger.getPlaneId()>planeMapper.selectAll().size()){
            return false;
        }else {
            passengerMapper.updateByPrimaryKey(passenger);
            return true;
        }
    }
}
