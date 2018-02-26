package com.entity;

import java.util.Date;
import java.util.Random;

/**
 * @author zhengxin
 * @ClassName OrderInfo
 * @Description 订单类
 * @date 2018/1/29/029
 */
public class OrderInfo {
    /**
     * id 主键
     */
    private Long id;

    /**
     * orderNum 订单编号
     */
    private String orderNum;

    /**
     * orderStatus 订单状态 1- 待支付 2- 已支付 3-已发货 4-已送达 5-已收货 6-交易成功 7-交易未成功
     */
    private Byte orderStatus;

    /**
     * buyerUserAccountId 买家信息
     */
    private Long buyerUserAccountId;

    /**
     * storeGoodsId 商铺商品信息
     */
    private Long storeGoodsId;

    /**
     * goodsSumMoney 购买商品的总金额
     */
    private Double goodsSumMoney;

    /**
     * message 订单留言
     */
    private String message;

    /**
     * orderTime 下单时间 yyyy-MM-dd HH:mm:ss
     */
    private Date orderTime;

    /**
     * deliverTime 发货时间 yyyy-MM-dd HH:mm:ss
     */
    private Date deliverTime;

    /**
     * successTime 交易成功时间 yyyy-MM-dd HH:mm:ss
     */
    private Date successTime;

    /**
     * isCancellation 订单是否作废 -true 作废  -false 没有作废
     */
    private Boolean isCancellation;

    /**
     * @Title: OrderInfo
     * @Description: 构造器
     * @author jiangxiangwen
     * @date 2018/1/14
     */
    public OrderInfo(){
        Random random=new Random();
        Long data=System.currentTimeMillis();
        this.orderNum=data.toString()+random.nextInt(100);
    }

//    /**
//     * @Title:
//     * @Description: 方法描述
//     * @author jiangxiangwen
//     * @date 2018/1/14
//     * @param buyerInfo 买家信息
//     * @param goodsInfoMap 商品集合
//
//     */
//    public OrderInfo(Person buyerInfo, Person seller, Map<Goods,Double> goodsInfoMap) {
//        Set<Map.Entry<Goods,Double>> entryMap=goodsInfoMap.entrySet();
//        Iterator<Map.Entry<Goods,Double>> entryIterator=entryMap.iterator();
//        String str="";
//        while (entryIterator.hasNext()){
//            Map.Entry<Goods,Double> newEntryMap=entryIterator.next();
//
//            Double sum=newEntryMap.getKey().getGoodsPrice()*newEntryMap.getValue();
//            sumGoodsMoney=sumGoodsMoney+sum;
//            str=str+newEntryMap.getKey().getGoodsName()+"*"+newEntryMap.getValue()+"*"+newEntryMap.getKey().getGoodsPrice()+" ";
//        }
//        System.out.println("总金额："+sumGoodsMoney);
//        Random random=new Random();
//        Long data=System.currentTimeMillis();
//        this.orderNumId=data.toString()+random.nextInt(100);
//        this.buyerInfo = buyerInfo.getId();
//        this.sellerInfo=seller.getId();
//        this.goodsInfo = str;
//        this.sumGoodsMoney = sumGoodsMoney;
//        this.orderTime = new Date();
//        this.deliverTime = new Date();
//        this.successTime = new Date();
//        this.isOrderCancellation = false;
//    }




    /**
     * 以下是属性的get和set方法
     */
    public Long getId() {
        return id;
    }

    public OrderInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public OrderInfo setOrderNum(String orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public OrderInfo setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Long getBuyerUserAccountId() {
        return buyerUserAccountId;
    }

    public OrderInfo setBuyerUserAccountId(Long buyerUserAccountId) {
        this.buyerUserAccountId = buyerUserAccountId;
        return this;
    }

    public Long getStoreGoodsId() {
        return storeGoodsId;
    }

    public OrderInfo setStoreGoodsId(Long storeGoodsId) {
        this.storeGoodsId = storeGoodsId;
        return this;
    }

    public Double getGoodsSumMoney() {
        return goodsSumMoney;
    }

    public OrderInfo setGoodsSumMoney(Double goodsSumMoney) {
        this.goodsSumMoney = goodsSumMoney;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public OrderInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public OrderInfo setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public OrderInfo setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
        return this;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public OrderInfo setSuccessTime(Date successTime) {
        this.successTime = successTime;
        return this;
    }

    public Boolean getCancellation() {
        return isCancellation;
    }

    public OrderInfo setCancellation(Boolean cancellation) {
        isCancellation = cancellation;
        return this;
    }
}

