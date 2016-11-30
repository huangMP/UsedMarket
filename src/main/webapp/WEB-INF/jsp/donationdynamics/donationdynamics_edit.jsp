<%--
  Created by IntelliJ IDEA.
  User: huangMP
  Date: 2016/11/18
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改 捐贈动态</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/UsedMarket/ueditor/lang/zh-cn/zh-cn.js"></script>

    <!-- CSS Bootstrap & Custom -->
    <link href="/UsedMarket/static/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="/UsedMarket/static/css/font-awesome.min.css" rel="stylesheet" media="screen">

    <!-- JavaScripts -->
    <script src="/UsedMarket/static/js/jquery-3.0.0.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<h3>修改动态</h3>

    <input id="dynamicsId" name="dynamicsId" value="${dynamics.dynamicsId}" hidden="hidden"/>
    <input id="addUser" name="addUser" value="${dynamics.addUser}" hidden="hidden"/>
    <input id="type" name="type" value="${dynamics.type}" hidden="hidden"/>

    <table class="table">
        <tr>
            <td>标题</td>
            <td><input id="title" name="title" value="${dynamics.title}"/></td>
        </tr>
        <tr>
            <td>正文</td>
            <td>
                <script id="editor" type="text/plain" style="width:100%;">
                    ${dynamics.text}
                </script>
            </td>
        </tr>
        <tr>
            <td>来源</td>
            <td><input id="origin" name="origin" value="${dynamics.origin}"/></td>
        </tr>
    </table>

    <input type="button" value="提交" id="submitButton" />

<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

    //提交修改
    $("#submitButton").click(function(){

        var dynamicsId_value = $("#dynamicsId").attr("value");
        var addUser_value = $("#addUser").attr("value");
        var text_value= UE.getEditor('editor').getContent();
        var title_value= $("#title").attr("value");
        var origin_value= $("#origin").attr("value");
        var type_value= $("#type").attr("value");

        alert(text_value);

        $.ajax({
            type: 'post',
            url: '/UsedMarket/WebDynamics/update',
            //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
            //contentType:'application/json;charset=utf-8',
            //dataType: dataType,
            data: {"dynamicsId":dynamicsId_value,
                "addUser":addUser_value,
                "text":text_value,
                "title":title_value,
                "origin": origin_value,
                "type": type_value},
            success: function (data) {//返回json结果
                if ("" == data) {
                    alert("修改失败");
                } else {
                    alert("修改成功");
                }
            }
        });
    });
</script>


</body>
</html>

