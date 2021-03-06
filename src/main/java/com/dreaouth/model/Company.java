package com.dreaouth.model;

public class Company {
    private Integer id;

    private String name;

    private String code;

    public Company(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Company(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Company() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}