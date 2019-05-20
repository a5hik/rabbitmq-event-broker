package com.rabbitmq.rabbitmqeventbrokering;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqEventBrokeringApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqEventBrokeringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleMessage message = new SimpleMessage();
        message.setName("Simple message");
        message.setDescription("Simple Description");
        rabbitTemplate.convertAndSend("MyTopicExchange", "topic", message);
    }
}
