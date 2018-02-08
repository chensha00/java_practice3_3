package dao;/********************************************************************
 /**
 * @Project: java_practice(1)
 * @Package dao
 * @author lixinlong
 * @date 2018/2/1 10:06
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
 * @InterfaceName TheUsserDao
 * @Description 接口描述
 * @date 2018/2/1
 */
public interface TheUsserDao {
/** 
 * @Title: deleteTheUsser
 * @Description: 删除
 * @author lixinlong
 * @date 2018/2/1
 */

public Integer deleteTheUsser(Long id, Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;
    
    /** 
     * @Title: addTheUsser
     * @Description: 增加
     * @author lixinlong
     * @date 2018/2/1
     */

    public Integer addTheUsser(Person person, Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: updateTheUsser
     * @Description: 修改
     * @author lixinlong
     * @date 2018/2/1
     */
    public Integer updateTheUsser(Person person,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: queryTheUsser
     * @Description: 查找
     * @author lixinlong
     * @date 2018/2/1
     */
    public TheUser queryTheUsser(Long id,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)  throws SQLException;

}
