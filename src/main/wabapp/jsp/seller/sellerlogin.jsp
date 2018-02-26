<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/26
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script  type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
//            滑入滑出效果
            $("#sellerlogin").click(function(){
                $("#login").slideDown("slow");
                $("#register").slideUp("slow");
            });
            $("#sellerregister").click(function(){
                $("#login").slideUp("slow");
                $("#register").slideDown("slow");
            });
//            隐藏快速注册界面
            $("#register").hide();
        });
    </script>

</head>
<body>

    <div style="width: 300px;margin: 0 auto;background-color: #ededed;">

            <div style="font-size: 20px;border-bottom: 1px solid cornflowerblue;">
                <span id="sellerlogin">卖家登陆</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <span id="sellerregister">快速注册</span>
            </div>

            <br/>

        <%--登陆--%>
            <form id="login" action="my">
            <label id="username">
                用户名：<input type="text" name="username"/>
            </label>
            <br/><br/><br/>
            <label id="password">
                密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id=""/>
            </label>
            <br/><br/><br/>
            <span style="text-align: center;left: 20px;">
            <button type="submit">登&nbsp;&nbsp;&nbsp;陆</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset">重&nbsp;&nbsp;&nbsp;置</button>
            </span>
        </form>

        <%--快速注册--%>
        <form id="register" action="my">
            <label id="new_username">
                用户名：<input type="text" name="username"/>
            </label>
            <br/><br/>
            <label id="new_password">
                密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" />
            </label>
            <br/><br/>
            <label id="new_password2">
                确认密码：<input type="password" name="password" />
            </label>
            <%--错误信息提示--%>
            <label id="message"></label>
            <br/><br/>

            <label id="new_paypassword">
                支付密码：<input type="password" name="password" />
            </label>
            <br/><br/>
            <span style="text-align: center;left: 20px;">
            <button type="submit">注&nbsp;&nbsp;&nbsp;册</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="reset">重&nbsp;&nbsp;&nbsp;置</button>
            </span>
        </form>

    </div>
<script type="text/javascript">
    $(document).ready(function(){
        $("#new_password2 input").blur(function () {
            var password=$("#new_password input").val();
            var password2=$("#new_password2 input").val();
            if(password!=password2){
                $("#message").html("*两次密码不一致！！！");
                $("#message").css("color","red");
            }
        })

    });
</script>
</body>
</html>
