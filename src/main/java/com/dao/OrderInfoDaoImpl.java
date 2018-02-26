package com.dao; /**
 * @Project: shopping
 * @Package dao
 * @author jiangxiangwen
 * @date 2018/2/25
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.base.BaseDaoImpl;
import com.entity.OrderInfo;
import com.entity.UserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName OrderInfoDaoImpl
 * @Description 类的描述
 * @date 2018/2/25
 */
@Repository("orderInfoDaoImpl")
public class OrderInfoDaoImpl extends BaseDaoImpl<OrderInfo> {

    /**
     * @Title: findAccountByBuyer
     * @Description: 查询买家的订单
     * @author jiangxiangwen
     * @date 2018/2/25
     * @param buyer 卖家
     * @return List<OrderInfo>
     *
     */
    public List<OrderInfo> findOrderInfoByBuyer(UserAccount buyer){
        return this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findOrderInfoByBuyer",buyer);
    }

    public void addOrder(OrderInfo order){
        this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"",order);
    }

    public void updateOrder(OrderInfo order){
        this.sqlSessionTemplate.update(getMybaitsNameSpace()+"",order);
    }

    public void deleteOrder(OrderInfo order){
        this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"",order);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderInfoDaoImpl orderInfoDao=(OrderInfoDaoImpl) applicationContext.getBean("orderInfoDaoImpl");
        UserAccount user=new UserAccount();
        user.setId(1l);
        List<OrderInfo> orderInfos=orderInfoDao.findOrderInfoByBuyer(user);
    }
}
