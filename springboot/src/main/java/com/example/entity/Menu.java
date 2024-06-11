package com.example.entity;

public class Menu {
    /** ID */
    private Integer id;
    /** 类型 */
    private String type;
    /** 关联的商家ID */
    private Integer businessID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Integer businessID) {
        this.businessID = businessID;
    }
}
