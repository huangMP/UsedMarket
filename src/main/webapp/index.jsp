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
        <form action="UserInfo/insert" method="post" enctype="multipart/form-data">
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
        <form action="UserInfo/login" method="post" enctype="multipart/form-data">
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
        <h3>测试修改密码</h3><br/>
        <form action="UserInfo/editPassword" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>用户Id</td>
                    <td><input name="userId"/></td>
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
            <input type="submit" value="修改">
        </form>

        <span>----------------------------------------------</span>
        <h3>测试修改头像</h3><br/>
        <form action="UserInfo/editHeadPortrait" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>用户Id</td>
                    <td><input name="userId"/></td>
                </tr>
                <tr>
                    <td>新头像</td>
                    <td><input type="file" name="headPortrait"></td>
                </tr>
            </table>
            <input type="submit" value="修改">
        </form>

        <span>----------------------------------------------</span>
        <h3>测试按列修改</h3><br/>
        <h4>注意：修改成功返回dto的UserInfoCustom，修改失败返回null</h4><br/>
        <form action="UserInfo/edit" method="post">
            <table>
                <tr>
                    <td>用户Id</td>
                    <td><input name="userId"/></td>
                </tr>
                <tr>
                    <td>要修改的列</td>
                    <td>
                        <select name="index">
                            <option value="password">密码：password</option>
                            <option value="phone">手机：phone</option>
                            <option value="sex">性别：sex</option>
                            <option value="yearOfBirth">出生年：yearOfBirth</option>
                            <option value="IDNum">身份证号：IDNum</option>
                            <option value="realName">真实姓名：realName</option>
                            <option value="school">学校：school</option>
                            <option value="shippingAddress">收货地址：shippingAddress</option>
                            <option value="constellation">星座：constellation</option>
                            <option value="bloodType">血型：bloodType</option>
                            <option value="signature">个性签名：signature</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>当前值</td>
                    <td><input name="currentValue"/></td>
                </tr>
                <tr>
                    <td>未来值</td>
                    <td><input name="futureValue"/></td>
                </tr>
            </table>
            <input type="submit" value="修改">
        </form>

        <span>----------------------------------------------</span>
        <h4>根据userId查询该用户发布的二手商品及数量</h4>
        <form action="UserInfo/findCommodityCustomByUserId" method="post">
            <table>
                <tr>
                    <td>userId</td>
                    <td><input name="userId"/></td>
                </tr>
                <tr>
                    <td>从第</td>
                    <td><input name="index" /><span>条开始查</span></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>----------------------------------------------</span>
        <h3>根据用户Id查询返回用户信息</h3><br/>
        <h4>注意：该用户存在返回dto的UserInfoCustom，没有该用户返回null</h4><br/>
        <form action="UserInfo/findUserInfoCustomByUserId" method="post">
            <table>
                <tr>
                    <td>用户Id</td>
                    <td><input name="userId" /></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>
        <span>----------------------------------------------</span>
        <h4>上传</h4>
        <form action="Commodity/upload" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>用户id</td>
                    <td><input name="userId"/></td>
                </tr>
                <tr>
                    <td>店铺id</td>
                    <td><input name="storeId"/></td>
                </tr>
                <tr>
                    <td>商品名称</td>
                    <td><input name="commodityName"/></td>
                </tr>
                <tr>
                    <td>类别</td>
                    <td><input name="category"/></td>
                </tr>
                <tr>
                    <td>价格</td>
                    <td><input name="price"/></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input name="amount"/></td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td><input name="description"/></td>
                </tr>
                <tr>
                    <td>定位</td>
                    <td><input name="location"/></td>
                </tr>
                <tr>
                    <td>图片1</td>
                    <td><input type="file" name="images"></td>
                </tr>
                <tr>
                    <td>图片2</td>
                    <td><input type="file" name="images"></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>----------------------------------------------</span>
        <h4>更新数据</h4>
        <form action="Commodity/updateCommodityNum" method="post">
            <table>
                <tr>
                    <td>商品id</td>
                    <td><input name="commodityId"/></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input name="amount"/></td>
                </tr>
                <tr>
                    <td>价格</td>
                    <td><input name="price"/></td>
                </tr>
                <tr>
                    <td>销售量</td>
                    <td><input name="salesVolume"/></td>
                </tr>
                <tr>
                    <td>收藏人数</td>
                    <td><input name="preferNum"/></td>
                </tr>
                <tr>
                    <td>销售状态</td>
                    <td><input name="status"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>----------------------------------------------</span>

        <h4>查找</h4>
        <form action="Commodity/search" method="post">
            <table>
                <tr>
                    <td>类型</td>
                    <td><input name="type"/></td>
                </tr>
                <tr>
                    <td>查询值</td>
                    <td><input name="queryValue"/></td>
                </tr>
                <tr>
                    <td>排序方式</td>
                    <td><input name="order"/></td>
                </tr>
                <tr>
                    <td>排序依据</td>
                    <td><input name="orderBy"/></td>
                </tr>
                <tr>
                    <td>模糊查询字段</td>
                    <td><input name="indistinctField"/></td>
                </tr>
                <tr>
                    <td>查询位置</td>
                    <td><input name="index"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>----------------------------------------------</span>

        <h4>删除</h4>
        <form action="Commodity/delete" method="post">
            <table>
                <tr>
                    <td>商品id</td>
                    <td><input name="commodityId"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>


        <span>-----------捐赠物品-----------------------------------</span>
        <h3>上传捐赠物品</h3>
        <h4>上传成功返回DonationDto，失败返回null</h4>
        <form action="Donation/insert" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>用户id</td>
                    <td><input name="userId"/></td>
                </tr>
                <tr>
                    <td>捐赠物品名称</td>
                    <td><input name="donationName"/></td>
                </tr>
                <tr>
                    <td>类别</td>
                    <td><input name="category"/></td>
                </tr>
                <tr>
                    <td>数量</td>
                    <td><input name="amount"/></td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td><input name="description"/></td>
                </tr>
                <tr>
                    <td>定位</td>
                    <td><input name="location"/></td>
                </tr>
                <tr>
                    <td>图片1</td>
                    <td><input type="file" name="images"></td>
                </tr>
                <tr>
                    <td>图片2</td>
                    <td><input type="file" name="images"></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

        <span>-----------捐赠物品-----------------------------------</span>
        <h4>查找</h4>
        <h4>找得到返回 DonationCustom的list集合 </h4>
        <form action="Donation/search" method="post">
            <table>
                <tr>
                    <td>类型</td>
                    <td>
                        <select name="type">
                            <option value="donation_id">捐赠物品Id:donationId</option>
                            <option value="user_id">发布用户Id:userId</option>
                            <option value="donation_name">捐赠物品名称:donationName</option>
                            <option value="category">分类:category</option>
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
                            <option value="donation_date">发布捐赠的时间:donationDate</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>模糊查询字段</td>
                    <td><input name="indistinctField"/></td>
                </tr>
                <tr>
                    <td>查询位置</td>
                    <td><input name="index"/></td>
                </tr>
            </table>
            <input type="submit" value="提交">
        </form>

    </div>
</div>
</body>

<script src="js/jquery-3.0.0.js"></script>
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
