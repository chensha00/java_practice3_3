<%--
  Created by IntelliJ IDEA.
  User: jone
  Date: 2018/1/30
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script scr ="https://tce.alisdn.com/api/dats.htm?callback=tec_175785&ids=175785" async=""></script>
    <title>我的购物车</title>
</head>
<body>
<%--设置容器背景颜色，高度--%>
<div style="background-color:#f5f5f5; height:40px;">

    <style type="text/css">
        <%--color字体颜色， text-decoration: none 消除下标, font-size:字体大小--%>
        a{color:gray; text-decoration: none;font-size: 15px;}
        <%--移动到标签上显示字体颜色--%>
        a:hover{color: #ff4502}
        <%--设置弹出菜单默认隐藏--%>
        <%-- .tanchucaidan{display: none;}--%>
        <%-- 当鼠标移动到dingjicaidan下的li标签时，改变li下的ul标签的display属性（显示出来）--%>
       <%-- .dingjicaidan li:hover ul{display: block}--%>

        *{margin: 0;padding: 0;}
        li{list-style: none;}
        <%-- 当鼠标移动到dingjicaidan下的li标签时，改变li下的ul标签的display属性（显示出来）--%>
        .nav>li{float: left;margin:10px}
        <%--设置弹出菜单默认隐藏,绝对定位--%>
        .menu{display: none; position: absolute;z-index:999; background-color:white;}

    </style>
<%--设置容器长度，和居中--%>
<div style=" width: 900px; margin-left: auto; margin-right: auto;">
    <%--设置容器长度，和居左--%>
<div style="width: 200px; margin-right: auto;">
    <ul class="nav">
        <li al> <a   href="session_jsp.jsp">消息&nbsp;</a>
            <ul class="menu"></ul>
        </li>
    </ul>

    <ul class="nav">
        <li>
            <a href="session_jsp.jsp">手机逛淘宝</a>
            <ul class="menu"></ul>
        </li>
    </ul>

</div>

   <%--设置容器长度，和居右--%>
<div style="width: 580px; margin-left: auto;">

    <ul class="nav">
       <li> <a   href="session_jsp.jsp">首页&nbsp;</a>
        <ul class="menu"></ul>
        </li>
    </ul>

        <ul class="nav">
            <li>
                <a href="session_jsp.jsp">我的淘宝&nbsp;</a>
            <ul class="menu">
                <li><a   href="session_jsp.jsp">已卖到的淘宝</a></li>
                <li><a   href="session_jsp.jsp">我的足迹</a></li>
            </ul>
            </li>
        </ul>

    <ul class="nav">
        <li>
            <a   href="session_jsp.jsp">收藏夹&nbsp;</a>
            <ul class="menu">
                <li><a   href="session_jsp.jsp">收藏的宝贝</a></li>
                <li><a   href="session_jsp.jsp">收藏的店铺</a></li>
            </ul>
        </li>
    </ul>

    <ul class="nav">
        <li> <a   href="session_jsp.jsp">商品分类&nbsp;</a>
            <ul class="menu"></ul>
        </li>
    </ul>

    <ul class="nav">
        <li>
            <a   href="session_jsp.jsp">卖家中心&nbsp;</a>
            <ul  class="menu" >
                <li><a   href="session_jsp.jsp">免费开店</a></li>
                <li><a   href="session_jsp.jsp">已卖出的宝贝</a></li>
                <li><a   href="session_jsp.jsp">出售中的宝贝</a></li>
                <li><a   href="session_jsp.jsp">卖家服务市场</a></li>
                <li><a   href="session_jsp.jsp">卖家培训中心</a></li>
                <li><a   href="session_jsp.jsp">体检中心</a></li>
                <li><a   href="session_jsp.jsp">问商友</a></li>
            </ul>
        </li>
    </ul>

    <ul class="nav">
        <li>
            <a   href="session_jsp.jsp">联系客服&nbsp;</a>
            <ul class="menu">
                <li><a   href="session_jsp.jsp">消费者客服</a></li>
                <li><a   href="session_jsp.jsp">卖家客服</a></li>
            </ul>
        </li>
    </ul>

    <ul class="nav">
        <li> <a   href="session_jsp.jsp">网站导航</a>
            <ul class="menu"></ul>
        </li>
    </ul>

    <script>
        var navli=document.querySelectorAll('.nav>li')
        var menu=document.querySelectorAll('.nav .menu')
        navli.forEach(function(item,index){
            item.onmouseenter=function(){
                menu[index].style.display='block'
            }
            item.onmouseleave=function(){
                setTimeout(function(){
                    menu[index].style.display='none'
                },10)
            }
        })
    </script>
</div>
</div>
</div>
<%--空白--%>
<div style=" height:20px;"></div>

<%--搜索框的容器--%>
<div style=" height:50px;">
    <style type="text/css">
        #box{
           <%--宽度--%>
            width:479px;
            /*max-resolution: 30px auto;*/
           <%-- 微软雅黑--%>
            font-family: 'Microsft YaHei';
            <%--字体大小--%>
            font-size: 18px;
            margin-left: auto;

        }
        /*搜索框*/
        #input{
            width: 400px;
            height: 35px;
            /*文本框边框颜色*/
            border: 3px solid #ff4604;
            float: left;
            /* 传图片，设置大小*/
            background-image: url("picture/sousuo.jpg");
            background-repeat: no-repeat;
            background-size: 102px;
            background-position: 0px center;
            /*关键字位置*/
            padding: 0 0 0 100px;

        }
        /*搜索按钮*/
        #search{
            width: 79px;
            height: 35px;
            float: right;
            background: #ff4604;
            color: white;
            text-align: center;
            line-height: 32px;
            cursor: pointer;
        }

        #picture{
            width: 220px;
            height: 100px;
            background-image: url("picture/logo.jpg");
            background-repeat: no-repeat;
            background-size: 180px;
            background-position: 0px center;
            position: absolute;
            left: 245px;
            top: 40px;

        }
         /*去除蓝色边框*/
        .Inpt{outline:none;}

    </style>
    <%--装文本框--%>
    <div style=" width: 800px; margin-left: auto; margin-right: auto;">
     <%--文本框   --%>
    <div id="box" >
        <input id="input" class="Inpt" type="text" name="search" placeholder="搜索">
        <div id="search" >搜索</div>
    </div>
   <%--图片--%>
 <div id="picture"></div>
