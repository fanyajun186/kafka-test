package com.kafka.simple;



import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import kafka.producer.KeyedMessage;

public class SimpleKafkaProducer {

	 private static final Logger logger = Logger.getLogger(SimpleKafkaProducer.class);
	    /**
	     * 
	     */
	    private void execMsgSend() {
	        Properties props = new Properties();
	        props.put("bootstrap.servers", "localhost:9092");
	        props.put("client.id", "root");
	        props.put("socket.timeout.ms", "60000");
	        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");    
	        
	         
	        logger.info("set config info(" + props + ") ok.");
	        KafkaProducer<String, String> producer=new KafkaProducer<>(props);
	        
	         
	        String topic = "test";
	        for (int i = 41; i <= 50; i++) {
	            String value = "value_" + i;
	            ProducerRecord<String, String> msg = new ProducerRecord<String, String>(topic,value);
	            producer.send(msg);
	            System.out.println(i);
	        }
	        logger.info("send message over.");
	             
	        producer.close();
	    }
	     
	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        SimpleKafkaProducer simpleProducer = new SimpleKafkaProducer();
	        simpleProducer.execMsgSend();
	    }
	
}
