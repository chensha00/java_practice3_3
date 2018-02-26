package com.entity; /**
 * @Project: shopping
 * @Package entity
 * @author jiangxiangwen
 * @date 2018/2/25
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


/**
 * @author jiangxiangwen
 * @ClassName Store
 * @Description 类的描述
 * @date 2018/2/25
 */
public class Store {
    /**
     * id 主键
     */
    private Long id;

    /**
     * storeName 商铺名
     */
    private String storeName;

    /**
     * userAccount 卖家账户
     */
    private UserAccount userAccount;

    /**
     * isFreezing 是否冻结 1--是,0--否
     */
    private Boolean isFreezing;

    /**
     * isLost 是否注销 1--是,0--否
     */
    private Boolean isLost;

    /**
     * isDelete 是否删除 1--是,0--否
     */
    private Boolean isDelete;


    /**
     * get&set
     */
    public Long getId() {
        return id;
    }

    public Store setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStoreName() {
        return storeName;
    }

    public Store setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Store setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
        return this;
    }

    public Boolean getFreezing() {
        return isFreezing;
    }

    public Store setFreezing(Boolean freezing) {
        isFreezing = freezing;
        return this;
    }

    public Boolean getLost() {
        return isLost;
    }

    public Store setLost(Boolean lost) {
        isLost = lost;
        return this;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public Store setDelete(Boolean delete) {
        isDelete = delete;
        return this;
    }
}
