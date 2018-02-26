package controler;

import entity.UserAccount;
import service.UserAccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wujunnan
 * @ClassName UserAccountCollection
 * @Description 类描述
 * @date 2018/1/30
 */
public class UserAccountControler extends HttpServlet {
    private UserAccountService userAccountService;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String repeatPwd = request.getParameter("repeatPwd");
//        String remember = request.getParameter("remember");
        request.setAttribute("userName",userName);
        request.setAttribute("passWord",passWord);
        request.setAttribute("repeatPwd",repeatPwd);
//        request.setAttribute("remember",remember);


//        out.println(userName);
//        out.println(passWord);
//        out.println(repeatPwd);
        //获取请求资源路径
        String uri = request.getRequestURI();
        out.println(uri);
        //截取最后一个斜杠到最后一个点之间的字符串
        String action= uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
        out.println(action);

        if (action.equals("register")){
            //调用Service注册方法
            userAccountService.register(userName,passWord,repeatPwd);

        }else if (action.equals("login")){
            UserAccount userAccount = null;
            if (userName==null ||userName.trim().isEmpty()){
                request.setAttribute("loginErrorOne","用户名不能为空");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            } else{
                if (passWord==null ||passWord.trim().isEmpty()) {
                    request.setAttribute("loginErrorTwo", "密码不能为空");
                    request.getRequestDispatcher("Login.jsp").forward(request,response);
                }else{
                    if (userName!=userAccount.getUserAccountName() && passWord!=userAccount.getUserAccountPassWord()) {
                        request.setAttribute("loginErrorThree", "帐号或密码错误");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }else{
                        //调用Service登录方法
                        userAccountService.login(userName, passWord);
                    }
                }
            }
        }
        out.flush();
        out.close();

    }
}