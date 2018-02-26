package service;/**
 * Created by Administrator on 2018/1/29.
 */

import common.util.DataSourceUtils;
import common.util.JdbcUtils;
import dao.BuyGoodsDao;
import dao.BuyGoodsDaoImpl;
import entity.BuyGoods;
import entity.UserAccount;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxiang
 * @ClassName BuyGoodsServiceImpl
 * @Description ������
 * @date 2018/1/29
 */
public class BuyGoodsServiceImpl implements BuyGoodsService {
    static BuyGoodsDaoImpl buyGoodsDao=new BuyGoodsDaoImpl();
    /**
     * @Title: deleteBuyGoodsByIds
     * @Description: ʵ��ɾ�������Ʒ�ķ���
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */

    @Override
    public Integer deleteBuyGoodsByIds(Long[] ids) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement=null;
        Integer  rows = null;                                      //���ظ��û�����Ϣ
        try{
            connection.setAutoCommit(false);
            rows = buyGoodsDao.deleteBuyGoodsByIds(ids, connection, preparedStatement);
        
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//�����쳣������ع�
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//�ύ����
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return  rows;                                                           //���ؽ��
        }
    }

    /**
     * @Title: updateBuyGoods
     * @Description: ʵ�ָ��������Ʒ�ķ���
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public Integer updateBuyGoods(BuyGoods goods) throws SQLException {
        Connection  connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        Integer rows = null;
        try{
            connection.setAutoCommit(false);
            rows = buyGoodsDao.updateBuyGoods(goods, connection, preparedStatement);
       
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//�����쳣������ع�
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//�ύ����
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //JdbcUtils.release(connection,preparedStatement);//�ر�����
        }
        return rows;
    }

    /**
     * @Title: insertBuyGoods
     * @Description: ʵ�����������Ʒ�ķ���
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public Integer insertBuyGoods(BuyGoods goods) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        Integer rows = null;
        try{
            connection.setAutoCommit(false);
            rows = buyGoodsDao.inertBuyGoods(goods, connection, preparedStatement);
        
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//�����쳣������ع�
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();//�ύ����
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    /**
     * @Title: findBuyGoodsById
     * @Description: ʵ�ֲ��������Ʒ�ķ���
     * @author zhouxiang
     * @date 2018/1/29
     * @throw SQLException
     */
    @Override
    public BuyGoods findBuyGoodsById(Long id) throws SQLException {
        Connection connection= JdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        String respond=null;//���ظ��û����ַ���
        BuyGoods result=null;
        try{
            connection.setAutoCommit(false);
             result = buyGoodsDao.findBuyGoodsById(id, connection, preparedStatement);

            if(result == null){
                respond = "��ѯʧ�ܣ�";
            }else {
                respond = "��ѯ�ɹ���";
            }
            System.out.println(respond);   //�����ѯ�Ƿ�ɹ�
        }catch (SQLException e){
            try{
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                connection.rollback();//�����쳣������ع�
            }
            e.printStackTrace();
        }
        finally {
            try {
                connection.commit();                //�ύ����
            } catch (SQLException e) {
                e.printStackTrace();
            }
           // JdbcUtils.release(connection,preparedStatement);//�ر�����
        }
       return result;                           //���ز�ѯ����Ϣ���û�

    }


    public List<BuyGoods> findUserAccountByCondtion(Map<String, String> stringObjectMap){
        // �յ�����
        Connection connection=null;
        // Ԥ�����sql��������
        PreparedStatement preparedStatement=null;
        // �����Զ������ӳض���
        DataSourceUtils dataSource = new DataSourceUtils();
        // ������Ӱ�������
        Integer rows=null;

        try {
            // �����ӳ����õ�һ�����Ӷ���
            connection=dataSource.getConnection();

            // ����dao���orderInfo��ʵ���࣬����һ��������һ�����ӣ�һ����������
            return buyGoodsDao.findBuyGoodsByCondtion(stringObjectMap, connection, preparedStatement,dataSource);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public List<BuyGoods> findBuyGoodsByOrderId(Long orderId){
        // �յ�����
        Connection connection=null;
        // Ԥ�����sql��������
        PreparedStatement preparedStatement=null;
        // �����Զ������ӳض���
        DataSourceUtils dataSource = new DataSourceUtils();
        // ������Ӱ�������
        Integer rows=null;

        try {
            // �����ӳ����õ�һ�����Ӷ���
            connection=dataSource.getConnection();

            // ����dao���orderInfo��ʵ���࣬����һ��������һ�����ӣ�һ����������
            return buyGoodsDao.findBuyGoodsByOrderId(orderId, connection, preparedStatement,dataSource);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}

