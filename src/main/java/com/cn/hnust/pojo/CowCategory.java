package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class CowCategory {

    @Id
    @Column(name = "id")
    private Integer id;

    private String categoryname;

    private String description;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getState(){
        return state;
    }

    public void setState(Integer state)
    {
        this.state = state ;
    }
}