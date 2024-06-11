package com.example.entity;

public class Business {
    /** ID */
    private Integer id;
    /** 商家名 */
    private String businessname;
    /** 销售量 */
    private Integer saleVolume;
    /** 商家评分 */
    private Double score;
    /** 商家图片 */
    private String image;
    /** 商家地址 */
    private String address;
    /** 商家电话 */
    private String phone;
    /** 商家起售价格 */
    private Integer beginExpense;
    /** 商家配送价格 */
    private Integer deliverExpense;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public Integer getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBeginExpense() {
        return beginExpense;
    }

    public void setBeginExpense(Integer beginExpense) {
        this.beginExpense = beginExpense;
    }

    public Integer getDeliverExpense() {
        return deliverExpense;
    }

    public void setDeliverExpense(Integer deliverExpense) {
        this.deliverExpense = deliverExpense;
    }
}
