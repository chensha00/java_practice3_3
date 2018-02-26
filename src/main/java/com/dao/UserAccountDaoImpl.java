package com.dao;

import com.base.BaseDaoImpl;
import com.entity.UserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userAccountDaoImpl")
public class UserAccountDaoImpl extends BaseDaoImpl<UserAccount>{

     public  List<UserAccount> findAccountById(UserAccount user){
         return this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findAccountById",user);
    }

    public void addUser(UserAccount user){
         this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"addAccount",user);
    }

    public void updateUser(UserAccount user){
        this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updateAccountById",user);
    }

    public void deleteUser(UserAccount user){
        this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteAccountById",user);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserAccountDaoImpl useraccountdaoimpl=(UserAccountDaoImpl) applicationContext.getBean("userAccountDaoImpl");
    }
}