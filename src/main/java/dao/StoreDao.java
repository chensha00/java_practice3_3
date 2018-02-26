package dao;

import common.util.DataSourceUtils;
import entity.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author xiaogaoqing
 * @InterfaceName StoreDao
 * @Description 接口描述
 * @date 2018/1/29
 */
public interface StoreDao {
    /**
     * @Title: deleteStoreById
     * @Description: 删除一行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  id 主键id
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer deleteStoreById(Long id,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils) throws SQLException;

    /**
     * @Title: deleteStoreByIds
     * @Description: 删除多行数据
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  ids 主键id
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer deleteStoreByIds(Long[] ids,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: saveOrUpdateStore
     * @Description: 添加或更新数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  store 要添加到数据库中的对象
     * @return  返回收影响的行数
     * @throws SQLException
     *
     */
    public Integer saveOrUpdateStore(Store store,Connection connection, PreparedStatement preparedStatement,DataSourceUtils dataSourceUtils)throws SQLException;

    /**
     * @Title: findStoreById
     * @Description: 查询数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @return  返回查询的对象
     * @throws SQLException
     *
     */

    public Store findStoreById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils)throws SQLException;


    /**
     * @Title: findStoreByCondtionForPage
     * @Description: 带分页功能的查询多条数据信息
     * @author xiaogaoqing
     * @date 2018/1/28
     * @param  stringMap *******按照对应的数据表来写，应该是传入一个Map集合，根据集合里的对象查数据
     * @param startRows 开始行
     * @param size 要显示多少条信息的大小
     * @return  返回查询的对象的集合
     * @throws SQLException
     *
     */

    public List<Store> findStoreByCondtionForPage(Map<String,String> stringMap ,Integer startRows, Integer size)throws SQLException;
}
