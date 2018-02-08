<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        a{
            text-decoration:none;
            font-size:20px;
            color: black;

        }

        ol, ul,li {
            list-style: none;
            list-style-type: none;
            list-style-image: none;
            list-style-position: outside;
            text-align:center;
        }
        .top-wrap {
            width: 1190px;
            margin: 0 auto;
        }
        .tbh-search {
            margin-left: 258px;
            margin-right: 302px;
            background-color: transparent;
        }

        .search-bd {
            z-index: 30;
            position: relative;
            transform: translateZ(0);
        }


        .search-triggers {
            height: 22px;
            margin-left: 17px;
        }


        .search-bd .search-triggers li {
            color: #F40;
            text-align: center;
            float: left;
            width: 36px;
            height: 22px;
            line-height: 22px;
            margin-right: 4px;
            cursor: pointer;
        }

        .tbh-search .search-panel {
            position: relative;
        }
        .search-combobox {
            font-size: 12px;
        }
        .search-bd .search-panel .search-button {
            position: absolute;
            right: 0;
            top: 0;
            z-index: 100;
            width: 74px;
            height: 40px;
            overflow: hidden;
            text-align: center;
            border-top-right-radius: 20px;
            border-bottom-right-radius: 20px;
        }
        .search-bd .search-panel .search-button .btn-search {
            font-size: 18px;
            font-weight: 700;
            color: #FFF;
            background-color: #FF4200;
            cursor: pointer;
            height: 100%;
            border: none;
            width: 100%;
        }
        .search-bd .search-panel  {
            margin-right: 74px;
            border: 2px solid #ff5000;
            border-top-left-radius: 20px;
            border-bottom-left-radius: 20px;
            border-right: none;
            overflow: hidden;
            height: 36px;
        }
        .search-bd .search-panel .search-combobox-input-wrap  {
            height: 36px;
            overflow: hidden;
            width: 472px;
        }
        .tbh-fl{
            height: 36px;
            width: 1340px;
            background-color:orange;
        }
        .tbh-fl-begin{
            height: 36px;
            width: 100px;
            margin: 0 auto;
            margin-top: 0px;
            margin-bottom: 0px;
            margin-left: 100px;
            background-color:orangered;
        }
        .tbh-messags {
            width: 1190px;
            margin: 0 auto;
            height: 632px;
        }
        .main {
            float: left;
            width: 900px;
            height: 100%;
            clear: left;
        }
        .person-message{
            float: right;
            width: 290px;
            height: 100%;
            margin-top: 10px;
        }
        .main-list{
            position: relative;
            float: left;
            width: 190px;
            min-height: 500px;
            border:1px solid orangered;
        }
        .main-listmessages{
            margin-left: 10px;
            margin-top: 10px;
            float: left;
            height: 500px;
            width: 680px;

        }

    </style>
</head>
<body>
<div class="top-J-Top" style="top: 0px;">
    <div class="top-wrap clearfix">
        <div class="tbh_logo">
            <a style=" color:red; font-size:30px;">shopping</a>
        </div>
        <div class="tbh-search">
            <div class="search-bd">
                <div class="search-triggers">
                    <ul class="ks-switchable-nav">
                        <li class="J_SearchTab selected goods-search-tab" data-searchtype="item" data-defaultpage="nogo" data-spm-click="gostr=/tbindex;locaid=d10;name=商品">
                            商品
                        </li>

                        <li class="J_SearchTab shop-search-tab" data-searchtype="shop" data-spm-click="gostr=/tbindex;locaid=d12;name=店铺" data-action="//shopsearch.taobao.com/browse/shop_search.htm" data-spm-anchor-id="a21bo.2017.201856.d12">
                            店铺
                        </li>
                    </ul>
                </div>

                <div class="search-panel">
                    <form class="search-panel-focused" target="_top" action="窗体路径" name="search" data-defaultpage="nogo">
                        <div class="search-button">
                            <button class="btn-search" type="submit" data-spm-click="gostr=/tbindex;locaid=d13">搜索</button>
                        </div>
                        <div class="search-combobox">
                            <div class="search-panel-fields">
                                <div class="search-combobox-input-wrap">
                                    <input  style="border:0;font-size:20px;width:475px;height:36px">
                                </div>
                            </div>
                        </div>
                    </form>
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
<div class="tbh-messags">
    <div class="main">
        <div class="main-list" role="menubar">
            <li class="main-list-Watch" >
                <a href="手表链接网页">手表</a>
            </li>
            <li class="main-list-clothes" >
                <a href="衣服链接网页">衣服</a>
            </li>
            <li class="main-list-trousers" >
                <a href="衣服链接网页">裤子</a>
            </li>
            <li class="main-list-shoes" >
                <a href="鞋子链接网页">鞋子</a>
            </li>

        </div>
        <div class="main-listmessages"></div>
    </div>
    <div class="person-message"></div>
</div>
</body>
</html>