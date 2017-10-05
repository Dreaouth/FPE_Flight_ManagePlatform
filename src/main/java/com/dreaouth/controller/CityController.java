package com.dreaouth.controller;

import com.dreaouth.model.City;
import com.dreaouth.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("queryCity")
    public String queryCityList(HttpServletRequest request) {
        List<City> list = cityService.getList();
        request.setAttribute("citylist", list);
        request.setAttribute("check", "no");
        return "city_show";
    }

    @RequestMapping("selectCity")
    public String queryCity(HttpServletRequest request) {
        String cityname = request.getParameter("sta_name");
        List<City> cityList = new ArrayList<>();
        City city = cityService.select(cityname);
        cityList.add(city);
        request.setAttribute("citylist", cityList);
        request.setAttribute("check", "no");
        return "city_show";
    }

    @RequestMapping("insert")
    public String insert(HttpServletRequest request) {
        return "city_add";
    }

    @RequestMapping("insertCity")
    public String insertCity(HttpServletRequest request) {
        String cityname = request.getParameter("add_cityname");
        String province = request.getParameter("add_province");
        String citycode = request.getParameter("add_citycode");
        String drome = request.getParameter("add_drome");
        City city = new City(province, cityname, citycode, drome);
        int check = cityService.insert(city);
        if (check == 1) {
            List<City> list = cityService.getList();
            request.setAttribute("citylist", list);
            request.setAttribute("check", "ok");
            return "city_show";
        } else if (check == -1) {
            request.setAttribute("information", "该机场已存在");
            return "failure";
        } else {
            request.setAttribute("information", "不存在该省份");
            return "failure";
        }
    }

    @RequestMapping("deleteCity")
    public void deleteCity(HttpServletRequest request){
        String id=request.getParameter("sta_id");
        cityService.delete(id);
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request){
        request.setAttribute("add_id",request.getParameter("add_id"));
        request.setAttribute("add_cityname",request.getParameter("add_cityname"));
        request.setAttribute("add_citycode",request.getParameter("add_citycode"));
        request.setAttribute("add_province",request.getParameter("add_province"));
        request.setAttribute("add_drome",request.getParameter("add_drome"));
        return "city_update";
    }

    @RequestMapping("updateCity")
    public String updateCity(HttpServletRequest request){
        String id=request.getParameter("add_id");
        String cityname = request.getParameter("add_cityname");
        String province = request.getParameter("add_province");
        String citycode = request.getParameter("add_citycode");
        String drome = request.getParameter("add_drome");
        City city = new City(Integer.parseInt(id),province, cityname, citycode, drome);
        int check = cityService.update(city);
        if (check == 1) {
            List<City> list = cityService.getList();
            request.setAttribute("citylist", list);
            request.setAttribute("check", "ok_update");
            return "city_show";
        } else {
            request.setAttribute("information", "不存在该省份");
            return "failure";
        }
    }
}
