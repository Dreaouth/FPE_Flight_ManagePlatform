package com.dreaouth.model;

import java.util.Date;

public class Plane {
    private Integer id;

    private String startDrome;

    private String arriveDrome;

    private String company;

    private String airlinecode;

    private Date startTime;

    private Date arriveTime;

    private String mode;

    private Date date;

    private Integer number;

    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDrome() {
        return startDrome;
    }

    public void setStartDrome(String startDrome) {
        this.startDrome = startDrome == null ? null : startDrome.trim();
    }

    public String getArriveDrome() {
        return arriveDrome;
    }

    public void setArriveDrome(String arriveDrome) {
        this.arriveDrome = arriveDrome == null ? null : arriveDrome.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAirlinecode() {
        return airlinecode;
    }

    public void setAirlinecode(String airlinecode) {
        this.airlinecode = airlinecode == null ? null : airlinecode.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}