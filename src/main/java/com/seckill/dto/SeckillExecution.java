package com.seckill.dto;

import com.seckill.entity.successKilled;
import com.seckill.enums.SeckillStatEnum;

/**
 * Created by ziheng on 2017/8/22.
 */
public class SeckillExecution {
    private long seckillId;
    private int state;
    private String stateInfo;
    private successKilled successkilled;

    public SeckillExecution(long seckillId,SeckillStatEnum seckillStatEnum) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
    }

    public SeckillExecution(long seckillId, SeckillStatEnum seckillStatEnum , successKilled successkilled) {
        this.seckillId = seckillId;
        this.state = seckillStatEnum.getState();
        this.stateInfo = seckillStatEnum.getStateInfo();
        this.successkilled = successkilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public successKilled getSuccesskilled() {
        return successkilled;
    }

    public void setSuccesskilled(successKilled successkilled) {
        this.successkilled = successkilled;
    }
}
