<%--
  Created by IntelliJ IDEA.
  User: huangMP
  Date: 2016/11/19
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en">
<![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8" lang="en">
<![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <title>登录广商微淘</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    <meta charset="UTF-8">



    <!-- CSS Bootstrap & Custom -->
    <link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="/static/css/templatemo_style.css" rel="stylesheet" media="screen">

    <script src="/static/js/jquery-3.0.0.js"></script>

    <!-- JavaScripts -->
    <!--[if lt IE 8]>
    <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" alt="" /></a>
    </div>
    <![endif]-->
</head>
<body>


<div class="bg-image"></div>
<div class="overlay-bg"></div>


<div class="main-content">
    <div class="container">
        <div class="row">

            <!-- Begin Content -->
            <div class="col-md-10">

                <div class="row">
                    <div class="col-md-12">
                        <div class="templatemo_logo">
                            <a href="#">
                                <img src="/static/images/templatemo_logo.png" alt="Genius">
                            </a>
                        </div> <!-- /.logo -->
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->


                <div id="menu-container">

                    <div id="menu-2" class="content">
                        <div class="page-header">
                            <h2 class="page-title" style="color:white;">用户登录</h2>
                        </div> <!-- /.page-header -->
                        <div class="content-inner">
                            <div class="row">
                                <div class="col-md-7">
                                    <h3 class="widget-title" style="color:#3377aa;">What is our goal?</h3>
                                    <p>Our goal is to give you <a href="#">free website templates</a> that you can use for any purpose. Genius is free HTML5 CSS3 template provided by <a href="#">templatemo</a> for everyone. This website template can be viewed in tablets and mobile devices. You may support us by providing a credit link at the footer of your website.</p>
                                    <p>Credit goes to <a rel="nofollow" href="#">Unsplash</a> for background images used in this template. This layout is based on <a rel="nofollow" href="http://getbootstrap.com">Bootstrap</a> responsive framework. Home and Gallery pages are integrated with <a rel="nofollow" href="https://github.com/duncanmcdougall/Responsive-Lightbox">Responsive Lightbox</a> for images.</p>
                                </div> <!-- /.col-md-7 -->
                                <div class="col-md-4">
                                    <h3 style="color:red;  margin: 0 0 0 0;">${errorMassage}</h3>

                                    <form action="/WebLogin/doLogin" method="post">
                                      <div class="contact-form">
                                          <p class="full-row">
                                                <h4 style="color:white;">用户名:</h4>
                                                <input id="username" name="username" type="text" maxlength="20" style="font-size:20px;">
                                          </p>
                                          <p class="full-row">
                                            <h4 style="color:white;">密码:</h4>
                                            <input id="password" name="password" type="password"  maxlength="20" style="font-size:20px;">
                                          </p>
                                        </div>
                                      <input id="submitButton" type="submit" name="" value="点击登录">
                                    </form>

                                </div><!-- /.col-md-4 -->
                            </div> <!-- /.row -->

                        </div> <!-- /.content-inner -->
                    </div> <!-- /.about-us -->

                </div> <!-- /.content-holder -->

            </div> <!-- /.col-md-10 -->
        </div> <!-- /.row -->
    </div> <!-- /.container -->
</div> <!-- /.main-content -->


<script src="/static/js/jquery-3.0.0.js"></script>
<script type="text/javascript">
/*
    $("#submitButton").click(function () {

        var username_value = $("#username").val();
        var password_value = $("#password").val();

        alert(username_value);
        alert(password_value);
        $.ajax({
            type:'post',
            url:'/webLogin/doLogin',
            //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
            //contentType:'application/json;charset=utf-8',
            //数据格式是json串，商品信息
            data:{username: username_value ,password: password_value },
            success:function(data){//返回json结果
            }
        });
    });*/

</script>

</body>
</html>