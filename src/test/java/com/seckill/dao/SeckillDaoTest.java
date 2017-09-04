package com.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ziheng on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {
        Date killtime=new Date();
        Integer count=seckillDao.reduceNumber(1000,killtime);
        System.out.println(count);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill=seckillDao.queryById(1000);
        System.out.println(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> list=seckillDao.queryAll(0,50);
        System.out.println(list);
    }
}