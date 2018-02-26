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
 * @ClassName GoodsType
 * @Description 类的描述
 * @date 2018/2/25
 */
public class GoodsType {
    /**
     * id 主键
     */
    private Long id;

    /**
     * typeName 类型名
     */
    private String typeName;


    /**
     * get&set
     */
    public Long getId() {
        return id;
    }

    public GoodsType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public GoodsType setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }
}
