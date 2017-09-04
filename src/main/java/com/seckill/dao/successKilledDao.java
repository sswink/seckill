package com.seckill.dao;

import com.seckill.entity.successKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ziheng on 2017/8/22.
 */
public interface successKilledDao {
//    插入购买明细,可过滤重复
    int insertSuccesskilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
//    根据ID查询Successkilled 并携带秒杀产品对象
    successKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);



}
