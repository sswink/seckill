package com.seckill.entity;

/**
 * Created by ziheng on 2017/8/21.
 */
public class successKilled {
    private long seckillId;
    private String phone;
    private short state;
    private Seckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "successKilled{" +
                "seckillId=" + seckillId +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", seckill=" + seckill +
                '}';
    }
}
