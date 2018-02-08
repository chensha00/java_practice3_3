package entity;

import java.util.Date;

/**
 * @author wujunnan
 * @ClassName PayWater
 * @Description 支付流水实体类
 * @date 2018/2/1
 */
public class PayWater {
    //主键id
    private Long id;
    //买家信息
    private Long buyerUserAccountId;
    //卖家信息
    private Long sellerUserAccountId;
    //流水编号
    private Double payWaterNumber;
    //记录类型,1-收入，0-支出
    private Byte recordType;
    //交易金额
    private Double transactionAmount;
    //创建交易时间 yyyy-MM-dd HH:mm:ss
    private Date createTransaction;
    //交易完成时间 yyyy-MM-dd HH:mm:ss
    private Date transactionTime;
    /**
     * @Title:
     * @Description: 构造方法
     * @author WuJunNan
     * @param buyerUserAccountId 买家信息
     * @param sellerUserAccount_id 卖家信息
     * @param payWaterNumber 流水编号
     * @param recordType 记录类型,1-收入，0-支出
     * @param transactionAmount 交易金额
     * @param createTransaction 创建交易时间 yyyy-MM-dd HH:mm:ss
     * @param transactionTime 交易完成时间 yyyy-MM-dd HH:mm:ss
     */
    public PayWater(Long buyerUserAccountId, Long sellerUserAccount_id, Double payWaterNumber, Byte recordType, Double transactionAmount, Date createTransaction, Date transactionTime) {
        this.buyerUserAccountId = buyerUserAccountId;
        this.sellerUserAccountId = sellerUserAccount_id;
        this.payWaterNumber = payWaterNumber;
        this.recordType = recordType;
        this.transactionAmount = transactionAmount;
        this.createTransaction = createTransaction;
        this.transactionTime = transactionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerUserAccountId() {
        return buyerUserAccountId;
    }

    public void setBuyerUserAccountId(Long buyerUserAccountId) {
        this.buyerUserAccountId = buyerUserAccountId;
    }

    public Long getSellerUserAccountId() {
        return sellerUserAccountId;
    }

    public void setSellerUserAccountId(Long sellerUserAccountId) {
        this.sellerUserAccountId = sellerUserAccountId;
    }

    public Double getPayWaterNumber() {
        return payWaterNumber;
    }

    public void setPayWaterNumber(Double payWaterNumber) {
        this.payWaterNumber = payWaterNumber;
    }

    public Byte getRecordType() {
        return recordType;
    }

    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getCreateTransaction() {
        return createTransaction;
    }

    public void setCreateTransaction(Date createTransaction) {
        this.createTransaction = createTransaction;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }
    /**
     * @Title: toString
     * @Description: 重写toString方法
     * @author WuJunNan
     * @return 返回对象的所有数据
     */
    @Override
    public String toString() {
        return "主键ID：     " + id +"\n"+
                "买家信息：   " + buyerUserAccountId +"\n"+
                "卖家信息：   " + sellerUserAccountId +"\n"+
                "流水编号：   " + payWaterNumber +"\n"+
                "记录类型：   " + recordType +"\n"+
                "交易金额：   " + transactionAmount +"\n"+
                "订单创建时间：" + createTransaction +"\n"+
                "交易成功时间：" + transactionTime ;
    }
}