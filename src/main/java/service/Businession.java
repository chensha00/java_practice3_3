package service; /**
 * @Project: shopping
 * @Package service
 * @author jiangxiangwen
 * @date 2018/2/1
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import entity.OrderInfo;
import entity.UserAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangxiangwen
 * @ClassName Businession
 * @Description 业务处理类
 * @date 2018/2/1
 */

public class Businession {
    //静态的订单查询service 层
    static OrderInfoServiceImpl orderInfoService= new OrderInfoServiceImpl();
    static UserAccountServiceImp userAccountServiceImp=new UserAccountServiceImp();
    /**
     * @Title: findOrderByCondtion
     * @Description: 通过用户名查找所对应的订单信息
     * @author jiangxiangwen
     * @date 2018/2/1
     * @param userAccount 用户名
     * @return List<OrderInfo> 订单集合
     *
     */
    public List<UserAccount> findUserAccountByName(String userAccount) {
        userAccount="'"+userAccount+"'";
        if (userAccount!=null) {
        Map<String,String> map=new HashMap<String, String>();
        map.put("USER_ACCOUNT_NAME",userAccount);
        List<UserAccount> userAccountList=userAccountServiceImp.findUserAccountByCondtion(map);
        return userAccountList;
        }else {
            return null;
        }

    }

    public List<OrderInfo> findOrderByUserAccountId(String userAccountId) {


        if (userAccountId!=null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("BUYER_USER_ACCOUNT_ID", userAccountId);
            //订单集合
            List<OrderInfo> list = orderInfoService.findOrderByCondtion(map);

            return list;
        }else {
            return null;
        }

    }
}
