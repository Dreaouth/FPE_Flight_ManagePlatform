package com.dreaouth.controller;

import com.dreaouth.model.Plane;
import com.dreaouth.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/plane")
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    @RequestMapping("queryPlane")
    public String queryPlaneList(HttpServletRequest request){
        List<Plane> list=planeService.getList();
        request.setAttribute("planelist",list);
        request.setAttribute("check","no");
        return "plane_show";
    }

    @RequestMapping("selectPlane")
    public String queryPlane(HttpServletRequest request){
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        Plane plane=new Plane(start,end);
        List<Plane> list=planeService.select(plane);
        request.setAttribute("planelist",list);
        request.setAttribute("check","no");
        return "plane_show";
    }

    @RequestMapping("insert")
    public String insert(){
        return "plane_add";
    }

    @RequestMapping("insertPlane")
    public String insertPlane(HttpServletRequest request){
        String start_drome=request.getParameter("start_drome");
        String arrive_drome=request.getParameter("arrive_drome");
        String company=request.getParameter("company");
        String airlineCode=request.getParameter("airlineCode");
        String start_time=request.getParameter("start_time");
        String arrive_time=request.getParameter("arrive_time");
        start_time = start_time.trim();
        arrive_time = arrive_time.trim();
        String mode=request.getParameter("mode");
        String date=request.getParameter("date");
        String number=request.getParameter("number");
        String price=request.getParameter("price");
        try{
            Plane plane=new Plane(start_drome,arrive_drome,company,airlineCode,start_time,arrive_time,mode,date,Integer.parseInt(number),Integer.parseInt(price));
            int check=planeService.insert(plane);
            if (check==1){
                List<Plane> list=planeService.getList();
                request.setAttribute("planelist",list);
                request.setAttribute("check","add");
                return "plane_show";
            }else if (check==-1){
                request.setAttribute("information","输入错误，不存在该机场");
                return "failure";
            }else {
                request.setAttribute("information","输入错误，不存在该航空公司");
                return "failure";
            }
        }catch (Exception e){
            request.setAttribute("information","输入格式错误");
            return "failure";
        }
    }

    @RequestMapping("deletePlane")
    public void deletePlane(HttpServletRequest request){
        String id=request.getParameter("sta_id");
        planeService.delete(id);
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("start_drome",request.getParameter("start_drome"));
        request.setAttribute("arrive_drome",request.getParameter("arrive_drome"));
        request.setAttribute("company",request.getParameter("company"));
        request.setAttribute("airlineCode",request.getParameter("airlineCode"));
        request.setAttribute("start_time",request.getParameter("start_time"));
        request.setAttribute("arrive_time",request.getParameter("arrive_time"));
        request.setAttribute("mode",request.getParameter("mode"));
        request.setAttribute("date",request.getParameter("date"));
        request.setAttribute("number",request.getParameter("number"));
        request.setAttribute("price",request.getParameter("price"));
        return "plane_update";
    }

    @RequestMapping("updatePlane")
    public String updatePlane(HttpServletRequest request){
        String id=request.getParameter("id");
        String start_drome=request.getParameter("start_drome");
        String arrive_drome=request.getParameter("arrive_drome");
        String company=request.getParameter("company");
        String airlineCode=request.getParameter("airlineCode");
        String start_time=request.getParameter("start_time");
        String arrive_time=request.getParameter("arrive_time");
        start_time = start_time.trim();
        arrive_time = arrive_time.trim();
        String mode=request.getParameter("mode");
        String date=request.getParameter("date");
        String number=request.getParameter("number");
        String price=request.getParameter("price");
        try{
            Plane plane=new Plane(Integer.parseInt(id),start_drome,arrive_drome,company,airlineCode,start_time,arrive_time,mode,date,Integer.parseInt(number),Integer.parseInt(price));
            int check=planeService.update(plane);
            if (check==1){
                List<Plane> list=planeService.getList();
                request.setAttribute("planelist",list);
                request.setAttribute("check","update");
                return "plane_show";
            }else if (check==-1){
                request.setAttribute("information","输入错误，不存在该机场");
                return "failure";
            }else {
                request.setAttribute("information","输入错误，不存在该航空公司");
                return "failure";
            }
        }catch (Exception e){
            request.setAttribute("information","输入格式错误");
            return "failure";
        }
    }
}
