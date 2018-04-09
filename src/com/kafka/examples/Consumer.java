/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kafka.examples;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class Consumer extends ShutdownableThread {
    private final KafkaConsumer<String, String> consumer;
    private final String topic;

    public Consumer(String topic) {
        super("KafkaConsumerExample", false);
        Properties props = new Properties();       
     
      /*  props.put("max.poll.records",500);
        props.put("fetch.max.bytes",52428800);
        props.put("fetch.min.bytes",1);*/
        
       props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
       props.put(ConsumerConfig.GROUP_ID_CONFIG, "eventConsumer");
       props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
       //设置自动提交偏移量(offset),由auto.commit.interval.ms控制提交频率
       props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
       //偏移量(offset)提交频率
       props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
       props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");        
       //如果采用latest，消费者只能得道其启动后，生产者生产的消息,默认是latest
       props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
       //auto.offset.reset "earliest"
       consumer = new KafkaConsumer<>(props);
       this.topic = topic;
    }

    @Override
    public void doWork() {
        try {
			consumer.subscribe(Collections.singletonList(this.topic));
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for (ConsumerRecord<String, String> record : records) {
			    System.out.println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
			}
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }
}
