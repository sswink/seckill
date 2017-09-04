package com.seckill.dao;

import com.seckill.entity.successKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ziheng on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class successKilledDaoTest {
    @Autowired
    private successKilledDao successkilledDao;
    @Test
    public void insertSuccesskilled() throws Exception {
        successkilledDao.insertSuccesskilled(1001,3232323);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        successKilled successKilled= successkilledDao.queryByIdWithSeckill(1001,3232323);
        System.out.println(successKilled);
    }

}