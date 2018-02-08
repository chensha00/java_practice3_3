package controler;

import dao.UserAccountDao;
import entity.OrderInfo;
import entity.UserAccount;
import service.OrderInfoService;
import service.OrderInfoServiceImpl;
import service.StoreService;
import service.UserAccountService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * @author zhengxin
 * @ClassName payServlet
 * @Description 类描述
 * @date 2018/1/30/030
 */
public class PayServlet extends HttpServlet {
    //订单信息服务实例化对象
    static private OrderInfoService orderInfoService;
    //Map实例化
    static private Map<String,Object> map;
    //人员账号服务实例化
    static private UserAccountService userAccountService;
    static private UserAccountDao userAccountDao;
    //买家账号
    static private UserAccount userAccount;
    //卖家账号
    static private UserAccount sellerAccount;
    //商店服务实例化
    static private StoreService storeService;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
/**
     * @Title: doPost
     * @Description: post方法
     * @author zhengxin
     * @date 2018/2/2/002
     * @param req,resp
     * @throws  ServletException,IOException
     *
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String orderId=req.getParameter("orderid");
        Integer password= Integer.valueOf(req.getParameter("password"));
        //获取ID查找订单实体，将订单传给jsp
        OrderInfo order=orderInfoService.findOrderById(Long.parseLong(orderId));
        req.setAttribute("order",order);
        req.getRequestDispatcher(req.getContextPath()+"/jsp/Payment.jsp").forward(req,resp);
        //获取卖家和买家的账户
        Long buyerAccountId=order.getBuyerUserAccountId();
        userAccount=userAccountService.findUserAccountById(buyerAccountId);
        Integer accountPassword=userAccount.getPayingPassWord();
        Long sellerAccountId=null;
        sellerAccountId=storeService.findStoreById(Long.valueOf(order.getStoreId())).getUserAccountId();
        sellerAccount=userAccountService.findUserAccountById(sellerAccountId);
        //如果输入的密码正确，则执行以下业务
        if (password==accountPassword){
            if (userAccount.getMoney()>=order.getGoodsSumMoney()){
                userAccount.setMoney(userAccount.getMoney()-order.getGoodsSumMoney());
                //这里还要产生交易流水



                Long payWaterId=null;
                sellerAccount.setMoney(sellerAccount.getMoney()+order.getGoodsSumMoney());
                req.setAttribute("payWaterId",payWaterId);
                req.getRequestDispatcher(req.getContextPath()+"/payWater?payWaterId="+payWaterId).forward(req,resp);
            }else {
                out.println("余额不足，支付失败");
            }
        }else{
            out.println("密码错误");

        }

    }

}
