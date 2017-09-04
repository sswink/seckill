<%@include file="common/tag.jsp"%>
<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀主页</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>名称</th>
                        <th>库存</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>详情页</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sk" items="${list}">
                        <tr>
                            <td>${sk.name}</td>
                            <td>${sk.number}</td>
                            <td><fmt:formatDate value="${sk.startTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/> </td>
                            <td><fmt:formatDate value="${sk.endTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/> </td>
                            <td><fmt:formatDate value="${sk.createTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/> </td>
                            <td><a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">详情</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>