package com.example.listycity;

public class City {
    private String name;
    private String province;
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }
    public String getName() {
        return name;
    }

    public void setName(String cityName) {
        this.name = cityName;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String provinceName) {
        this.province = provinceName;
    }


}
