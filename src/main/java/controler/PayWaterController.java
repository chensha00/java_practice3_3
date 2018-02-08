package controller;

import dao.UserAccountDaoImp;
import entity.UserAccount;
import service.UserAccountService;
import service.UserAccountServiceImp;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import  javax.servlet.http.*;


/**
 * @author xiaogaoqing
 * @ClassName PayWaterController
 * @Description 类描述
 * @date 2018/1/31
 */
public class PayWaterController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        PrintWriter out=response.getWriter();
        String  payWaterId=request.getParameter("payWaterId");
//        String  payWaterNumber=request.getParameter("payWaterNumber");
//        String  userAccountName=request.getParameter("userAccountName");
//        String  transactionTime=request.getParameter("transactionTime");
//        Date   transactionTime1=new SimpleDateFormat("transactionTime");
//         String  transactionAmount=request.getParameter("transactionAmount");

        PayWaterService   payWaterService=new PayWaterServiceImpl();
        PayWater payWater=payWaterService.findPayWaterById(Long.parseLong(payWaterId));
        request.setAttribute("payWater",payWater);
        request.getRequestDispatcher(request.getContextPath()+"/webapp/PayWater.jsp").forward(request,response);
        Long buyerId=payWater.getBuyerUserAccountId;
        UserAccountService userAccountService=new UserAccountServiceImp();
        UserAccount userAccount=userAccountService.findUserAccountById(buyerId);
        request.setAttribute("userAccount",userAccount);
    }
}