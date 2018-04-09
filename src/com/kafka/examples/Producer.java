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

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.kafka.alarm.JsonUtil;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread {
    private final KafkaProducer<String, String> producer;
    private final String topic;
    private final Boolean isAsync;

    public Producer(String topic, Boolean isAsync) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");//"172.16.219.106:9092"
        props.put("client.id", "root");
        props.put("socket.timeout.ms", "60000");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");        
        
        producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    public void run() {
        int messageNo = 1;
        if (true) {
            try {
				String messageStr = "Message_" + messageNo;
				long startTime = System.currentTimeMillis();
				if (isAsync) {						
				    producer.send(new ProducerRecord<>(topic,
				        messageNo+"",
				        messageStr), new DemoCallBack(startTime, messageNo, messageStr));					
				} else { // Send synchronously
				    try {
				    	for (int i = 401; i <= 500;i++) {
				    		String value = "value_" + i;				    		
					        producer.send(new ProducerRecord<>(topic,i+"",value));
				        System.out.println("Sent message: (" + i + ", " + value + ")");
				    	}
				    } catch (Exception e) {
				        e.printStackTrace();
				    }
				}
				++messageNo;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 将对象转换为json字符串
     * @param obj
     * @param <T>
     * @return
     */
    private <T> String  ObjToJson(T obj) {
        String objJson = "";
        try{
            objJson = JsonUtil.obj2Json(obj);
        }catch (Exception e){
            System.out.println("生产数据异常 topicName : " + topic +" ; error message " + e.getMessage() );
        }
        return objJson;
    }

    
}



class DemoCallBack implements Callback {

    private final long startTime;
    private final int key;
    private final String message;

    public DemoCallBack(long startTime, int key, String message) {
        this.startTime = startTime;
        this.key = key;
        this.message = message;
    }

    /**
     * A callback method the user can implement to provide asynchronous handling of request completion. This method will
     * be called when the record sent to the server has been acknowledged. Exactly one of the arguments will be
     * non-null.
     *
     * @param metadata  The metadata for the record that was sent (i.e. the partition and offset). Null if an error
     *                  occurred.
     * @param exception The exception thrown during processing of this record. Null if no error occurred.
     */
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (metadata != null) {
            System.out.println(
                "message(" + key + ", " + message + ") sent to my self partition(" + metadata.partition() +
                    "), " +
                    "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
        } else {
            exception.printStackTrace();
        }
    }
}
