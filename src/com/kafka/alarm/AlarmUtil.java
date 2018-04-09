package com.kafka.alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class AlarmUtil {

	
	public  static  List<Alarm> getAlarmList(int start,int limit){
		
		long statrTime = System.currentTimeMillis();
		List<String> list = new ArrayList<String>(){{
			add("/hostsec");
			add("/malware");
			add("/networksec");
			add("/accessctrl");
			add("/datasec");
			add("/other");
		}};
		List<Alarm> alist = new ArrayList<Alarm>();
		for(int i = start ; i < start+limit ; i++ ){
			
			Alarm alarmOriginal=new Alarm();
			long startTime = statrTime - getRandom(10000,100);
			long endTime = statrTime + getRandom(10000,100);
			//String alarmKey = getRandomString(10);
			
			alarmOriginal.setId(10000l+i);
			alarmOriginal.setAlarmLevel(getRandom012(3));
			alarmOriginal.setIndexType("alarm_original");
			alarmOriginal.setAlarmType(list.get(getRandom012(5)));
			alarmOriginal.setAlarmSrc("安全");
			alarmOriginal.setAlarmName("原始告警告警名称"+10000l+(i));
			alarmOriginal.setStartTime(startTime);
			alarmOriginal.setEndTime(endTime);
			alarmOriginal.setAlarmStage(getRandom(6,1));
			alarmOriginal.setAlarmContent(getRandomString(100));
			String srcAddress=getRandomIp();
			alarmOriginal.setSrcAddress(srcAddress);
			alarmOriginal.setSrcPort(getRandom(20,2));;
			String dstAddress=getRandomIp();
			alarmOriginal.setDstAddress(dstAddress);
			alarmOriginal.setDstPort(getRandom(20,2));
			alarmOriginal.setOccurAddress(dstAddress);
			alarmOriginal.setRuleId("1");
			//alarmOriginal.setAlarmKey("1"+"_"+srcAddress+"_"+dstAddress);
			alarmOriginal.setAlarmKey("1_139.201.165.163_171.14.166.127");
			alarmOriginal.setOccurPort(getRandom(20,2));	
			alist.add(alarmOriginal);
		}
		return alist;
		
	}
	/**
	 * 获得随机数
	 * @param i
	 * @param j
	 * @return
	 */
	private static int getRandom(int max, int min) {
		
        Random random = new Random();
        int s = random.nextInt(max) + min;
        return s ;
	}
	/**
	 * 获得随机数
	 * @param i
	 * @param j
	 * @return
	 */
	private static int getRandom012(int max) {
		
        Random random = new Random();
        int s = random.nextInt(max);
        return s ;
	}
	/**
	 * 生成随机ip
	 * @return
	 */
    public static String getRandomIp(){
     
	    //ip范围
	    int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
	                     {1038614528,1039007743},//61.232.0.0-61.237.255.255
	                     {1783627776,1784676351},//106.80.0.0-106.95.255.255
	                     {2035023872,2035154943},//121.76.0.0-121.77.255.255
	                     {2078801920,2079064063},//123.232.0.0-123.235.255.255
	                     {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
	                     {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
	                     {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
	                     {-770113536,-768606209},//210.25.0.0-210.47.255.255
	                     {-569376768,-564133889}, //222.16.0.0-222.95.255.255
	    };
         
        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }
 
    /**
     * 数字转ip
     * @param ip
     * @return
     */
    public static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";
         
        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]); 
         
        return x; 
     }
    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
    }  
      
    public static String getRandomString2(int length){  
        Random random = new Random();  
          
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0; i < length; ++i){  
            int number = random.nextInt(3);  
            long result = 0;  
              
            switch(number){  
            case 0:  
                result = Math.round(Math.random() * 25 + 65);  
                sb.append(String.valueOf((char)result));  
                break;  
            case 1:  
                result = Math.round(Math.random() * 25 + 97);  
                sb.append(String.valueOf((char)result));  
                break;  
            case 2:  
                sb.append(String.valueOf(new Random().nextInt(10)));  
                break;  
            }  
        }  
        return sb.toString();     
    }  
}
