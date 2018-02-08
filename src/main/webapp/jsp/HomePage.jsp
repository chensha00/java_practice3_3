<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/5
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="../css/HomePage.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery.js"></script>
    <script type="text/javascript">
        //通过jq实现图片与超链接的联动
        $(function(){
            $("td.clas1").mouseover(function(){
                $("div table+img").attr("src","../images/shoubiao.jpg");
            });
            $("td.clas2").mouseover(function () {
                $("div table+img").attr("src","../images/yifu.jpg");
            });
            $("td.clas3").mouseover(function () {
                $("div table+img").attr("src","../images/kuzi.jpg");
            });
            $("td.clas4").mouseover(function () {
                $("div table+img").attr("src","../images/xiezi.jpg");
            });
        })
    </script>
</head>
<body>

<div class="top-J-Top" style="top: 0px;width: 50px">
    <div class="man">
        <a href="http://www.baidu.com" target="_blank" style="color: orange">登陆</a>
        <a href="http://www.baidu.com" target="_blank" style="color: orange">注册</a>
    </div>
    <div class="top-wrap">
        <a style=" color:orange; font-size:30px;">shopping</a>
        <div class="tbh-search">
            <div class="search-bd">
                <div class="search-triggers">
                    <li class="J_SearchTab selected goods-search-tab" >
                        商品
                    </li>
                    <li class="J_SearchTab shop-search-tab" >
                        店铺
                    </li>
                </div>
                <div class="search-panel">
                  <div class="search-button">
                      <button class="btn-search" type="submit" data-spm-click="gostr=/tbindex;locaid=d13">
                          搜索
                      </button>
                  </div>
                    <div class="search-combobox">
                        <div class="search-combobox-input-wrap">
                            <input  style="border:0;font-size:20px;width:475px;height:36px">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="tbh-fl">
    <div class="tbh-fl-begin" >
        <h2 style="color: white">商品分类</h2>
    </div>
</div>
    <div class="main">
        <table  class="main-list" style="position: absolute;left: 140px; margin: 20px 0;">
            <tr>
                <td class="clas1"><a href="StoreGoods.jsp" style="color: black" target="_blank">手表</a></td>
            </tr>
            <tr>
                <td class="clas2"><a href="衣服链接网页" style="color: black" target="_blank">衣服</a></td>
            </tr>
            <tr>
                <td class="clas3"><a href="裤子链接网页" style="color: black" target="_blank">裤子</a></td>
            </tr>
            <tr>
                <td class="clas4"><a href="鞋子链接网页" style="color: black" target="_blank">鞋子</a></td>
            </tr>
        </table>
        <img class="weizhi" src="../images/xiezi.jpg "/>
    </div>
</body>
</html>
