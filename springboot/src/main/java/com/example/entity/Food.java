package com.example.entity;

public class Food {
    /** foodID */
    private Integer id;
    /** food名 */
    private String name;
    /** food价格 */
    private Double price;
    /** food图片 */
    private String image;
    /** 销售额 */
    private Integer saleVolume;
    /** 关联的商家ID */
    private Integer businessID;
    /** 关联的menuID */
    private Integer menuID;

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
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
    }

    public Integer getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Integer businessID) {
        this.businessID = businessID;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }
}
