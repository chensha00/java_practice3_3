package dao;/********************************************************************
 /**
 * @Project: task001
 * @Package dao
 * @author wujiancheng
 * @date 2018/1/28  23:00
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import common.util.DataSourceUtils;
import entity.*;
import entity.PersonInfo;
import entity.StoreGoods;

import java.sql.*;

/**
 * @author wujiancheng
 * @ClassName StoreGoodsDaoImpl
 * @Description 商品接口实现
 * @date 2018/1/28
 */
public class StoreGoodsDaoImpl implements StoreGoodsDao {

    /**
     * @param storeGoods,connection,preparedStatement,dataSourceUtils
     * @return Integer rows
     * @throws SQLException
     * @Title: updateStoreGoodsById
     * @Description: 根据商品ID更新
     * @author wujiancheng
     * @date 2018/1/28
     */
    @Override
    public Integer updateStoreGoodsById(StoreGoods storeGoods, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //更新SQL
        preparedStatement = connection.prepareStatement("UPDATE store_goods SET STORE_ID=?,GOODS_NAME =?,GOODS_NUM=?,GOODS_PRICE =?,GOODS_TYPE_ID=?,BRAND=?,PRODUCTION_ADDRESS=?,PRODUCED_DATE=?, SHELF_LIFE=?, SHELF_LIFE_TYPE=?  WHERE ID=?");
        //将数据放入SQL语句
        preparedStatement.setInt(1, storeGoods.getSTORE_ID());
        preparedStatement.setString(2, storeGoods.getGOODS_NAME());
        preparedStatement.setDouble(3, storeGoods.getGOODS_NUM());
        preparedStatement.setDouble(4, storeGoods.getGOODS_PRICE());
        preparedStatement.setInt(5, storeGoods.getGOODS_TYPE_ID());

        preparedStatement.setString(6, storeGoods.getBRAND());
        preparedStatement.setString(7, storeGoods.getPRODUCTION_ADDRESS());
        preparedStatement.setDate(8, (Date) storeGoods.getPRODUCED_DATE());
        preparedStatement.setInt(9, storeGoods.getSHELF_LIFE());
        preparedStatement.setString(10, storeGoods.getSHELF_LIFE_TYPE());

        preparedStatement.setInt(11, storeGoods.getID());
        //获得受影响的行数
        Integer rows = preparedStatement.executeUpdate();
        //提交
        connection.commit();
//        connection.close();
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return rows;
    }


    /**
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return Integer rows
     * @throws SQLException
     * @Title: updateStoreGoodsById
     * @Description: 根据商品ID删除商品信息
     * @author wujiancheng
     * @date 2018/1/28
     */
    @Override
    public Integer deleteStoreGoodsById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //删除SQL
        preparedStatement = connection.prepareStatement("DELETE FROM store_goods WHERE ID=?");
        //将数据放入SQL语句
        preparedStatement.setLong(1, id);
        //返回受影响的行数
        Integer rows = preparedStatement.executeUpdate();
        //提交
        connection.commit();
        ;
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return rows;
    }


    /**
     * @param storeGoods,connection,preparedStatement,dataSourceUtils
     * @return Integer rows
     * @throws SQLException
     * @Title: updateStoreGoodsById
     * @Description: 插入新的商品信息
     * @author wujiancheng
     * @date 2018/1/28
     */
    @Override
    public Integer addStoreGoods(StoreGoods storeGoods, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //插入SQL
        preparedStatement = connection.prepareStatement("INSERT INTO store_goods ( ID,STORE_ID,GOODS_NAME,GOODS_NUM ,GOODS_PRICE ,GOODS_TYPE_ID, BRAND,PRODUCTION_ADDRESS,PRODUCED_DATE,SHELF_LIFE, SHELF_LIFE_TYPE )VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        //将数据放入SQL

        preparedStatement.setInt(1, storeGoods.getID());
        preparedStatement.setInt(2, storeGoods.getSTORE_ID());
        preparedStatement.setString(3, storeGoods.getGOODS_NAME());
        preparedStatement.setDouble(4, storeGoods.getGOODS_NUM());
        preparedStatement.setDouble(5, storeGoods.getGOODS_PRICE());
        preparedStatement.setInt(6, storeGoods.getGOODS_TYPE_ID());

        preparedStatement.setString(7, storeGoods.getBRAND());
        preparedStatement.setString(8, storeGoods.getPRODUCTION_ADDRESS());
//        preparedStatement.setDate(9,storeGoods.getPRODUCED_DATE());
        preparedStatement.setDate(9, (Date) storeGoods.getPRODUCED_DATE());
        preparedStatement.setInt(10, storeGoods.getSHELF_LIFE());
        preparedStatement.setString(11, storeGoods.getSHELF_LIFE_TYPE());
        //获得受影响的行数
        Integer rows = preparedStatement.executeUpdate();
        //提交
        connection.commit();
//        connection.close();
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return rows;
    }

    /**
     * @param id,connection,preparedStatement,dataSourceUtils
     * @return Integer rows
     * @throws SQLException
     * @Title: updateStoreGoodsById
     * @Description: 查询商品信息
     * @author wujiancheng
     * @date 2018/1/28
     */
    @Override
    public StoreGoods findStoreGoodsById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        StoreGoods storeGoods = new StoreGoods();
        preparedStatement = connection.prepareStatement("SELECT ID,GOODS_NAME,GOODS_PRICE,GOODS_NUM FROM store_goods WHERE ID=?");
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // id 主键
            storeGoods.setID(resultSet.getInt("ID"));
            // 商品名字
            storeGoods.setGOODS_NAME(resultSet.getString("GOODS_NAME"));
            // 商品价格
            storeGoods.setGOODS_PRICE(resultSet.getDouble("GOODS_PRICE"));
            // 商品数量
            storeGoods.setGOODS_NUM(resultSet.getDouble("GOODS_NUM"));
        }
        connection.close();
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);
        return storeGoods;

    }


}
