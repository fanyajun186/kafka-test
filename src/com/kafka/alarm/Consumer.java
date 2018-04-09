package com.kafka.alarm;


import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;

/**
 * @author xuezhi_xu@hansight.com
 * @date 16/11/1 下午2:15
 */
public class Consumer extends ShutdownableThread{

    private KafkaConsumer<String, byte[]> consumer;

    private String topic;

    public Consumer(String topic) {
        super("eventConsumer", false);

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.16.219.184:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "eventConsumer");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        consumer = new KafkaConsumer<>(props);
        this.topic = topic;
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        ConsumerRecords<String, byte[]> records = consumer.poll(1000);
        for (ConsumerRecord<String, byte[]> record : records) {
            byte[] eventByte = record.value();
            if(eventByte.length > 0){
                Event event = (Event) BeanUtil.ByteToObject(eventByte);
                System.out.print(event.getId());
            }
        }
    }


}
