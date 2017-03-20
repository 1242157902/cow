package com.cn.hnust.pojo;

/**
 * User：    ysl
 * Date:   2017/3/1
 * Time:   14:12
 */
public class House {

    private CowHouse cowHouse;

    private String categoryname;
    private String managername;
    private String feetername;
    private String vetername;

    public House() {
    }

    public House(CowHouse cowHouse) {
        this.cowHouse = cowHouse;
    }

    public CowHouse getCowHouse() {
        return cowHouse;
    }

    public void setCowHouse(CowHouse cowHouse) {
        this.cowHouse = cowHouse;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getFeetername() {
        return feetername;
    }

    public void setFeetername(String feetername) {
        this.feetername = feetername;
    }

    public String getVetername() {
        return vetername;
    }

    public void setVetername(String vetername) {
        this.vetername = vetername;
    }


}
