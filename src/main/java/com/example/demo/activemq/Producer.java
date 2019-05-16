package com.example.demo.activemq;

import javax.jms.Destination;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：生产者
 * @author wangyu
 * @date 2019/5/15
 */

@Service
public class Producer {
    @Resource
    private JmsTemplate jmsTemplate ;

    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination,message);
    }
}
