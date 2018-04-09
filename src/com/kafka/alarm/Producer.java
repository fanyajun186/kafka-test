package com.kafka.alarm;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kafka.examples.KafkaProperties;

import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


/**
 * @author xuezhi_xu@hansight.com
 * @date 16/10/31 下午6:01
 */
public class Producer  {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private static Properties props;

    private KafkaProducer<String, String> producer;

    private String topic;

    static {
        props = new Properties(); 
        
        props.put("bootstrap.servers", "localhost:9092");
        props.put("client.id", "root");
        props.put("socket.timeout.ms", "60000");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");        
        
    }


    public Producer(String topic) {
        producer = new KafkaProducer<String, String>(props);
        this.topic = topic;
    }

    /**
     * 根据主题名称,发送对象到Kafka
     * @return
     */
    public<T> boolean send(T obj ){
        ProducerRecord<String,String> record = new ProducerRecord<String, String>(topic,"2",ObjToJson(obj) );
        producer.send(record);
        return true;

    }

    /**
     * 根据主题名称,发送列表到Kafka
     * @return
     * @throws Exception 
     * @throws InterruptedException 
     */
    public <T> boolean  sendList(List<T> objs ) throws  Exception{
        boolean flag = true;

        if(null != objs && objs.size() >0){
        	int i=160;
            for(T obj : objs){
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,i+"",ObjToJson(obj));
                producer.send(record).get();
                i++;
            }
        }
        return flag;

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
            logger.error("生产数据异常 topicName : " + topic +" ; error message " + e.getMessage() );
        }
        return objJson;
    }

    /**
     * 序列化对象为字节数组,后期封装其他支持类
     * @return
     */
    private <T>  byte[] serializeObj(T obj ) {

        return BeanUtil.object2Bytes(obj);

    }

    /**
     * 关闭生产者
     */
    public void close() {
        producer.close();
    }
}

