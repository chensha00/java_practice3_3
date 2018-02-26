package entity;/********************************************************************
 /**
 * @Project: java_practice(1)
 * @Package entity
 * @author lixinlong
 * @date 2018/1/29 16:59
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author lixinlong
 * @ClassName TheUser
 * @Description 用户
 * @date 2018/1/29
 */
public class TheUser {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户账户名
     */
    private String userAccountName;

    /**
     * 用户账户密码
     */
    private String userAccountPassword;

    /**
     * 支付密码
     */
    private Integer payingPassword;

    /**
     * 余额
     */
    private Double money;

    /**
     * 注册日期
     */
    private String registTime;

    /**
     * 是否卖家
     */
    private String tinyint;

    /**
     * 是否冻结
     */
    private String isFreezing;

    /**
     * 是否注销
     */
    private String isLost;

    /**
     * 是否删除
     */
    private String isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public String getUserAccountPassword() {
        return userAccountPassword;
    }

    public void setUserAccountPassword(String userAccountPassword) {
        this.userAccountPassword = userAccountPassword;
    }

    public Integer getPayingPassword() {
        return payingPassword;
    }

    public void setPayingPassword(Integer payingPassword) {
        this.payingPassword = payingPassword;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRegistTinyint() {
        return registTime;
    }

    public void setRegistTinyint(String registTinyint) {
        this.registTime = registTinyint;
    }

    public String getTinyint() {
        return tinyint;
    }

    public void setTinyint(String tinyint) {
        this.tinyint = tinyint;
    }

    public String getIsFreezing() {
        return isFreezing;
    }

    public void setIsFreezing(String isFreezing) {
        this.isFreezing = isFreezing;
    }

    public String getIsLost() {
        return isLost;
    }

    public void setIsLost(String isLost) {
        this.isLost = isLost;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public TheUser(Long id, String userAccountName, String userAccountPassword, Integer payingPassword, Double money, String registTime, String tinyint, String isFreezing, String isLost, String isDelete){
        this.id = id;
        this.userAccountName = userAccountName;
        this.userAccountPassword = userAccountPassword;
        this.payingPassword = payingPassword;
        this.money = money;
        this.registTime = registTime;
        this.tinyint = tinyint;
        this.isFreezing = isFreezing;
        this.isLost = isLost;
        this.isDelete = isDelete;
    }
}