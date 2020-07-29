package com.starbeat.microservice.ftpStarbeatArchive.kafka.producer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private Environment env;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final CountDownLatch latch = new CountDownLatch(3);

    public void sendMessage(String message) throws InterruptedException {
        final String TOPIC = "CANAL-A";
        logger.info(String.format("#### -> PRODUZINDO TOPICO -> %s", TOPIC));
        logger.info(String.format("#### -> PRODUZINDO MENSAGEM -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
        latch.await(60, TimeUnit.SECONDS);
        logger.info("TODOS RECEBIDOS");
    }

    @KafkaListener(topics="CANAL-A",topicPartitions = {
    @TopicPartition(topic = "CANAL-A", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")) })
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("TODOS RECEBIDOS NO CANAL A");
        logger.info(cr.toString());
        latch.countDown();
    }

}