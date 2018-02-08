package entity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author wujunnan
 * @ClassName tttt
 * @Description 类描述
 * @date 2018/1/30
 */
public class UserAccount {
    //用户id
    private Integer id;
    //用户名
    private String userAccountName;
    //用户密码
    private String userAccountPassWord;
    //支付密码
    private String payingPassWord;
    //注册日期
    private Date registerTime;
    //余额
    private Double money;
    //是否卖家
    private Byte isBuyer;
    //是否冻结 1--是,0--否
    private Byte isFreezing;
    //是否注销 1--是,0--否'
    private Byte isLost;
    //是否删除 1--是,0--否
    private Byte isDelete;
    /**
     * @Title:
     * @Description: 构造方法
     * @author WuJunNan
     * @param id
     * @param userAccountName
     * @param userAccountPassWord
     * @param payingPassWord
     * @param registerTime
     * @param money
     * @param isBuyer
     * @param isFreezing
     * @param isLost
     * @param isDelete
     */
    public UserAccount(Integer id, String userAccountName, String userAccountPassWord, String payingPassWord, Date registerTime, Double money, Byte isBuyer, Byte isFreezing, Byte isLost, Byte isDelete) {
        this.id = id;
        this.userAccountName = userAccountName;
        this.userAccountPassWord = userAccountPassWord;
        this.payingPassWord = payingPassWord;
        this.registerTime = registerTime;
        this.money = money;
        this.isBuyer = isBuyer;
        this.isFreezing = isFreezing;
        this.isLost = isLost;
        this.isDelete = isDelete;
    }

    public UserAccount(String userAccountName, String userAccountPassWord, String payingPassWord, Date registerTime, Double money, Byte isBuyer, Byte isFreezing, Byte isLost, Byte isDelete) {
        this.userAccountName = userAccountName;
        this.userAccountPassWord = userAccountPassWord;
        this.payingPassWord = payingPassWord;
        this.registerTime = registerTime;
        this.money = money;
        this.isBuyer = isBuyer;
        this.isFreezing = isFreezing;
        this.isLost = isLost;
        this.isDelete = isDelete;
    }

    public UserAccount(String userAccountName, String userAccountPassWord) {
        this.userAccountName = userAccountName;
        this.userAccountPassWord = userAccountPassWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAccountName() {
        return userAccountName;
    }

    public void setUserAccountName(String userAccountName) {
        this.userAccountName = userAccountName;
    }

    public String getUserAccountPassWord() {
        return userAccountPassWord;
    }

    public void setUserAccountPassWord(String userAccountPassWord) {
        this.userAccountPassWord = userAccountPassWord;
    }

    public String getPayingPassWord() {
        return payingPassWord;
    }

    public void setPayingPassWord(String payingPassWord) {
        this.payingPassWord = payingPassWord;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Byte getIsBuyer() {
        return isBuyer;
    }

    public void setIsBuyer(Byte isBuyer) {
        this.isBuyer = isBuyer;
    }

    public Byte getIsFreezing() {
        return isFreezing;
    }

    public void setIsFreezing(Byte isFreezing) {
        this.isFreezing = isFreezing;
    }

    public Byte getIsLost() {
        return isLost;
    }

    public void setIsLost(Byte isLost) {
        this.isLost = isLost;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ID:      " + id +"\n"+
                "用户名：  " + userAccountName +"\n"+
                "密码：    " + userAccountPassWord +"\n"+
                "支付密码： " + payingPassWord +"\n"+
                "注册时间： " + registerTime +"\n"+
                "卡上余额： " + money +"\n"+
                "是否卖家： " + isBuyer +"\n"+
                "是否冻结： " + isFreezing +"\n"+
                "是否注销： " + isLost +"\n"+
                "是否删除： " + isDelete;
    }
}