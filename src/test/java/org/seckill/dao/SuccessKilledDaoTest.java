package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Winter on 2017/4/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        long userPhone = 15011332233L;
        int count = successKilledDao.insertSuccessKilled(id,userPhone);
        System.out.println("count:" + count);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long userPhone = 15011332233L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, userPhone);
        System.out.println("successKilled:" + successKilled);
        System.out.println("seckill:" + successKilled.getSeckill());
        /**
         * successKilled:SuccessKilled{seckillId=1000, userPhone=15011332233, state=-1, createTime=Tue Apr 18 11:02:21 CST 2017}
         seckill:Seckill{seckillId=1000, name='1000元秒杀iphone7', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Wed Apr 19 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
         */
    }

}