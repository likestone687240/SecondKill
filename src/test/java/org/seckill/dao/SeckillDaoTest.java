package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Winter on 2017/4/18.
 */

/**
 * 配置spring 和 JUnit整合, JUnit启动时, 加载springIOC容器
 * spring-test, JUnit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * 1000元秒杀iphone7
         Seckill{seckillId=1000, name='1000元秒杀iphone7', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Tue Apr 18 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
         */
    }

    @Test
    public void queryAll() throws Exception {
        //java没有保存形参的记录, queryAll(int offset, int limit) -> queryAll(arg0, arg1)
        List<Seckill> list = seckillDao.queryAll(0, 100);
        for (Seckill seckill : list) {
            System.out.println(seckill);
            /**
             * Seckill{seckillId=1000, name='1000元秒杀iphone7', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Tue Apr 18 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
             Seckill{seckillId=1001, name='500元秒杀ipad2', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Tue Apr 18 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
             Seckill{seckillId=1002, name='300元秒杀小米4', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Tue Apr 18 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
             Seckill{seckillId=1003, name='200元秒杀红米note', startTime=Mon Apr 17 00:00:00 CST 2017, endTime=Tue Apr 18 00:00:00 CST 2017, createTime=Mon Apr 17 14:27:28 CST 2017}
             */
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000, killTime);
        System.out.println("updateCount:" + updateCount);
    }


}