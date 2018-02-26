package com.controler;

import com.entity.UserAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.SpringContextUtil;
import com.service.UserAccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/myshopping")
public class MyShoppingServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ID",1);
        String userId=request.getAttribute("ID").toString();

        if (userId==null||userId.equals("")){
            response.sendRedirect("/Login.jsp");
            return;
        }

        UserAccount user=new UserAccount();
        user.setId(Long.valueOf(userId));
        UserAccountServiceImpl userAccountService= (UserAccountServiceImpl) SpringContextUtil.getBean("userAccountServiceImpl");

        UserAccount user1=userAccountService.findUser(user).get(0);
        //查询人员所对应的订单
//        List<OrderInfo> orderInfoList=businession.findOrderByUserAccountId(user.getId().toString());




        request.setCharacterEncoding("UTF-8");
        //账户
        request.setAttribute("user",user);

        //账户相关订单
//        request.setAttribute("list",orderInfoList);

        //请求转发
        request.getRequestDispatcher("/jsp/myshopping.jsp").forward(request,response);
    }
}
