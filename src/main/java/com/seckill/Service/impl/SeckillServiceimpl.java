package com.seckill.Service.impl;

import com.seckill.Service.SeckillService;
import com.seckill.dao.SeckillDao;
import com.seckill.dao.successKilledDao;
import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.entity.Seckill;
import com.seckill.entity.successKilled;
import com.seckill.enums.SeckillStatEnum;
import com.seckill.exception.RepeatkillException;
import com.seckill.exception.SeckillCloseException;
import com.seckill.exception.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by ziheng on 2017/8/23.
 */
@Service
public class SeckillServiceimpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private successKilledDao successKilledDao;

    private String slat = "[]qweqwe23[12]312";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 50);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if ((nowTime.getTime() < startTime.getTime() )|| (nowTime.getTime() > endTime.getTime())){
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    @Transactional
    public SeckillExecution executeseckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatkillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            System.out.println(md5);
            throw new SeckillException("Seckill data rewrite");
        }
        try {
            Date now =new Date();
            int updateCount = seckillDao.reduceNumber(seckillId,now);
            if(updateCount<=0){
                throw new SeckillCloseException("Seckill is closed");
            }else {
                int  insertCount= successKilledDao.insertSuccesskilled(seckillId, userPhone);
//            System.out.println(insertCount);
                if (insertCount <= 0) {
                    throw new RepeatkillException("seckill repeat");
                } else {
                    successKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }

        }catch (SeckillCloseException e1){
            throw e1;
        }
        catch (RepeatkillException e2){
            throw e2;
        }
        catch (Exception e) {
            logger.error(e.getMessage(),e);
            //转化为运行时异常
            throw new SeckillException("Seckill inner error:"+e.getMessage());
        }

    }
}
