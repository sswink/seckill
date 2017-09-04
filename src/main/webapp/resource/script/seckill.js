
var seckill= {
    URL: {
        now: function () {
            return '/seckill/time/now';
        },
        exposer:function (seckillId) {
            return'/seckill/'+seckillId+'/exposer'
        },
        execution:function (seckillId,md5) {
            return '/seckill/'+seckillId+'/'+md5+'/execution'
        }
    },
    detail: {
        handleSeckillkill:function (seckillId,node) {
            node.hide()
                .html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>')
                $.post(seckill.URL.exposer(seckillId),{},function (result) {
                    //在回调函数中，执行交互流程
                    if(result&&result['success']){
                        var exposer=result['data'];
                        if(exposer['exposed']){
                            //开启秒杀
                            //获取秒杀地址,
                            var md5=exposer['md5'];

                            $('#killBtn').one('click',function () {
                                //执行秒杀请求；
                                $(this).addClass('disabled');
                                console.log(seckill.URL.execution(seckillId,md5));
                                $.post(seckill.URL.execution(seckillId,md5),{},function (result) {
                                    console.log(result);
                                    if(result&&result['success']){
                                        var killResult=result['data'];
                                        var state=killResult['state'];
                                        var stateInfo=killResult['stateInfo'];
                                        node.html('<span class="label label-success">'+stateInfo+'</span>');
                                    }
                                })
                            })
                            node.show();
                        }else {
                            var now=exposer['now'];
                            var start=exposer['start'];
                            var end =exposer['end'];
                            seckill.countdown(seckillId,now,start,end);
                        }

                    }

                })
        },
        validatePhone: function (killPhone) {
            if (killPhone && killPhone.length == 11 && !isNaN(killPhone)) {
                return true;
            }
            else
                return false;

        },
        countdown: function (seckillId, nowTime, startTime, endTime) {
            var seckillBox = $('#seckill-box');
            console.log(nowTime < startTime);
            if (nowTime > endTime) {
                seckillBox.html('秒杀结束');
            } else if (nowTime < startTime) {
                var killTime = new Date(startTime + 1000);
                seckillBox.countdown(killTime, function (event) {
                    var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒')
                    console.log(format);
                    seckillBox.html(format);
                }).on('finish.countdown',function(){
                    //获取秒杀地址，控制显示逻辑，执行秒杀
                    seckill.detail.handleSeckillkill(seckillId,seckillBox);
                });
            }else{
                 seckill.detail.handleSeckillkill(seckillId,seckillBox);
            }
        },
        init: function (params) {
            var killPhone = $.cookie('killPhone');

            if (!seckill.detail.validatePhone(killPhone)) {
                var killPhoneModel = $('#killPhoneModel');
                killPhoneModel.modal({
                    show: true,
                    backdrop: false,
                    keyboard: false
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    if (seckill.detail.validatePhone(inputPhone)) {
                        $.cookie('killPhone', inputPhone, {expiress: 7, path: '/seckill'});
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger" >手机号错误！</label>').show(300);
                    }
                })
            }
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];
            $.get(
                '/seckill/time/now',{}, function (result) {
                    if (result && result['success']) {
                        var nowTime = result['data'];
                        seckill.detail.countdown(seckillId, nowTime, startTime, endTime);

                    } else {
                        console.log(result)
                    }
                }
            )
        }
    }
}