package com.service; /**
 * @Project: shopping
 * @Package service
 * @author jiangxiangwen
 * @date 2018/2/25
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.dao.UserAccountDaoImpl;
import com.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName UserAccountServiceImpl
 * @Description 类的描述
 * @date 2018/2/25
 */
@Service("userAccountServiceImpl")
public class UserAccountServiceImpl {

    @Autowired
   private  UserAccountDaoImpl userAccountDao;

   public List<UserAccount> findUser(UserAccount user){
        return userAccountDao.findAccountById(user);
   }

    public void addUser(UserAccount user){
        userAccountDao.addUser(user);
    }

    public void updateUser(UserAccount user){
        userAccountDao.updateUser(user);
    }

    public void deleteUser(UserAccount user){
        userAccountDao.deleteUser(user);
    }
}
