<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.StoreGoods" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/30 0030
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="" %>--%>
<% StoreGoods storeGoods= (StoreGoods) request.getAttribute("1");%>
<html>
<head>
    <title>购买商品页面</title>
    <link href="../css/StoreGoods.css " rel="stylesheet" type="text/css"/>
    <script src="jquery-3.2.1.min.js"></script>

    </head>
<body>
<form action="/Buy.htm" method="post">
<%--< c:forEach item="${seller}" var="seller">--%>
    <%--<div><img src="images/popo%20(2).jpg">--%>
<%--设置图片和文字位置浮动--%>
<div class="zhuti">
    <div class="main">

        <div>
            <div class="float_left">
                <%--图片引用和大小--%>
                <img src="../images/vaida.jpg" width="350px" height="418px" /></div>
        </div>
        <p class="margin"></p>
        <div class="float_left">
            <div class="float_right">
                <div>
                    <div>
                        <%--商品购买详情--%>
                        <h1 class="margin2" >
                            <div id="page">Welcome</div>
                        </h1>
                    </div>
                    <div>
                        <b style="color: red" class="margin3" >
                            急件降急降！
                        </b>
                    </div>
                    <div>
                        <dl><dt class="margin3">运费:</dt></dl>
                        <div>
                            <span class="margin4">北上广</span>至
                            <span><span role="button" tabindex="1">&nbsp;成都</span></span>
                            <div>
                                <b><span class="margin3">快递: 0.00 </span>
                                </b>
                            </div>
                        </div>
                    </div>
                    <ul>
                        <li><span class="margin3">月销量:</span><span class="tm-count">22.0</span></li>
                        <li ><span class="margin3">累计评价:</span><span class="tm-count">35.0</span></li>
                    </ul>
                    <dl>
                        <dt class="margin3">颜色分类</dt>
                        <dd>
                            <ul>
                                <li>
                                    <a >
                                        <span class="margin4">男款白色</span>
                                    </a>
                                </li>
                                <li>
                                    <a >
                                        <span class="margin4">男款黑色</span>
                                    </a>
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <div>
                        <dt class="margin3">数量:</dt>
                        <%--<input class="margin3" maxlength="8" title="请输入购买量:" value="5"  type="text">--%>
                        <div class="know">
                            <input id="min"  class="margin3" type="button" value="-" />
                            <input id="text_box" name="StoreGoodsNumber" type="text" value="${item.value.quantity }" style="width:50px;" />
                            <input id="add"  type="button" value="+" /></td>
                            <script>
                                $(function(){
                                    var t = $("#text_box");
                                    $("#add").click(function(){
                                        t.val(parseInt(t.val())+1)
                                        setTotal();
                                    })
                                    $("#min").click(function(){
                                        t.val(parseInt(t.val())-1)
                                        setTotal();
                                    })
                                    function setTotal(){
                                        var tt = $("#text_box").val();
                                        var  pbinfoid=$("#pbinfoid").val();
                                        if(tt<=0){
                                            alert('输入的值错误！');
                                            t.val(parseInt(t.val())+1)
                                        }else if(tt>= ${goodsSellerRelation.getInventory()}){
                                            alert('输入的值错误！');
                                            t.val(parseInt(t.val())-1)
                                        }
                                    }
                                })
                            </script>
                            <span class="unit">件</span></span>
                            <em style="display: inline;" id="reptorpay" class="margin3">库存:件</em>
                        </div>

                        <div>
                            <div>
                                <a href="../jsp/the_shopping_cart.jsp" rel="nofollow" data-addfastbuy="true" title="点击此按钮，到下一步确认购买信息。" class="margin3">立即购买<span class="ensureText">确认</span></a>
                            </div>
                            <%--<div><a rel="nofollow"><i></i>加入购物车<span class="ensureText">确认</span></a></div>--%>
                            <%--<div><a rel="nofollow"><i></i>加入购物车</a></div>--%>
                            <button class="btn" type="button" name="购物车" style="background-color: red" class="margin4" ><a href="../jsp/the_shopping_cart.jsp" style="text-decoration: none">添加到购物车</a></button>
                            <button class="btn" type="button" name="购买" style="background-color: red" class="margin3"><a href="../jsp/the_shopping_cart.jsp" style="text-decoration: none">立即购买</a> </button>
                        </div>
                            <dl>
                                <dt class="margin3">服务承诺</dt>
                                <dd>
                                    <ul>
                                        <li class="margin4"><a href="http://www.baidu.com" title="商家依据国家法定条款和天猫服务规范在承诺的时效内向消费者提供商品三包服务" target="_blank" >
                                            三包服务</a></li><li class="margin4"><a href="http://www.taobao.com" title="该商品由中国人保承保正品保证险" target="_blank" >
                                        正品保证</a></li><li class="margin4"><a href="http://www.taobao.com" title="极速退款是为诚信会员提供的退款退货流程的专享特权，额度是根据每个用户当前的信誉评级情况而定"  target="_blank">
                                        极速退款</a></li><li class="margin4"><a href="http://www.baidu.com"  title="卖家为您购买的商品投保退货运费险" target="_blank">
                                        赠运费险</a></li><li class="margin4"><a href="http://www.baidu.com" title="七天无理由退换" target="_blank" >
                                        七天无理由退换</a></li>
                                    </ul>
                                </dd>
                            </dl>
                            <em class="margin3">支付方式</em>
                            <em style="display: inline;" title="显示所有信息" ></em>
                            <div >
                                <a title="支持使用信用卡支付" target="_blank" href="http://www.baidu.com" class="margin4" del="del">信用卡</a>
                                <a title="支持用绑定了支付宝的银行卡付款" href="../jsp/Payment.jsp" target="_blank" class="margin3" >快捷支付 <s style="background: url(images/vaida.jpg);"></s></a>
                                <a title="利用花呗支付，下月10号还款" href="http://www.baidu.com" target="_blank" class="margin3" del="del">蚂蚁花呗 <s style="background: url(images/vaida.jpg);"></s></a>
                                <a title="支持使用余额宝付款，边赚边花" href="http://www.baidu.com" target="_blank" class="margin3" del="del">余额宝 <s style="background: url(images/vaida.jpg);"></s></a>
                        </div>
                    </div>
                </div>
            </div>
            </p>
        </div>
    </div>
</div>
</form>
</body>
</html>
