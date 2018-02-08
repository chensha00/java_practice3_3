package dao;/********************************************************************
 /**
 * @Project: java_practice(1)
 * @Package dao
 * @author lixinlong
 * @date 2018/2/1 17:38
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.DataSourceUtils;
import entity.Person;
import entity.TheUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author lixinlong
 * @ClassName TheUsserDaoImpl
 * @Description 类描述
 * @date 2018/2/1
 */
public class TheUsserDaoImpl implements TheUsserDao{

    /**
     * @param id
     * @param connection
     * @param preparedStatement
     * @param dataSourceUtils
     * @Title: deleteTheUsser
     * @Description: 删除
     * @author lixinlong
     * @date 2018/2/1
     */
    @Override
    public Integer deleteTheUsser(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        return null;
    }

    /**
     * @param person
     * @param connection
     * @param preparedStatement
     * @param dataSourceUtils
     * @Title: addTheUsser
     * @Description: 增加
     * @author lixinlong
     * @date 2018/2/1
     */
    @Override
    public Integer addTheUsser(Person person, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        return null;
    }

    /**
     * @param person
     * @param connection
     * @param preparedStatement
     * @param dataSourceUtils
     * @Title: updateTheUsser
     * @Description: 修改
     * @author lixinlong
     * @date 2018/2/1
     */
    @Override
    public Integer updateTheUsser(Person person, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        return null;
    }

    /**
     * @param id
     * @param connection
     * @param preparedStatement
     * @param dataSourceUtils
     * @Title: queryTheUsser
     * @Description: 查找
     * @author lixinlong
     * @date 2018/2/1
     */
    @Override
    public TheUser queryTheUsser(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        return null;
    }
}