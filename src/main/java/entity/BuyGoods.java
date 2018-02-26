package entity;/**
 * Created by Administrator on 2018/1/29.
 */

import java.util.Date;

/**
 * @author zhouxiang
 * @ClassName BuyGoods
 * @Description 购买商品实体类
 * @date 2018/1/29
 */
public class BuyGoods {
    /**
     * Id 主键
     */
    private Long ID;

    /**
     * ID 购买商品的账户
     */
    private Long UserAccountID;

    /**
     * ID 购买商品的订单
     */
    private Long OrderInfoID;

    /**
     * ID 商铺商品
     */
    private Long StoreID;

    /**
     * goodsNum 购买的商品数量
     */
    private Double goodsNum;

    /**
     * buyGoodsDate 购买商品的时间
     */
    private Date buyGoodsDate;

    /**
     *封装
     */
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getUserAccountID() {
        return UserAccountID;
    }

    public void setUserAccountID(Long userAccountID) {
        UserAccountID = userAccountID;
    }

    public Long getOrderInfoID() {
        return OrderInfoID;
    }

    public void setOrderInfoID(Long orderInfoID) {
        OrderInfoID = orderInfoID;
    }

    public Long getStoreID() {
        return StoreID;
    }

    public void setStoreID(Long storeID) {
        StoreID = storeID;
    }

    public Double getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Double goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getBuyGoodsDate() {
        return buyGoodsDate;
    }

    public void setBuyGoodsDate(Date buyGoodsDate) {
        this.buyGoodsDate = buyGoodsDate;
    }
}

