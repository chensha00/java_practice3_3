package controler; /**
 * @Project: shopping
 * @Package controler
 * @author jiangxiangwen
 * @date 2018/2/5
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import entity.BuyGoods;
import entity.StoreGoods;
import service.BuyGoodsServiceImpl;
import service.StoreGoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author jiangxiangwen
 * @ClassName FindPerson
 * @Description 类的描述
 * @date 2018/2/5
 */
public class FindGoodsServlet extends HttpServlet {
    private static BuyGoodsServiceImpl buyGoodsService=new BuyGoodsServiceImpl();
    private static StoreGoodsServiceImpl storeGoodsService=new StoreGoodsServiceImpl();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a=req.getParameter("i").trim();
        Long orderid= Long.valueOf(a);
        List<BuyGoods> buyGoods0List=buyGoodsService.findBuyGoodsByOrderId(orderid);
        if (buyGoods0List!=null){
            StoreGoods storeGoods=storeGoodsService.findStoreGoodsById(buyGoods0List.get(0).getStoreID());
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("data",storeGoods.getGOODS_NAME());
            resp.setContentType("text/html;charset=utf-8");
//            resp.setHeader("Cache-Control", "no-cache");
//            String str = "{'msg':'成功','success':'true'}";
            PrintWriter out = resp.getWriter();
            out.print(storeGoods.getGOODS_NAME());
//            out.flush();
//            out.close();
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
