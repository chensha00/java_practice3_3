package service; /**
 * @Project: shopping
 * @Package service
 * @author jiangxiangwen
 * @date 2018/1/31
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import common.util.DataSourceUtils;
import dao.StoreGoodsDao;
import dao.StoreGoodsDaoImpl;
import entity.StoreGoods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author jiangxiangwen
 * @ClassName StoreGoodsServiceImpl
 * @Description 类的描述
 * @date 2018/1/31
 */
public class StoreGoodsServiceImpl implements StoreGoodsService {
    static StoreGoodsDao storeGoodsDao=new StoreGoodsDaoImpl();

    /**
     * @return 删除一件商品
     * @param ID 传入一个要删除的id
     */
    @Override
    public void deleteStoreGoodsById(Long ID) {
        //定义数据库连接
        Connection connection = null;
        //定义预编译sql语句
        PreparedStatement preparedStatement = null;

        DataSourceUtils dataSource = new DataSourceUtils();
        Integer rows = null;
        try {
            //获取连接
            connection = dataSource.getConnection();
            //关闭自动提交事务
            connection.setAutoCommit(false);
            rows = storeGoodsDao.deleteStoreGoodsById(ID, connection, preparedStatement,dataSource);
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
     * @return 插入一件商品
     * @param storeGoods 传入一个要添加的商品数据
     */

    @Override
    public void addStoreGoods(StoreGoods storeGoods) {
        //定义数据库连接
        Connection connection=null;
        //定义预编译sql语句
        PreparedStatement preparedStatement=null;

        DataSourceUtils dataSource = new DataSourceUtils();
        Integer rows=null;
        try {
            //获取连接
            connection=dataSource.getConnection();
            //关闭自动提交事务
            connection.setAutoCommit(false);
            rows=storeGoodsDao.addStoreGoods(storeGoods,connection,preparedStatement,dataSource);
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
     * @return 更新数据
     * @param storeGoods 传入一个要修改的商品数据
     * @throws SQLException
     */
    @Override
    public void updateStoreGoodsById(StoreGoods storeGoods) throws SQLException {
        //定义数据库连接
        Connection connection=null;
        //定义预编译sql语句
        PreparedStatement preparedStatement=null;

        DataSourceUtils dataSource = new DataSourceUtils();
        Integer rows=null;
        try {
            //获取连接
            connection= dataSource.getConnection();
            //关闭自动提交事务
            connection.setAutoCommit(false);
            rows=storeGoodsDao.updateStoreGoodsById(storeGoods, connection,preparedStatement,dataSource);
            System.out.println(rows);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //事务回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     *
     * @param ID 传入一个要查询的id
     * @return 返回商品数据
     */
    @Override
    public StoreGoods findStoreGoodsById(Long ID) {
        //定义数据库连接
        Connection connection = null;
        // 定义预编译sql语句
        PreparedStatement preparedStatement = null;

        DataSourceUtils dataSource = new DataSourceUtils();

        try {
            connection=dataSource.getConnection();
            return storeGoodsDao.findStoreGoodsById(ID,connection,preparedStatement,dataSource);
//            return goodsDao.findGoodsById(id,conn,pstmt,dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
