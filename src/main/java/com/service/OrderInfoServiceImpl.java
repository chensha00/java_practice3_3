package com.service; /**
 * @Project: shopping
 * @Package com.service
 * @author jiangxiangwen
 * @date 2018/2/26
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.dao.OrderInfoDaoImpl;
import com.dao.UserAccountDaoImpl;
import com.entity.OrderInfo;
import com.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName OrderInfoServiceImpl
 * @Description 类的描述
 * @date 2018/2/26
 */
@Service("orderInfoServiceImpl")
public class OrderInfoServiceImpl {
    @Autowired
    private OrderInfoDaoImpl orderInfoDao;

    public List<OrderInfo> findOrderList(UserAccount user){
        return orderInfoDao.findOrderInfoByBuyer(user);
    }

    public void addOrder(OrderInfo order){
        orderInfoDao.addOrder(order);
    }

    public void updateOrder(OrderInfo order){
        orderInfoDao.updateOrder(order);
    }

    public void deleteOrder(OrderInfo order){
        orderInfoDao.deleteOrder(order);
    }
}
