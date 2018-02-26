/**
 * @Project: shopping
 * @Package PACKAGE_NAME
 * @author jiangxiangwen
 * @date 2018/2/2
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import dao.UserAccountDaoImp;
import entity.UserAccount;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangxiangwen
 * @ClassName test
 * @Description 类的描述
 * @date 2018/2/2
 */

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAccountDaoImp userAccountDaoImp = (UserAccountDaoImp) applicationContext.getBean("userAccountDaoImp");
        UserAccount userAccount=userAccountDaoImp.findByName("admin");

    }
}
