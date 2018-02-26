package controler;

import dao.UserAccountDaoImp;
import entity.OrderInfo;
import entity.UserAccount;
import service.Businession;
import service.OrderInfoServiceImpl;
import service.UserAccountServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyShoppingServlet extends HttpServlet {

    private static UserAccountDaoImp userAccountDaoImp=new UserAccountDaoImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username","buyer");
        String username=request.getAttribute("username").toString();

        if (username==null||username.equals("")){
            response.sendRedirect("/Login.jsp");
            return;
        }

        Businession businession=new Businession();
        List<UserAccount> userAccountList=businession.findUserAccountByName(username);
        UserAccount user=userAccountList.get(0);
        //查询人员所对应的订单
        List<OrderInfo> orderInfoList=businession.findOrderByUserAccountId(user.getId().toString());




        request.setCharacterEncoding("UTF-8");
        //账户
        request.setAttribute("user",user);

        //账户相关订单
        request.setAttribute("list",orderInfoList);

        //请求转发
        request.getRequestDispatcher(request.getContextPath()+"/jsp/myshopping.jsp").forward(request,response);
    }
}
