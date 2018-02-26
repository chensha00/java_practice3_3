package com.controler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author xiaogaoqing
 * @ClassName PayWaterController
 * @Description 类描述
 * @date 2018/1/31
 */
public class PayWaterController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
         PrintWriter out=response.getWriter();
//         PayWaterService   payWaterService=new PayWaterServiceImpl;






    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}