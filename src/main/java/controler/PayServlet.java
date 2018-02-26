package controler;

import dao.UserAccountDao;
import entity.OrderInfo;
import entity.UserAccount;
import service.OrderInfoService;
import service.OrderInfoServiceImpl;
import service.StoreService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author zhengxin
 * @ClassName payServlet
 * @Description 类描述
 * @date 2018/1/30/030
 */
public class PayServlet extends HttpServlet {
    //订单信息服务实例化对象
    private OrderInfoService orderInfoService;
    //Map实例化
    private Map.Entry<String,Object> entry;
    //人员账号服务实例化
    private UserAccountDao userAccountDao;
    //买家账号
    private UserAccount userAccount;
    //卖家账号
    private UserAccount sellerAccount;
    //商店服务实例化
    private StoreService storeService;
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

        OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();
        OrderInfo order=orderInfoService.findOrderById(Long.parseLong(orderId));

        req.setAttribute("order",order);
        req.getRequestDispatcher(req.getContextPath()+"/jsp/Payment.jsp").forward(req,resp);
//        String orderNum=req.getParameter("orderNum");
//        String storeName=req.getParameter("storeName");
//        String storeId=req.getParameter("storeId");
//        String goodsSumMoney =req.getParameter("goodsSumMoney");
//        String account =req.getParameter("account");
//        String password = req.getParameter("password");
//        req.setAttribute("orderNum",orderNum);
//        req.setAttribute("storeName",storeName);
//        req.setAttribute("goodsSumMoney",goodsSumMoney);
//        req.setAttribute("account",account);
//        req.setAttribute("password",password);
//        Map<String,String> map=new HashMap<>();
//        map.put("ORDER_NUM","'"+orderNum+"'");
//        Long buyerAccountId=null;
//        Long sellerAccountId=null;
//        Integer accountPassword=null;
//        buyerAccountId=userAccountDao.findByName(account).getId();
//        accountPassword=userAccountDao.findByName(account).getPayingPassWord();
//        sellerAccountId=storeService.findStoreById(Long.valueOf(storeId)).getUserAccountId();
//        sellerAccount=userAccountDao.findById(sellerAccountId);
//        userAccount=userAccountDao.findByName(account);
//        if (buyerAccountId==orderInfoService.findOrderByCondtion(map).get(0).getBuyerUserAccountId()||Integer.valueOf(password)==accountPassword){
//            if (userAccount.getMoney()>=Double.valueOf(goodsSumMoney)){
//                userAccount.setMoney(userAccount.getMoney()-Double.valueOf(goodsSumMoney));
//                sellerAccount.setMoney(sellerAccount.getMoney()+Double.valueOf(goodsSumMoney));
//                req.getRequestDispatcher("jsp/payWater.jsp").forward(req,resp);
//            }else {
//                System.out.println("余额不足，支付失败");
//            }
//        }

    }

}
