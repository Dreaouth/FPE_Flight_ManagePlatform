package com.dreaouth.model;

public class Plane {
    private Integer id;

    private String startDrome;

    private String arriveDrome;

    private String company;

    private String airlinecode;

    private String startTime;

    private String arriveTime;

    private String mode;

    private String date;

    private Integer number;

    private Integer price;

    public Plane() {
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", startDrome='" + startDrome + '\'' +
                ", arriveDrome='" + arriveDrome + '\'' +
                ", company='" + company + '\'' +
                ", airlinecode='" + airlinecode + '\'' +
                ", startTime='" + startTime + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                ", mode='" + mode + '\'' +
                ", date='" + date + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }

    public Plane(String startDrome, String arriveDrome) {
        this.startDrome = startDrome;
        this.arriveDrome = arriveDrome;
    }

    public Plane(Integer id, String startDrome, String arriveDrome, String company, String airlinecode, String startTime, String arriveTime, String mode, String date, Integer number, Integer price) {
        this.id = id;
        this.startDrome = startDrome;
        this.arriveDrome = arriveDrome;
        this.company = company;
        this.airlinecode = airlinecode;
        this.startTime = startTime;
        this.arriveTime = arriveTime;
        this.mode = mode;
        this.date = date;
        this.number = number;
        this.price = price;
    }

    public Plane(String startDrome, String arriveDrome, String company, String airlinecode, String startTime, String arriveTime, String mode, String date, Integer number, Integer price) {
        this.startDrome = startDrome;
        this.arriveDrome = arriveDrome;
        this.company = company;
        this.airlinecode = airlinecode;
        this.startTime = startTime;
        this.arriveTime = arriveTime;
        this.mode = mode;
        this.date = date;
        this.number = number;
        this.price = price;
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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