package com.kafka.syl;

import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.javaapi.producer.Producer;

public class ProducerDemo {

	public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        //zk
        props.put("zk.connect", "localhost:2181");
        //kafka broker
        props.put("metadata.broker.list","localhost:9092");

        //serialize
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("zk.connectiontimeout.ms", "15000");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);

        // read socket
        for (int i = 1; i <= 10; i++) {
            //Thread.sleep(50);
            producer.send(new KeyedMessage<String, String>("test","message: " + i ));
            System.out.println("message"+i);
        }

    }
	
}
