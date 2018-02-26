package com.entity; /**
 * @Project: shopping
 * @Package entity
 * @author jiangxiangwen
 * @date 2018/2/25
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import javax.xml.crypto.Data;

/**
 * @author jiangxiangwen
 * @ClassName StoreGoods
 * @Description 商铺商品
 * @date 2018/2/25
 */
public class StoreGoods {
    /**
     * id 主键
     */
    private Long id;

    /**
     * store 商铺
     */
    private Store store;

    /**
     * goodsName 商铺名
     */
    private String goodsName;

    /**
     * goodsNum 商品数量
     */
    private Double goodsNum;

    /**
     * goodsPrice 商品价格
     */
    private Double goodsPrice;

    /**
     * goodsDiscount 商品折扣 1-10之间 默认10
     */
    private Double goodsDiscount=10.0;

    /**
     * goodsType 商品类型
     */
    private GoodsType goodsType;

    /**
     * productionAddress 生产地址
     */
    private String productionAddress;

    /**
     * producedDate 生产时间 yyyy-MM-dd
     */
    private Data producedDate;

    /**
     * shelfLife 保质期
     */
    private Integer shelfLife;

    /**
     * shelfLifeType 保质期类型 1-年 2-月 3-日 4-小时
     */
    private Byte shelfLifeType;


    /**
     * get&set
     */
    public Long getId() {
        return id;
    }

    public StoreGoods setId(Long id) {
        this.id = id;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public StoreGoods setStore(Store store) {
        this.store = store;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public StoreGoods setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public Double getGoodsNum() {
        return goodsNum;
    }

    public StoreGoods setGoodsNum(Double goodsNum) {
        this.goodsNum = goodsNum;
        return this;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public StoreGoods setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Double getGoodsDiscount() {
        return goodsDiscount;
    }

    public StoreGoods setGoodsDiscount(Double goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
        return this;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public StoreGoods setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
        return this;
    }

    public String getProductionAddress() {
        return productionAddress;
    }

    public StoreGoods setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress;
        return this;
    }

    public Data getProducedDate() {
        return producedDate;
    }

    public StoreGoods setProducedDate(Data producedDate) {
        this.producedDate = producedDate;
        return this;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public StoreGoods setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
        return this;
    }

    public Byte getShelfLifeType() {
        return shelfLifeType;
    }

    public StoreGoods setShelfLifeType(Byte shelfLifeType) {
        this.shelfLifeType = shelfLifeType;
        return this;
    }
}
