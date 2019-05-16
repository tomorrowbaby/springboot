package com.example.demo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * 描述：消费者
 * @author wangyu
 * @date 2019/5/16
 */
@Component
public class Consumer {
    @JmsListener(destination = "activemq.queue")

    public void receiveQueue(String text) {
        System.out.println("信息接受***  "+text+" ***成功");
    }
}
