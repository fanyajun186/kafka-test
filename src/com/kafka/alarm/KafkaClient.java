package com.kafka.alarm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuezhi_xu@hansight.com
 * @date 16/10/31 下午5:50
 */
public class KafkaClient {

    public static void main(String[] args) throws Exception {
        /*Producer producer = new Producer("alarm");
        List<Alarm> list=AlarmUtil.getAlarmList(7502,1);
        
        boolean flag=producer.sendList(list);
        System.out.println(flag);*/
        Consumer consumer = new Consumer("alarm");
        consumer.start();
    }
    
}
