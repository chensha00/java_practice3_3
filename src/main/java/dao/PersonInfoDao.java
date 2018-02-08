package dao;
 /**
 * @Project: java_practice
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/1/28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.DataSourceUtils;
import entity.PersonInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @InterfaceName TestDao
 * @Description 接口描述
 * @date 2018/1/19
 */
public interface PersonInfoDao {

    /**
     * @Title: deleteTestById
     * @Description: 删除一行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id    主键id
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return  返回收影响的行数
     * @throws SQLException
     */
    public Integer deletePersonInfoById(Long id,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: deleteTestByIds
     * @Description: 删除多行数据
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param ids 主键id集合
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回收影响的行数
     * @throws SQLException
     */
    public Integer deletePersonInfoByIds(Long[] ids,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: saveOrUpdateTest
     * @Description: 添加或更新数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param personInfo 人员信息
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回收影响的行数
     * @throws SQLException
     */
    public Integer saveOrUpdatePersonInfo(PersonInfo personInfo,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: findTestById
     * @Description: 查询数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param id 主键id
     * @param connection 连接对象
     * @param preparedStatement 预编译的操作指令
     * @param dataSourceUtils 连接池
     * @return 返回查询的对象
     * @throws SQLException
     */
    public PersonInfo findPersonInfoById(Integer id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: findTestByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author jiangxiangwen
     * @date 2018/1/28
     * @param stringObjectMap    查询数据的键值对
     * @return 返回查询的对象的集合
     * @throws SQLException
     */
    public List<PersonInfo> findPersonInfoByCondtionForPage(Map<String,String> stringObjectMap,Connection connection,PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;
}
