package service;/********************************************************************
 /**
 * @Project: task001
 * @Package service
 * @author wujiancheng
 * @date 2018/1/28 0029 0:45
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import entity.StoreGoods;

import java.sql.SQLException;

/**
 * @author wujiancheng
 * @InterfaceName StoreGoodsService
 * @Description 商品
 * @date 2018/1/28 0029
 */
public interface StoreGoodsService {
    /**
     * @Title: deleteStoreGoodsById
     * @Description: 删除商品数据
     * @author wujiancheng
     * @date 2018/1/28
     * @param ID 传入一个要删除的id
     */
    public void deleteStoreGoodsById(Long ID);
    /**
     * @Title: addStoreGoods
     * @Description: 插入商品数据
     * @author wujiancheng
     * @date 2018/1/22
     * @param storeGoods 传入一个要添加的商品数据
     */
    public void addStoreGoods(StoreGoods storeGoods);
    /**
     * @Title: updateStoreGoodsById
     * @Description: 修改商品数据
     * @author wujiancheng
     * @date 2018/1/22
     * @param storeGoods 传入一个要修改的商品数据
     */
    public void updateStoreGoodsById(StoreGoods storeGoods) throws SQLException;
    /**
     * @Title: findStoreGoodsById
     * @Description: 查询商品数据
     * @author wujiancheng
     * @date 2018/1/22
     * @return 返回商品数据
     * @param ID 传入一个要查询的id
     */
    public StoreGoods findStoreGoodsById(Long ID);
}
