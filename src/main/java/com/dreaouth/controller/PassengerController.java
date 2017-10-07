package com.dreaouth.controller;

import com.dreaouth.model.Passenger;
import com.dreaouth.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping("queryPassenger")
    public String queryPassengerList(HttpServletRequest request){
        List<Passenger> list=passengerService.getList();
        request.setAttribute("passengerlist",list);
        request.setAttribute("check","no");
        return "passenger_show";
    }

    @RequestMapping("selectPassenger")
    public String queryPassenger(HttpServletRequest request){
        String card=request.getParameter("sta_name");
        List<Passenger> passengerList=new ArrayList<>();
        Passenger passenger=passengerService.select(card);
        passengerList.add(passenger);
        request.setAttribute("passengerlist",passengerList);
        request.setAttribute("check","no");
        return "passenger_show";
    }

    @RequestMapping("insert")
    public String insert(){
        return "passenger_add";
    }

    @RequestMapping("insertPassenger")
    public String insertPassenger(HttpServletRequest request){
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String tel=request.getParameter("tel");
        String card=request.getParameter("card");
        String seat=request.getParameter("seat");
        String planeId=request.getParameter("planeId");
        try {
            Passenger passenger=new Passenger(name,Integer.parseInt(age),Long.parseLong(tel),card,seat,Integer.parseInt(planeId));
            int check=passengerService.insert(passenger);
            if (check==1){
                List<Passenger> list=passengerService.getList();
                request.setAttribute("passengerlist",list);
                request.setAttribute("check","add");
                return "passenger_show";
            }else if (check==-1){
                request.setAttribute("information","该身份证号已存在");
                return "failure";
            }else {
                request.setAttribute("information","不存在该航班号");
                return "failure";
            }
        }catch (Exception e){
            request.setAttribute("information","输入格式错误");
            return "failure";
        }
    }

    @RequestMapping("deletePassenger")
    public void deletePassenger(HttpServletRequest request){
        String id=request.getParameter("sta_id");
        passengerService.delete(id);
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("name",request.getParameter("name"));
        request.setAttribute("age",request.getParameter("age"));
        request.setAttribute("tel",request.getParameter("tel"));
        request.setAttribute("card",request.getParameter("card"));
        request.setAttribute("seat",request.getParameter("seat"));
        request.setAttribute("planeId",request.getParameter("planeId"));
        return "passenger_update";
    }

    @RequestMapping("updatePassenger")
    public String updatePassenger(HttpServletRequest request){
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String tel=request.getParameter("tel");
        String card=request.getParameter("card");
        String seat=request.getParameter("seat");
        String planeId=request.getParameter("planeId");
        try {
            Passenger passenger=new Passenger(Integer.parseInt(id),name,Integer.parseInt(age),Long.parseLong(tel),card,seat,Integer.parseInt(planeId));
            boolean check=passengerService.update(passenger);
            if (check){
                List<Passenger> list=passengerService.getList();
                request.setAttribute("passengerlist",list);
                request.setAttribute("check","update");
                return "passenger_show";
            }else {
                request.setAttribute("information","不存在该航班号");
                return "failure";
            }
        }catch (Exception e){
            request.setAttribute("information","输入格式错误");
            return "failure";
        }
    }
}
