package service;

import entity.GoodsType;
import  dao.GoodsTypeDao;
import  dao.GoodsTypeDaoImpl;
import  common.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author xiaogaoqing
 * @ClassName GoodsTypeServiceImpl
 * @Description 类描述
 * @date 2018/1/29
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {
    static  GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();

    /**
     * @Title: deleteGoodsTypeById
     * @Description: 实现删除一条商品数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param id 传入一个要删除的id
     */
    public void  deleteGoodsTypeById(Long id) {
        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;

        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=goodsTypeDao.deleteGoodsTypeById(id,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * @Title: deleteGoodsTypeById
     * @Description: 实现删除多条商品类型数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param ids 传入一个要删除的id数组
     */
    public void deleteGoodsTypeByIds(Long[] ids) {

        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;
        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=goodsTypeDao.deleteGoodsTypeByIds(ids,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    /**
     * @Title: saveOrUpdateGoodsType
     * @Description: 实现更新保存商品类型数据
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param goodsType 传入一个要更新的商品类型数据
     */
    public void saveOrUpdateGoodsType(GoodsType goodsType) {
        //定义数据库连接
        Connection connection=null;
        //定义预编译的SQL语句
        PreparedStatement preparedStatement=null;
        //定义新的连接池
        DataSourceUtils dataSource=new DataSourceUtils();
        //定义新的变量接收dao层受影响的行数
        Integer rows=null;
        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            //rows接收dao层返回的受影响的行数并输出
            rows=goodsTypeDao.saveOrUpdateGoodsType(goodsType,connection,preparedStatement,dataSource);
            System.out.println(rows);

        } catch (SQLException e) {
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    /**
     * @Title: findGoodsTypeById
     * @Description: 根据ID实现商品类型数据查询
     * @author xiaogaoqing
     * @date 2018/1/29
     * @param id 传入一个查询的ID
     */
    public GoodsType findGoodsTypeById(Long id) {
        //定义数据库连接
        Connection connection= null;
        // 定义预编译sql语句
        PreparedStatement preparedStatement = null;
        //定义新的连接池
        DataSourceUtils dataSource = new DataSourceUtils();
        try {
            connection=dataSource.getConnection();
            return goodsTypeDao.findGoodsTypeById(id,connection,preparedStatement,dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void  findGoodsTypeByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) {

    }
}