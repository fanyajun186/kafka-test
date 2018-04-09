package com.kafka.alarm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author Arvin
 *
 */
public interface AlarmConstants extends Constants {
	
	/**
	 * CEP规则ID
	 */
	public static final String RULEID = "rule_id";
	
	/**
	 * 告警级别
	 */
	public static final String ALARMLEVEL = "alarm_level";
	
	/**
	 * 告警类型
	 */
	public static final String ALARMTYPE = "alarm_type";
	
	/**
	 * 告警状态
	 */
	public static final String ALARMSTATUS = "alarm_status";
	
	/**
	 * 告警来源
	 */
	public static final String ALARMSRC = "alarm_src";
	
	/**
	 * 告警名称
	 */
	public static final String ALARMNAME = "alarm_name";
	
	/**
	 * 告警开始时间
	 */
	public static final String STARTTIME = "start_time";
	
	/**
	 * 告警结束时间
	 */
	public static final String ENDTIME = "end_time";
	
	/**
	 * 告警阶段
	 */
	public static final String ALARMSTAGE = "alarm_stage";
	
	/**
	 * 告警内容
	 */
	public static final String ALARMCONTENT = "alarm_content";
	
	/**
	 * 告警源地址
	 */
	public static final String SRCADDRESS = "src_address";
	
	/**
	 * 告警源端口
	 */
	public static final String SRCPORT = "src_port";
	
	/**
	 * 告警源GEO
	 */
	public static final String SRCGEO = "src_geo";
	
	/**
	 * 告警源国家
	 */
	public static final String SRCCOUNTRY = "src_country";
	
	/**
	 * 告警源省份
	 */
	public static final String SRCPROVINCE = "src_province";
	
	/**
	 * 告警源城市
	 */
	public static final String SRCCITY = "src_city";
	
	/**
	 * 告警目的地址
	 */
	public static final String DSTADDRESS = "dst_address";
	
	/**
	 * 告警目的端口
	 */
	public static final String DSTPORT = "dst_port";
	
	/**
	 * 告警目的GEO
	 */
	public static final String DSTGEO = "dst_geo";
	
	/**
	 * 告警目的国家
	 */
	public static final String DSTCOUNTRY = "dst_country";
	
	/**
	 * 告警目的省份
	 */
	public static final String DSTPROVINCE = "dst_province";
	
	/**
	 * 告警目的城市
	 */
	public static final String DSTCITY = "dst_city";
	
	/**
	 * 告警发生地址
	 */
	public static final String OCCURADDRESS = "occur_address";
	
	/**
	 * 告警发生端口
	 */
	public static final String OCCURPORT = "occur_port";
	
	/**
	 * 告警发生GEO
	 */
	public static final String OCCURGEO = "occur_geo";
	
	/**
	 * 告警发生国家
	 */
	public static final String OCCURCOUNTRY = "occur_country";
	
	/**
	 * 告警发生省份
	 */
	public static final String OCCURPROVINCE = "occur_province";
	
	/**
	 * 告警发生城市
	 */
	public static final String OCCURCITY = "occur_city";
	
	/**
	 * 告警KEY
	 */
	public static final String ALARMKEY = "alarm_key";
	
	/**
	 * 攻击库ID
	 */
	public static final String ATTACKLIBID = "attack_lib_id";
	
	public static final Set<String> IPSET = new HashSet<>(Arrays.asList(SRCADDRESS, DSTADDRESS, OCCURADDRESS));

	public static final Set<String> LONGSET = new HashSet<>(Arrays.asList(ID, STARTTIME, ENDTIME));
	
	public static final Set<String> INTEGERSET = new HashSet<>(Arrays.asList(ALARMLEVEL, ALARMSTATUS, ALARMSTAGE, SRCPORT, DSTPORT, OCCURPORT));
	
	public static final Set<String> GEOPOINTSET = new HashSet<>(Arrays.asList(SRCGEO, DSTGEO, OCCURGEO));
}