</div>
</div>

<div style="height: 50px">
    <div style=" width: 900px; margin-left: auto; margin-right: auto;">
    <div  style="color:#ff4604; height: 10px; width:479px; font-family: 'Microsft YaHei';font-size: 18px; ">
        <div style="width: 255px; margin-right: auto;">
            <ul class="nav">
                <li > <a   href="the_shopping_cart.jsp"><b>全部商品&nbsp;</b></a>
                    <ul class="menu"></ul>
                </li>
            </ul>

            <ul class="nav">
                <li>
                    <a href="session_jsp.jsp"><b>降价商品&nbsp;</b></a>
                    <ul class="menu"></ul>
                </li>
            </ul>

            <ul class="nav">
                <li>
                    <a href="session_jsp.jsp"><b>库存紧张&nbsp;</b></a>
                    <ul class="menu"></ul>
                </li>
            </ul>
        </div>
    </div>
    </div>
</div>

<div style="width: 900px; margin-right: auto;margin-left: auto">
    <div style="width: 860px ; margin-right: auto;">
        <%--下划线--%>
        <hr >
    </div>
</div>

<style type="text/css">
    .juli{
        /*距左边框距离*/
        padding-left: 330px;
        /*距上边框距离*/
        padding-top: 10px;
    }
    .juli1{
        /*距左边框距离*/
        padding-left: 250px;
        /*距上边框距离*/
        padding-top: 10px;
    }
    .juli2{
        /*距左边框距离*/
        padding-left: 100px;
        /*距上边框距离*/
        padding-top: 10px;
    }
</style>
<div>
<table >
   <tr >
       <td class="juli">商品信息</td>
       <td class="juli1">单价</td>
       <td class="juli2">数量</td>
       <td class="juli2">金额</td>
       <td class="juli2">操作</td>
   </tr>
</table>
</div>
<div style="height: 10px"></div>
<style type="text/css">
    .juli3{
        /*距右边框距离*/
        padding-left: 5px;
        /*距下边框距离*/
        padding-bottom: 40px;
        border: 0px;
        width: 230px;
    }
    .juli4{
        padding-left: 5px;
        border: 0px;
    }
    .juli5{
        padding-left: 66px;
        padding-bottom: 40px;
        border: 0px;
    }
    .juli6{
        padding-left: 75px;
        padding-bottom: 40px;
        border: 0px;
    }
    .juli7{
        padding-left: 75px;
        padding-bottom: 40px;
        border: 0px;
    }

</style>

<div style="width: 900px; margin-right: auto;margin-left: auto">
    <table border="2" style="border-color: #e2e2e2; background-color:#f5f5f5;  padding-top: 10px;">

        <tr>
            <td class="juli4"><img src="picture/kuzi.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">噩梦INS新款BF风高街国潮嘻哈拉链口袋小脚男女纯色修身休闲裤</a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>

        <tr>
            <td class="juli4"><img src="picture/yifu.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">噩梦INS同款原创复古BF风牛仔夹克BF磨破嘻哈十字架刺绣男女外套 </a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>

        <tr>
            <td class="juli4"><img src="picture/yifu1.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">噩梦INS同款新款嘻哈BF风复古撞色潮牌宽松加绒男女情侣卫衣外套 </a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>

        <tr>
            <td class="juli4"><img src="picture/hua.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">情人节玫瑰花束送女朋友浪漫生日新年礼物女生香皂肥皂花礼盒</a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>

        <tr>
            <td class="juli4"><img src="picture/shouji.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">苹果iPhonex手机壳新款透明套硅胶8X女男全包防摔超薄潮牌壳 </a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>

        <tr>
            <td class="juli4"><img src="picture/yifu2.jpg"></td>
            <td class="juli3" ><a href="session_jsp.jsp">冬季棉衣连帽羽绒棉服外套蝙蝠袖潮面包服男学生韩版短款bf原宿风</a></td>
            <td class="juli5"><b>￥153</b></td>
            <td class="juli6">
                <div class="bookNum">
                    <a id="sub" href="javascript:void(0);">-</a>
                    <input type="text" value="1" id="bookNum" style="width: 40px">
                    <a id="add" href="javascript:void(0);">+</a>
                    <div class="clear"></div>
                </div>
            </td>
            <td class="juli6"><b>￥153</b></td>
            <th class="juli7">
                <a>购买</a>
                <a>删除</a>
            </th>
        </tr>


    </table>
</div>
</body>
</html>