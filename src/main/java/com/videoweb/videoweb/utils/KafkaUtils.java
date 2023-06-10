package com.videoweb.videoweb.utils;

import com.videoweb.videoweb.model.GetUser;
import lombok.Data;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;

@Component
@Data
public class KafkaUtils {



    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    private ConsumerFactory<String, String> consumerFactory;
    private boolean checkOnline(String topic,String key){
      KafkaConsumer<String ,String>consumer=new KafkaConsumer<>(new Properties());
        TopicPartition partition = new TopicPartition(topic, Integer.parseInt(key));
        consumer.assign(Collections.singleton(partition));
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));


        consumer.close();
        if (records.count() > 0) { // 如果指定分区有数据
            System.out.println("Partition " + key + " has messages.");
            return true;
        } else { // 如果指定分区没有数据

            System.out.println("Partition " + key + " has no messages.");
            return false;
        }
    }
    public void send(String receiveId,String sendId,String value){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(receiveId,sendId,value);
        producer.send(record);
        producer.close();
    }


    public List<List<GetUser>> getAll(String receiveId) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "my-consumer-group");
        props.put("key.deserializer", StringDeserializer.class);
        props.put("value.deserializer", StringDeserializer.class);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singleton(receiveId));
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
        List<List<GetUser>> getList = new ArrayList<>();
        List<GetUser> getUserList = new ArrayList<>();
        String id = "-1";
        for (ConsumerRecord<String, String> record : records) {
            GetUser user = new GetUser();
            user.setUserId(record.key());
            user.setReceiveMessage(record.value());

            if (record.key().equals(id)) {
                getUserList.add(user);
            } else {
                if (!getUserList.isEmpty()) {
                    getList.add(getUserList);
                }
                getUserList = new ArrayList<>();
                id = record.key();
                getUserList.add(user);
            }

            System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
        if (!getUserList.isEmpty()) {
            getList.add(getUserList);
        }
        consumer.commitSync();
        consumer.close();
        return getList;
    }


    public void delete(String topic, String key) {
        KafkaConsumer<String ,String>consumer=new KafkaConsumer<>(new Properties());
        TopicPartition partition = new TopicPartition(topic, Integer.parseInt(key));
        consumer.assign(Collections.singleton(partition));
        consumer.seekToEnd(Collections.singleton(partition));
        consumer.close();
    }
}
