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

        <span>-----------捐赠动态-----------------------------------</span>
        <h4>跳转到新增动态页面 (web使用的)</h4>
        <form action="/WebDonationDynamics/toInsert" method="post">
            <input type="submit" value="点击按钮跳转">
        </form>

        <span>-----------捐赠动态-----------------------------------</span>
        <h4>通过 dynamicsId 展示某条动态</h4>
        <form action="/DonationDynamics/display" method="post">
            <table>
                <tr>
                    <td>动态Id</td>
                    <td><input name="dynamicsId"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>


        <span>-----------捐赠动态-----------------------------------</span>
        <h4>通过 dynamicsId 修改某条动态 (web使用的) </h4>
        <form action="/WebDonationDynamics/toEdit" method="post">
            <table>
                <tr>
                    <td>动态Id</td>
                    <td><input name="dynamicsId"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>


        <span>-----------捐赠动态-----------------------------------</span>
        <h4>条件查找 </h4>
        <h4>找得到返回 Dynamics的list集合 </h4>
        <form action="/DonationDynamics/listForAndroid" method="post">
            <table>
                <tr>
                    <td>类型</td>
                    <td>
                        <select name="type">
                            <option value="dynamics_id">捐赠动态Id:dynamics_id</option>
                            <option value="add_user">发布用户Id:add_user</option>
                            <option value="title">捐赠动态标题:title</option>
                            <option value="origin">来源:origin</option>
                            <option value="all">不指定列 : all</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>查询值</td>
                    <td><input name="queryValue"/></td>
                </tr>
                <tr>
                    <td>排序方式</td>
                    <td>
                        <select name="order">
                            <option value="ASC">升序:ASC</option>
                            <option value="DESC">降序:DESC</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>排序依据</td>
                    <td>
                        <select name="orderBy">
                            <option value="add_date">发布动态的时间:add_date</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>模糊查询字段</td>
                    <td><input name="indistinctField"/></td>
                </tr>
                <tr>
                    <td>查询位置</td>
                    <td><input name="index"  value="0"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>-----------二手分类-----------------------------------</span>
        <h4>查找所有二手分类 </h4>
        <form action="CommodityCategory/findAll" method="post">
            <input type="submit" value="提交">
        </form>

        <span>-----------二手分类-----------------------------------</span>
        <h4>添加分类 </h4>
        <h4>sort用于 取出的时候进行排序 sort越大，排越前 </h4>
        <form action="/WebCommodityCategory/insert" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>分类名称</td>
                    <td><input name="commodityCategoryName"/></td>
                </tr>
                <tr>
                    <td>排在第几</td>
                    <td><input name="sort" type="number" /></td>
                </tr>
                <tr>
                    <td>图片</td>
                    <td><input name="picture" type="file" /></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>-----------二手分类-----------------------------------</span>
        <h4>根据id删除分类 </h4>
        <form action="/WebCommodityCategory/delete" method="post">
            <table>
                <tr>
                    <td>二手分类id</td>
                    <td><input name="commodityCategoryId"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>-----------二手分类-----------------------------------</span>
        <h4>修改分类 </h4>
        <form action="/WebCommodityCategory/update" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>分类id</td>
                    <td><input name="commodityCategoryId"/></td>
                </tr>
                <tr>
                    <td>分类名称</td>
                    <td><input name="commodityCategoryName"/></td>
                </tr>
                <tr>
                    <td>排在第几</td>
                    <td><input name="sort" type="number" /></td>
                </tr>
                <tr>
                    <td>图片</td>
                    <td><input name="picture" type="file" /></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

    </div>
</div>
</body>

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
</html>