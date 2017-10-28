package com.dreaouth.model;

public class Passenger {
    private Integer id;

    private String name;

    private Integer age;

    private Long tel;

    private String card;

    private String seat;

    private Integer planeId;

    public Passenger(Integer id, String name, Integer age, Long tel, String card, String seat, Integer planeId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.card = card;
        this.seat = seat;
        this.planeId = planeId;
    }

    public Passenger() {
    }

    public Passenger(String name, Integer age, Long tel, String card, String seat, Integer planeId) {
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.card = card;
        this.seat = seat;
        this.planeId = planeId;
    }

    public Passenger(String card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat == null ? null : seat.trim();
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }
}