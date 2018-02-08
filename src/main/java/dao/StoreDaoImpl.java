package dao;

import common.util.DataSourceUtils;
import domain.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author guohongjin
 * @ClassName StoreDaoImpl
 * @Description 类描述
 * @date 2018/1/29
 */
public class StoreDaoImpl implements StoreDao{

    /**
     * @Title: deleteStoreById
     * @Description: 根据商铺ID删除商铺
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  id , connection, preparedStatement,dataSourceUtils
     * @return  rows
     * @throws  SQLException
     */
    public Integer deleteStoreById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //更新SQL
        preparedStatement=connection.prepareStatement("DELETE  FROM  store WHERE ID=?");
        //将数据放入SQL语句
        preparedStatement.setLong(1,id);
        //返回受影响的行数
        Integer rows=preparedStatement.executeUpdate();
        //提交
        connection.commit();
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return rows;
    }
    /**
     * @Title: deleteStoreByIds
     * @Description: 根据商铺ID删除多行商铺数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  ids, connection, preparedStatement,dataSourceUtils
     * @return  rows
     * @throws  SQLException
     */
    public Integer deleteStoreByIds(Long[] ids, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //更新SQL
        preparedStatement=connection.prepareStatement("DELETE FROM  store WHERE ID=?");
        //遍历id数组
        for(Long id:ids){
            //将数据放入SQL语句
            preparedStatement.setLong(1,id);
        }
        //返回受影响的行数
        Integer rows=preparedStatement.executeUpdate();
        //提交
        connection.commit();
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return rows;
    }

    /**
     * @Title: saveOrUpdateStore
     * @Description: 添加及更新商铺数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  store, connection, preparedStatement,dataSourceUtils
     * @return  rows
     * @throws  SQLException
     */
    public Integer saveOrUpdateStore(Store store, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        if(store.getId()!=null){
            //更新SQL.
            preparedStatement=connection.prepareStatement("UPDATE store SET STORE_NAME=? ,USER_ACCOUNT_ID=? WHERE ID=?");
            //将数据放入SQL语句
            preparedStatement.setString(1,store.getStoreName());
            preparedStatement.setLong(2,store.getUserAccountId());
            preparedStatement.setLong(3,store.getId());
            //返回受影响的行数
            Integer rows=preparedStatement.executeUpdate();
            //提交
            connection.commit();
            //关闭预编译
            preparedStatement.close();
            //将连接返回连接池
            dataSourceUtils.backConnection(connection);
            return rows;
        }else{
            //插入SQL
            preparedStatement=connection.prepareStatement("INSERT  INTO store (ID,STORE_NAME,USER_ACCOUNT_ID) VALUES (DEFAULT ,?,?)");
            //商铺名称
            preparedStatement.setString(1,store.getStoreName());
            //卖家信息
            preparedStatement.setLong(2,store.getUserAccountId());
            //获得受影响的行数
            Integer rows=preparedStatement.executeUpdate();
            //提交连接
            connection.commit();
            //关闭预编译
            preparedStatement.close();
            //返回连接池
            dataSourceUtils.backConnection(connection);
            return rows;
        }
    }
    /**
     * @Title: findStoreById
     * @Description: 根据ID查找商铺数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  id, connection, preparedStatement,dataSourceUtils
     * @return  goodsType
     * @throws  SQLException
     */
    public Store findStoreById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //新建一个store对象
        Store store=new Store();
        //更新SQL.
        preparedStatement=connection.prepareStatement("SELECT  ID,STORE_NAME,USER_ACCOUNT_ID FROM store WHERE  ID=?");
        //将数据放入SQL语句
        preparedStatement.setLong(1,id);
        //获得返回的查询结果集
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            //主键
            store.setId(resultSet.getLong("ID"));
            //商铺名称
            store.setStoreName(resultSet.getString("STORE_NAME"));
            //卖家信息
            store.setUserAccountId(resultSet.getLong("USER_ACCOUNT_ID"));

        }
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return store;
    }

    /**
     * @Title: findStoreByCondtion
     * @Description: 根据ID实现商品类型数据查询
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param stringObjectMap 传入一个查询的键值对
     */
    public List<Store> findStoreByCondtion(Map<String, String> stringObjectMap, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        List<Store>  storeList = new ArrayList<Store>();
        String key = "";
        String value = "";
        //取出map中的键值对
        Set<Map.Entry<String, String>> set = stringObjectMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            key = entry.getKey();
            value = entry.getValue();
        }
        preparedStatement = connection.prepareStatement("SELECT ID,STORE_NAME,USER_ACCOUNT_ID FROM store WHERE " + key + "=" + value);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Store store = new Store();
            store.setId(resultSet.getLong("ID"));
            store.setStoreName(resultSet.getString("STORE_NAME"));
            store.setUserAccountId(resultSet.getLong("USER_ACCOUNT_ID"));

            storeList.add(store);
        }
        preparedStatement.close();
        dataSourceUtils.backConnection(connection);


        return storeList;
    }
}