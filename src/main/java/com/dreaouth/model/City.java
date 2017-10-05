package com.dreaouth.model;

public class City {
    private Integer id;

    private String province;

    private String cityname;

    private String citycode;

    private String dromename;


    public City(String province, String cityname, String citycode, String dromename) {
        this.province = province;
        this.cityname = cityname;
        this.citycode = citycode;
        this.dromename = dromename;
    }

    public City(Integer id, String province, String cityname, String citycode, String dromename) {
        this.id = id;
        this.province = province;
        this.cityname = cityname;
        this.citycode = citycode;
        this.dromename = dromename;
    }

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getDromename() {
        return dromename;
    }

    public void setDromename(String dromename) {
        this.dromename = dromename == null ? null : dromename.trim();
    }
}