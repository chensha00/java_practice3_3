package com.entity;

import java.util.Date;

/**
 * @author wujunnan
 * @ClassName tttt
 * @Description 类描述
 * @date 2018/1/30
 */
public class UserAccount {
    //用户id
    private Long id;
    //用户名
    private String userName;
    //用户密码
    private String userPassWord;
    //支付密码
    private Integer payPassWord;
    //余额
    private Double money;
    //电话号码
    private String phoneNum;
    //收货地址
    private String address;
    //注册日期
    private Date registerTime;
    //是否卖家
    private Byte isBuyer;
    //是否冻结 1--是,0--否
    private Byte isFreezing;
    //是否注销 1--是,0--否'
    private Byte isLost;
    //是否删除 1--是,0--否
    private Byte isDelete;



    /**
     * @Title:
     * @Description: 构造方法
     * @author WuJunNan
     * @param id
     * @param userName
     * @param userPassWord
     * @param payPassWord
     * @param money
     * @param registerTime
     * @param isBuyer
     * @param isFreezing
     * @param isLost
     * @param isDelete
     */
    public UserAccount(Long id, String userName, String userPassWord, Integer payPassWord, Double money, String phoneNum, String address, Date registerTime, Byte isBuyer, Byte isFreezing, Byte isLost, Byte isDelete) {
        this.id = id;
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.payPassWord = payPassWord;
        this.money = money;
        this.phoneNum = phoneNum;
        this.address = address;
        this.registerTime = registerTime;
        this.isBuyer = isBuyer;
        this.isFreezing = isFreezing;
        this.isLost = isLost;
        this.isDelete = isDelete;
    }

    public UserAccount(){

    }

    @Override
    public String toString() {
        return "ID:      " + id +"\n"+
                "用户名：  " + userName +"\n"+
                "密码：    " + userPassWord +"\n"+
                "支付密码： " + payPassWord +"\n"+
                "卡上余额： " + money +"\n"+
                "电话号码： " + phoneNum +"\n"+
                "收货地址： " + address +"\n"+
                "注册时间： " + registerTime +"\n"+
                "是否卖家： " + isBuyer +"\n"+
                "是否冻结： " + isFreezing +"\n"+
                "是否注销： " + isLost +"\n"+
                "是否删除： " + isDelete;
    }


    /*
     * get & set 方法
     */
    public Long getId() {
        return id;
    }

    public UserAccount setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserAccount setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public UserAccount setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
        return this;
    }

    public Integer getPayPassWord() {
        return payPassWord;
    }

    public UserAccount setPayPassWord(Integer payPassWord) {
        this.payPassWord = payPassWord;
        return this;
    }

    public Double getMoney() {
        return money;
    }

    public UserAccount setMoney(Double money) {
        this.money = money;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public UserAccount setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserAccount setAddress(String address) {
        this.address = address;
        return this;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public UserAccount setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    public Byte getIsBuyer() {
        return isBuyer;
    }

    public UserAccount setIsBuyer(Byte isBuyer) {
        this.isBuyer = isBuyer;
        return this;
    }

    public Byte getIsFreezing() {
        return isFreezing;
    }

    public UserAccount setIsFreezing(Byte isFreezing) {
        this.isFreezing = isFreezing;
        return this;
    }

    public Byte getIsLost() {
        return isLost;
    }

    public UserAccount setIsLost(Byte isLost) {
        this.isLost = isLost;
        return this;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public UserAccount setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
        return this;
    }
}