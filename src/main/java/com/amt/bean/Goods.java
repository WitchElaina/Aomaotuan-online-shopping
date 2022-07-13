package com.amt.bean;

public class Goods {
    private String goods_img;
    private Integer goods_id;
    private String goods_name;
    private Double goods_price;
    private Integer goods_num;
    private String type_name;
    private Double end_goods_price;
    private Integer type_id;

    public Goods() {

    }

    public Goods(Integer goods_id, String goods_name, Double goods_price, Integer goods_num, Integer type_id) {
//        this.goods_img = goods_img;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_num = goods_num;
//        this.type_name = type_name;
//        this.end_goods_price = end_goods_price;
        this.type_id = type_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Double getEnd_goods_price() {
        return end_goods_price;
    }

    public void setEnd_goods_price(Double end_goods_price) {
        this.end_goods_price = end_goods_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_img='" + goods_img + '\'' +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_num=" + goods_num +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
