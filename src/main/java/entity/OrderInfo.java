package entity;

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
     * storeId 商铺信息
     */
    private Long storeId;

    /**
     * goodsInfos 商品信息 包括商品信息和数量
     */
    private String goodsInfo;

    /**
     * goodsSumMoney 购买商品的总金额
     */
    private Double goodsSumMoney;

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getBuyerUserAccountId() {
        return buyerUserAccountId;
    }

    public void setBuyerUserAccountId(Long buyerUserAccountId) {
        this.buyerUserAccountId = buyerUserAccountId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Double getGoodsSumMoney() {
        return goodsSumMoney;
    }

    public void setGoodsSumMoney(Double goodsSumMoney) {
        this.goodsSumMoney = goodsSumMoney;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Boolean getCancellation() {
        return isCancellation;
    }

    public void setCancellation(Boolean cancellation) {
        isCancellation = cancellation;
    }


}

