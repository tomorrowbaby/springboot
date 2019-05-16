package com.example.demo.quartz;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 描述：定时器类
 * @Author wangyu
 * @date 2019/5/15
 */

@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class) ;


    @Scheduled(cron = "*/5 * * * * *")
    public void testQuartz(){
        logger.info("Quartz运行");
    }
}
