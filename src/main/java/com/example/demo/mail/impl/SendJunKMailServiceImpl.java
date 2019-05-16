package com.example.demo.mail.impl;

import com.example.demo.mail.SendJunkMailService;
import com.example.demo.po.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * 描述：邮件发送服务
 * @author wangyu
 * @date 2019/5/15
 */
@Service
public class SendJunKMailServiceImpl implements SendJunkMailService {

    @Autowired
    JavaMailSender mailSender ;

    @Value("${spring.mail.username}")
    private  String from ;


    public static final Logger logger = LogManager.getLogger(SendJunKMailServiceImpl.class) ;



    User user = new User() ;

    @Override
    public boolean sendJunKMail() {
        try {
            for (int i = 0; i < 15; i++) {
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                //邮件发送方
                message.setFrom(from);
                //邮件主题
                message.setSubject("儿子！腰疼吗");
                //邮件接收方
                message.setTo("1459602906@qq.com");
                //邮件内容
                message.setText("儿子！腰疼吗？");
                //发送邮件
                this.mailSender.send(mimeMessage);

                System.out.println("-----发送完成-----");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
