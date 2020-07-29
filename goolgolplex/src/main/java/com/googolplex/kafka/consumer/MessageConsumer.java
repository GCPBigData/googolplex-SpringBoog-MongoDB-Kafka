package com.googolplex.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private Environment env;  
    
   /* @KafkaListener(topics = "#{environment.CONSUMER_TOPIC}", groupId = "group_id")
    public void consume(String message) throws IOException {
    	logger.info(String.format("#### -> Consumer topic -> %s", env.getProperty("CONSUMER_TOPIC")));
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }*/

    
    
}