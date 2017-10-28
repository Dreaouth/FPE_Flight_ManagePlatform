package com.dreaouth.controller;

import com.dreaouth.encrypt.FinalFunction;
import com.dreaouth.model.Passenger;
import com.dreaouth.model.Plane;
import com.dreaouth.service.PassengerService;
import com.dreaouth.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/encrypt")
public class EncryptController {

    private byte[] key = {(byte) 0x2B, (byte) 0x7E, (byte) 0x15, (byte) 0x16, (byte) 0x28, (byte) 0xAE, (byte) 0xD2,
            (byte) 0xA6, (byte) 0xAB, (byte) 0xF7, (byte) 0x15, (byte) 0x88, (byte) 0x09, (byte) 0xCF, (byte) 0x4F,
            (byte) 0x3C};

    @Autowired
    private PlaneService planeService;
    @Autowired
    private PassengerService passengerService;

    private static String encrypt="加密";
    private static String encrypt_passenger="加密";

    @RequestMapping("Plane")
    public String queryPlaneList(HttpServletRequest request) {
        List<Plane> list = planeService.getList();
        encrypt = "解密";
        request.setAttribute("planelist", list);
        request.setAttribute("check", "no");
        request.setAttribute("encrypt", "加密");
        return "encryptPlane";
    }

    @RequestMapping("encryptPlane")
    public String encryptPlaneList(HttpServletRequest request) {
        List<Plane> list = planeService.getList();
        if (encrypt.equals("加密")){
            encrypt = "解密";
            request.setAttribute("check", "decrypt");
            request.setAttribute("encrypt", "加密");
        }else {
            encrypt = "加密";
            FinalFunction.EecryForPlanes(list, key);
            request.setAttribute("check", "encrypt");
            request.setAttribute("encrypt", "解密");
        }
        request.setAttribute("planelist", list);
        return "encryptPlane";
    }

    @RequestMapping("selectPlane")
    public String queryPlane(HttpServletRequest request) {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        Plane plane = new Plane(start, end);
        List<Plane> list = planeService.select(plane);
        request.setAttribute("planelist", list);
        request.setAttribute("check", "no");
        request.setAttribute("encrypt", "加密");
        return "encryptPlane";
    }

    @RequestMapping("Passenger")
    public String queryPassengerList(HttpServletRequest request){
        encrypt_passenger="解密";
        List<Passenger> list=passengerService.getList();
        request.setAttribute("passengerlist",list);
        request.setAttribute("check","no");
        request.setAttribute("encrypt","加密");
        return "encryptPassenger";
    }

    @RequestMapping("selectPassenger")
    public String queryPassenger(HttpServletRequest request){
        String card=request.getParameter("sta_name");
        List<Passenger> passengerList=new ArrayList<>();
        Passenger passenger=passengerService.select(card);
        passengerList.add(passenger);
        request.setAttribute("passengerlist",passengerList);
        request.setAttribute("check","no");
        request.setAttribute("encrypt", "加密");
        return "encryptPassenger";
    }

    @RequestMapping("encryptPassenger")
    public String encryptPassenger(HttpServletRequest request) {
        List<Passenger> list=passengerService.getList();
        if (encrypt_passenger.equals("加密")){
            encrypt_passenger = "解密";
            request.setAttribute("check", "decrypt");
            request.setAttribute("encrypt", "加密");
        }else {
            encrypt_passenger = "加密";
            FinalFunction.EncryForPassengers(list, key);
            request.setAttribute("check", "encrypt");
            request.setAttribute("encrypt", "解密");
        }
        request.setAttribute("passengerlist", list);
        return "encryptPassenger";
    }
}
