package dao;/********************************************************************
 /**
 * @Project: task001
 * @Package dao
 * @author wujiancheng
 * @date 2018/1/28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.DataSourceUtils;
import entity.StoreGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author wujiancheng
 * @InterfaceName StoreGoodsDao
 * @Description 商铺商品表
 * @date 2018/1/28
 */
public interface StoreGoodsDao {
    /**
     * @Title:updateStoreGoodsById
     * @Description: 更新商品
     * @author wujiancheng
     * @date 2018/1/22
     * @throws SQLException
     */
    public Integer updateStoreGoodsById(StoreGoods storeGoods, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: deleteStoreGoodsById
     * @Description: 删除商品
     * @author wujiancheng
     * @date 2018/1/22
     * @throws SQLException
     */
    public Integer deleteStoreGoodsById(Long id, Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: addStoreGoods
     * @Description: 添加商品
     * @author wujiancheng
     * @date 2018/1/22
     * @throws SQLException
     */
    public Integer addStoreGoods(StoreGoods storeGoods,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: findStoreGoodsById
     * @Description: 查找商品
     * @author wujiancheng
     * @date 2018/1/22
     * @throws SQLException
     */
    public StoreGoods findStoreGoodsById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)throws SQLException;
}