<%--
  Created by IntelliJ IDEA.
  User: huangMP
  Date: 2016/11/20
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>系统主页</title>
</head>
<body>
<h1>这是系统主页</h1>


<h3>角色设置</h3>
<h4>----------------添加角色----------------</h4>
<form action="/WebRole/insert" method="post">
    <table>
        <tr>
            <td>角色英文名称</td>
            <td><input name="roleName"/></td>
        </tr>
        <tr>
            <td>角色自定义名称</td>
            <td><input name="roleRealName"/></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select name="roleRealName">
                    <option value="1">使用：1</option>
                    <option value="”0">停用：0</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>

<h4>----------------查找角色----------------</h4>
<form action="/WebRole/findByRoleName" method="post">
    <table>
        <tr>
            <td>角色英文名称</td>
            <td><input name="roleName"/></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>

<h4>----------------查找角色----------------</h4>
<form action="/WebRole/findByRoleId" method="post">
    <table>
        <tr>
            <td>角色Id</td>
            <td><input name="roleId"/></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>

<h4>----------------查找角色----------------</h4>
<form action="/WebRole/findByStatus" method="post">
    <table>
        <tr>
            <td>角色状态</td>
            <td>
                <select name="status">
                    <option value="1">使用：1</option>
                    <option value="”0">停用：0</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>

<h4>----------------修改角色----------------</h4>
<form action="/WebRole/update" method="post">
    <table>
        <tr>
            <td>角色Id</td>
            <td><input name="roleId"/></td>
        </tr>
        <tr>
            <td>角色英文名称</td>
            <td><input name="roleName"/></td>
        </tr>
        <tr>
            <td>角色自定义名称</td>
            <td><input name="roleRealName"/></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select name="status">
                    <option value="1">使用：1</option>
                    <option value="”0">停用：0</option>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>

<h4>----------------删除角色----------------</h4>
<form action="/WebRole/delete" method="post">
    <table>
        <tr>
            <td>角色Id</td>
            <td><input name="roleId"/></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>





</body>

<script src="/static/js/jquery-3.0.0.js"></script>
<script type="text/javascript">
</script>
</html>