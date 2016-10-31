package com.spring.integration.ftp;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

public class SendFileSpringFTP 
{
	
	public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("/applicationContext.xml");

        MessageChannel ftpChannel = ctx.getBean("ftpChannel", MessageChannel.class);

        File file = new File("‪C:\\Users\\think\\Desktop\\789.jpg");
        final Message<File> messageFile = MessageBuilder.withPayload(file).build();
        ftpChannel.send(messageFile);

        Thread.sleep(2000);
    }
}
