package com.dreaouth.service;

import com.dreaouth.dao.PassengerMapper;
import com.dreaouth.dao.PlaneMapper;
import com.dreaouth.encrypt.FinalFunction;
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

    private byte[] key = { (byte) 0x2B, (byte) 0x7E, (byte) 0x15, (byte) 0x16, (byte) 0x28, (byte) 0xAE, (byte) 0xD2,
            (byte) 0xA6, (byte) 0xAB, (byte) 0xF7, (byte) 0x15, (byte) 0x88, (byte) 0x09, (byte) 0xCF, (byte) 0x4F,
            (byte) 0x3C };

    public static int last_id = 4;

    public int insert(Passenger passenger){
        passenger.setId(last_id);
        if (passengerMapper.selectByCard(passenger.getCard())==null){
            if (passenger.getPlaneId()>planeMapper.selectAll().size()){
                return -2;
            }
            FinalFunction.EncryForPassenger(passenger,key);
            passengerMapper.insert(passenger);
            last_id ++;
            return 1;
        }else {
            return -1;
        }
    }

    public List<Passenger> getList(){
        List<Passenger> list=passengerMapper.selectAll();
        FinalFunction.DecryForPassengers(list,key);
        return list;
    }

    public boolean delete(String id){
        passengerMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return true;
    }

    public Passenger select(String card){
        List<Passenger> list=getList();
        for (Passenger passenger:list){
            if (passenger.getCard().equals(card) || passenger.getName().equals(card)){
                return passenger;
            }
        }
        return null;
    }

    public boolean update(Passenger passenger){
        if (passenger.getPlaneId()>planeMapper.selectAll().size()){
            return false;
        }else {
            FinalFunction.EncryForPassenger(passenger,key);
            passengerMapper.updateByPrimaryKey(passenger);
            return true;
        }
    }
}
