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
    <title>添加 捐贈动态</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="/ueditor/lang/zh-cn/zh-cn.js"></script>

    <!-- CSS Bootstrap & Custom -->
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="/css/font-awesome.min.css" rel="stylesheet" media="screen">

    <!-- JavaScripts -->
    <script src="/js/jquery-3.0.0.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<h3>添加校园动态</h3>
<form action="/Dynamics/insert" method="post" >
    <table class="table">
        <tr>
            <td>动态类别</td>
            <td>
                <select name="type">
                    <option value="1">校园动态:1</option>
                    <option value="2">捐赠动态:2</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>标题</td>
            <td><input name="title" /></td>
        </tr>
        <tr>
            <td>正文</td>
            <td>
                <input name="text" id="text" hidden="hidden" />
                <script id="editor" type="text/plain" style="width:100%;"></script>
            </td>
        </tr>
        <tr>
            <td>来源</td>
            <td><input name="origin"/></td>
        </tr>
    </table>

    <input type="submit" value="提交" id="submitButton" />
</form>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

    //点击提交按钮时，将富文本框的内容，赋值给 正文input输入框
    $("#submitButton").click(function(){
        //alert(UE.getEditor('editor').getContent());
        $("#text").val(UE.getEditor('editor').getContent());
        return true;
    });

</script>


</body>
</html>

