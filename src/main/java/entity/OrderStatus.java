package entity; /**
 * @Project: shopping
 * @Package entity
 * @author jiangxiangwen
 * @date 2018/2/4
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


/**
 * @author jiangxiangwen
 * @ClassName OrderStatus
 * @Description 类的描述
 * @date 2018/2/4
 */
public enum OrderStatus {

    UNPAID((byte)1,"待支付"),PAID((byte)2,"已支付"),UNDELIVERED((byte)3,"代发货"),
    DELIVERED((byte)4,"已发货"),ARRIVED((byte)5,"已送达"),RECEIVED((byte)6,"已收货"),
    TRADE_SUCCESS((byte)7,"交易成功"),TRADE_DEFEATED((byte)8,"交易未成功");

    private byte statusId;
    private String statusName;
    OrderStatus(byte statusId,String statusName ){
        this.statusId=statusId;
        this.statusName=statusName;
    }

    public byte getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }
}
