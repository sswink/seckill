<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/tag.jsp"%>
<script src="/resource/script/seckill.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.js"></script>
<style type="text/css">
    .modal{
        z-index: 1000;
    }
    .modal-backdrop{
        z-index: 99;
    }
</style>
<script type="text/javascript">
    $(function(){
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time},
            endTime:${seckill.endTime.time}
        })
    });
</script>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀主页</title>
    <%@include file="common/head.jsp"%>
</head>
<body style="z-index: 2">

<div class="container"  style="z-index: 1">
    <div class="panel panel-default text-center">
        <div class="panel-heading">
            <h3>${seckill.name}</h3>
        </div>
        <div class="panel-body">
            <h2 class="text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>

</div>
<div id="killPhoneModel"  style="z-index: 0" class="model fade">
    <div class="model-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号^0^" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="model-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>



</html>