<%--
  Created by IntelliJ IDEA.
  User: huangMP
  Date: 2016/11/18
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en">
<![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8" lang="en">
<![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en"> <!--<![endif]-->
<head>
    <title>校园动态</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/lang/zh-cn/zh-cn.js"></script>

    <!-- CSS Bootstrap & Custom -->
    <link href="/UsedMarket/static/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="/UsedMarket/static/css/font-awesome.min.css" rel="stylesheet" media="screen">
    <link href="/UsedMarket/static/css/templatemo_style.css" rel="stylesheet" media="screen">

    <!-- Favicons -->
    <link rel="shortcut icon" href="/UsedMarket/static/images/ico/favicon.ico">

    <!-- JavaScripts -->
    <script src="/UsedMarket/static/js/jquery-3.0.0.js"></script>
    <script src="/UsedMarket/static/js/modernizr.js"></script>

</head>
<body>


<div class="overlay-bg"></div>


<div class="main-content">
    <div class="container">
        <div class="row">


            <div class="content-inner">
                <div class="row">
                    <!-- <div class="col-md-12 col-sm-12"> -->
                    <div>
                        <div class="team-member">
                            <div class="member-infos">

                                <div style="color:black;" >
                                    <h2>${dynamics.title }</h2>
                                    <div style="text-align: right">${dynamics.addDate}</div>
                                    <hr/>
                                    ${dynamics.text }
                                </div>

                            </div>
                        </div>
                    </div> <!-- /.col-md-4 -->

                </div> <!-- /.row -->


            </div> <!-- /.content-inner -->


        </div> <!-- /.row -->

        </div>
    </div> <!-- /.container -->
</div> <!-- /.main-content -->


<script src="/static/js/jquery-3.0.0.js"></script>
<script type="text/javascript">
    /*    $(function(){
     $.ajax({
     type:'post',
     url:'/UserInfo/login',
     //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
     //contentType:'application/json;charset=utf-8',
     //数据格式是json串，商品信息
     data:{username:"11111",password:"1111"},
     success:function(data){//返回json结果
     if( "" == data ){
     alert("是null");
     }else{
     alert("不是null");
     }
     alert(data);
     }
     });
     });*/

</script>


</body>
</html>
