<%--
  Created by IntelliJ IDEA.
  User: huangMP
  Date: 2016/10/23
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
</head>
<body>
<div>
    <div>
        <span>----------------------------------------------</span>
        <h3>测试注册</h3><br/>
        <form action="/UserInfo/insertUserInfo" method="post" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input name="username" /></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="password" /></td>
                </tr>
                <tr>
                    <td>手机</td>
                    <td><input name="phone" /></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input name="sex" /></td>
                </tr>
                <tr>
                    <td>头像</td>
                    <td><input type="file" name="headPortrait" ></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>----------------------------------------------</span>
        <h3>测试登录</h3><br/>
        <form action="/UserInfo/UserLogin" method="post" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input name="username" /></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="password" /></td>
                </tr>
            </table>
            <input type="submit" value="登录">
        </form>

        <span>----------------------------------------------</span>
        <h3>测试登录</h3><br/>
        <form action="/UserInfo/EditPassword" method="post" enctype="multipart/form-data" >
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input name="username" /></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="password" /></td>
                </tr>
                <tr>
                    <td>新密码</td>
                    <td><input name="newPassword" /></td>
                </tr>
            </table>
            <input type="submit" value="登录">
        </form>
    </div>
</div>
</body>

<script src="js/jquery-3.0.0.js"></script>
<script type="text/javascript">

  /*  $(function(){
        $.ajax({
            type:'post',
            url:'/UserInfo/insertUserInfo',
            //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
            //contentType:'application/json;charset=utf-8',
            //数据格式是json串，商品信息
            data:{username:"zpx",password:"zpx"},
                    //"username=zpx&&password=zpx",
            success:function(data){//返回json结果
                alert(data);
            }
        });
    });*/

</script>
</html>
