package dao;

import common.util.DataSourceUtils;
import entity.GoodsType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author xiaogaoqing
 * @ClassName GoodsTypeDaoImpl
 * @Description 类描述
 * @date 2018/1/29
 */
 public class GoodsTypeDaoImpl implements  GoodsTypeDao {
    /**
         * @Title: deleteGoodsTypeById
         * @Description: 根据商品类型ID删除商品类型
         * @author xiaogaoqing
         * @date 2018-01-29
         * @param  id , connection, preparedStatement,dataSourceUtils
         * @return  rows
         * @throws  SQLException
         */
    public Integer deleteGoodsTypeById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //更新SQL
        preparedStatement=connection.prepareStatement("DELETE  FROM  goods_type WHERE ID=?");
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
     * @Title: deleteGoodsTypeByIds
     * @Description: 根据商品类型ID删除多行商品类型数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  ids, connection, preparedStatement,dataSourceUtils
     * @return  rows
     * @throws  SQLException
     */
    public Integer deleteGoodsTypeByIds(Long[] ids, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //更新SQL
        preparedStatement=connection.prepareStatement("DELETE FROM  goods_type WHERE ID=?");
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
     * @Title: saveOrUpdateGoodsType
     * @Description: 添加及更新商品类型数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  goodsType, connection, preparedStatement,dataSourceUtils
     * @return  rows
     * @throws  SQLException
     */
    public Integer saveOrUpdateGoodsType(GoodsType goodsType, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
       if(goodsType.getId()!=null){
           //更新SQL.
           preparedStatement=connection.prepareStatement("UPDATE goods_type SET TYPE_NAME=? WHERE ID=?");
           //将数据放入SQL语句
           preparedStatement.setString(1,goodsType.getTypeName());
           preparedStatement.setLong(2,goodsType.getId());
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
        preparedStatement=connection.prepareStatement("INSERT  INTO goods_type(ID,TYPE_NAME) VALUES (DEFAULT ,?)");
        //商品类型名称
        preparedStatement.setString(1,goodsType.getTypeName());
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
     * @Title: findGoodsTypeById
     * @Description: 根据ID查找商品类型数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  id, connection, preparedStatement,dataSourceUtils
     * @return  goodsType
     * @throws  SQLException
     */
    public GoodsType findGoodsTypeById(Long id, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
        //新建一个goodstype对象
        GoodsType goodsType=new GoodsType();
        //更新SQL.
        preparedStatement=connection.prepareStatement("SELECT ID, TYPE_NAME FROM goods_type WHERE  ID=?");
        //将数据放入SQL语句
        preparedStatement.setLong(1,id);
       //获得返回的查询结果集
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            //主键
            goodsType.setId(resultSet.getLong("ID"));
            //类型名称
            goodsType.setTypeName(resultSet.getString("TYPE_NAME"));

        }
        //关闭预编译
        preparedStatement.close();
        //将连接返回连接池
        dataSourceUtils.backConnection(connection);
        return goodsType;
    }


//    /**
//     * @Title: addGoodsType
//     * @Description: 添加商品类型数据
//     * @author xiaogaoqing
//     * @date 2018-01-29
//     * @param  goodsType, connection, preparedStatement,dataSourceUtils
//     * @return  rows
//     * @throws  SQLException
//     */
//    public Integer addGoodsType(GoodsType goodsType, Connection connection, PreparedStatement preparedStatement, DataSourceUtils dataSourceUtils) throws SQLException {
//        //插入SQL
//        preparedStatement=connection.prepareStatement("INSERT  INTO goods_type(ID,TYPE_NAME) VALUES (?,?)");
//        //将数据放入SQL语句
//        preparedStatement.setLong(1,goodsType.getId());
//        //商品类型名称
//        preparedStatement.setString(2,goodsType.getTypeName());
//      //获得受影响的行数
//        Integer rows=preparedStatement.executeUpdate();
//        //提交连接
//        connection.commit();
//        //关闭预编译
//        preparedStatement.close();
//        //返回连接池
//        dataSourceUtils.backConnection(connection);
//        return rows;
//    }


    /**
     * @Title: findGoodsTypeById
     * @Description: 根据ID查找商品类型数据
     * @author xiaogaoqing
     * @date 2018-01-29
     * @param  stringObjectMap
     * @return  goodsType
     * @throws  SQLException
     */


    public List<GoodsType> findGoodsTypeByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return null;
    }
}