package com.kafka.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/*import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerConnector;*/


import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.Decoder;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
public class SimpleKafkaConsumer {

	private static final Logger logger = Logger.getLogger(SimpleKafkaConsumer.class);
	
	 private void execMsgConsume() {
	        Properties props = new Properties();
	        /*props.put("zookeeper.connect", "nnode:2181,dnode1:2181,dnode2:2181");
	        props.put("group.id", "group-1");
	        props.put("serializer.class", "kafka.serializer.StringEncoder");*/
	        props.put("zookeeper.connect", "localhost:2181");
	        props.put("bootstrap.servers","localhost:9092");
	        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
	        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
	        props.put("group.id","eventConsumer");
	        props.put("session.timeout.ms", "30000");
	        props.put("zookeeper.connection.timeout.ms", "30000");
	       /* props.put("max.poll.records",500);
	        props.put("fetch.max.bytes",52428800);
	        props.put("fetch.min.bytes",1);*/
	        
	        ConsumerConfig config = new ConsumerConfig(props);
	        ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);
	         
	        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
	        topicCountMap.put("test", 1);
	        Decoder<String> keyDecoder = new StringDecoder(new VerifiableProperties());
	        Decoder<String> valueDecoder = new StringDecoder(new VerifiableProperties());
	        Map<String, List<KafkaStream<String, String>>> createMessageStreams = consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
	        for (Iterator<String> it = createMessageStreams.keySet().iterator(); it.hasNext(); ) {
	            String key = it.next();
	            logger.info("The key of the createMessageStreams is " + key);
	            List<KafkaStream<String, String>> values = createMessageStreams.get(key);
	            for (KafkaStream<String, String> value : values) {
	                 ConsumerIterator<String, String> consumerIt = value.iterator();
	                 while (consumerIt.hasNext()) {
	                     MessageAndMetadata<String, String> data = consumerIt.next();
	                     System.out.println(data.message());
	                     logger.info("The message got by consuer is " + data.message());
	                 }
	            }
	        }
	         
	    }
	     
	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        SimpleKafkaConsumer simpleConsumer = new SimpleKafkaConsumer();
	        simpleConsumer.execMsgConsume();
	    }
	
}
