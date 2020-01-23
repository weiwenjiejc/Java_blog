<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }/static" var="sp"></c:set>
<c:set value="${pageContext.request.contextPath }" var="rp"></c:set>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${sp}/bootstrap/css/bootstrap.css${sp}/">
    <link rel="stylesheet" href="${sp}/layui/css/layui.css${sp}/">
    <script rel="script" src="${sp}/js/jquery.min.js${sp}/"></script>
    <script rel="script" src="${sp}/bootstrap/js/bootstrap.js${sp}/"></script>
    <script rel="script" src="${sp}/layui/layui.js${sp}/"></script>
</head>
<body>
<div>

    <jsp:include page="nav.jsp"></jsp:include>
</div>
<div>
    <form class="layui-form" action="/post_r" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" name="p_title" lay-verify="p_title" placeholder="请输入标题" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea lay-verify="p_content" name="p_content" placeholder="请输入内容" class="layui-textarea" id="demo"
                          style="display: none"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <script>
        layui.use(['form', 'layedit', 'layer'], function () {
            var layedit = layui.layedit;
            var layer = layui.layer;
            layedit.set({
                uploadImage: {
                    url: '/upload_image' //接口url
                    , type: 'post' //默认post
                }
            });
            var index = layedit.build('demo', {
                height: 300
            }); //建立编辑器
            var form = layui.form;
            form.verify({
                p_content: function (value) {
                    return index.sync(index);
                }
            })
            //监听提交
            form.on('submit(formDemo)', function (data) {
                layer.msg(JSON.stringify(data.field));
                alert(data)
                console.log(data)
                return false;
            });
        });
    </script>
</div>
</body>
</html>