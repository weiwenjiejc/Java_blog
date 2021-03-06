<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${sp}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${sp}/layui/css/layui.css">
    <script rel="script" src="${sp}/js/jquery.min.js"></script>
    <script rel="script" src="${sp}/bootstrap/js/bootstrap.js"></script>
    <script rel="script" src="${sp}/layui/layui.js"></script>
</head>
<body>
<div>
    <ul class="layui-nav layui-bg-green">
        <li class="layui-nav-item"><a href="/">guardcode</a></li>
        <li class="layui-nav-item"><a href="/">首页</a></li>
        <li class="layui-nav-item"><a href="/html/login">登录</a></li>
        <li class="layui-nav-item layui-this"><a href="/html/register">注册</a></li>
    </ul>
    <script>
        layui.use('element', function () {
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

            //监听导航点击
            element.on('nav(demo)', function (elem) {
                //console.log(elem)
                layer.msg(elem.text());
            });
        });
    </script>
</div>
<div style="width: 40%; margin: 100px auto">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>新用户注册</legend>
    </fieldset>

    <form class="layui-form" action="/request/login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="username" autocomplete="on" placeholder="请输入标题"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" lay-verify="password" autocomplete="off" placeholder="默认密码123"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">重复密码</label>
            <div class="layui-input-block">
                <input type="text" name="repassword" lay-verify="repassword" autocomplete="off" placeholder="默认密码123"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">注册</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layedit'], function () {
        var form = layui.form
            , layer = layui.layer

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
            , content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo1)', function (data) {
            /*
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })*/
            layer.alert('感谢使用，此功能尚未开通', {
                title: '提示'
            })
            return false;
        });
    });
</script>
</body>
</html>