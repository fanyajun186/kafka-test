package com.kafka.alarm;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import org.elasticsearch.common.geo.GeoPoint;


/**
 * @ClassName Alarm
 * @Description 原始告警实体
 * @author yajun_fan
 * @date 2016年8月2日 下午4:00:33
 */
public class Alarm extends BaseObject{

	private static final long serialVersionUID = 1L;
	
	private Set<Long> eventIds = new HashSet<>();
	
	public String getRuleId() {
		return getString(AlarmConstants.RULEID);
	}

	public void setRuleId(String rule_id) {
		putValue(AlarmConstants.RULEID, rule_id);
	}

	public Integer getAlarmLevel() {
		return getInteger(AlarmConstants.ALARMLEVEL);
	}

	public void setAlarmLevel(Integer alarm_level) {
		putValue(AlarmConstants.ALARMLEVEL, alarm_level);
	}
	
	public Integer getAlarmStatus() {
		return getInteger(AlarmConstants.ALARMSTATUS);
	}

	public void setAlarmStatus(Integer alarm_status) {
		putValue(AlarmConstants.ALARMSTATUS, alarm_status);
	}

	public String getAlarmType() {
		return getString(AlarmConstants.ALARMTYPE);
	}

	public void setAlarmType(String alarm_type) {
		putValue(AlarmConstants.ALARMTYPE, alarm_type);
	}

	public String getAlarmSrc() {
		return getString(AlarmConstants.ALARMSRC);
	}

	public void setAlarmSrc(String alarm_src) {
		putValue(AlarmConstants.ALARMSRC, alarm_src);
	}

	public String getAlarmName() {
		return getString(AlarmConstants.ALARMNAME);
	}

	public void setAlarmName(String alarm_name) {
		putValue(AlarmConstants.ALARMNAME, alarm_name);
	}

	public Long getStartTime() {
		return getLong(AlarmConstants.STARTTIME);
	}

	public void setStartTime(Long start_time) {
		putValue(AlarmConstants.STARTTIME, start_time);
	}

	public Long getEndTime() {
		return getLong(AlarmConstants.ENDTIME);
	}

	public void setEndTime(Long end_time) {
		putValue(AlarmConstants.ENDTIME, end_time);
	}

	public String getAlarmKey() {
		return getString(AlarmConstants.ALARMKEY);
	}

	public void setAlarmKey(String alarm_key) {
		putValue(AlarmConstants.ALARMKEY, alarm_key);
	}

	public Integer getAlarmStage() {
		return getInteger(AlarmConstants.ALARMSTAGE);
	}

	public void setAlarmStage(Integer alarm_stage) {
		putValue(AlarmConstants.ALARMSTAGE, alarm_stage);
	}

	public String getAlarmContent() {
		return getString(AlarmConstants.ALARMCONTENT);
	}

	public void setAlarmContent(String alarm_content) {
		putValue(AlarmConstants.ALARMCONTENT, alarm_content);
	}

	public String getAttackLibId() {
		return getString(AlarmConstants.ATTACKLIBID);
	}

	public void setAttackLibId(String attack_lib_id) {
		putValue(AlarmConstants.ATTACKLIBID, attack_lib_id);
	}

	public String getSrcAddress() {
		return getString(AlarmConstants.SRCADDRESS);
	}

	public void setSrcAddress(String src_address) {
		putValue(AlarmConstants.SRCADDRESS, src_address);
	}

	public Integer getSrcPort() {
		return getInteger(AlarmConstants.SRCPORT);
	}

	public void setSrcPort(Integer src_port) {
		putValue(AlarmConstants.SRCPORT, src_port);
	}

	public GeoPoint getSrcGeo() {
		return getGeoPoint(AlarmConstants.SRCGEO);
	}

	public void setSrcGeo(GeoPoint src_geo) {
		putValue(AlarmConstants.SRCGEO, src_geo);
	}

	public String getSrcCountry() {
		return getString(AlarmConstants.SRCCOUNTRY);
	}

	public void setSrcCountry(String src_country) {
		putValue(AlarmConstants.SRCCOUNTRY, src_country);
	}

	public String getSrcProvince() {
		return getString(AlarmConstants.SRCPROVINCE);
	}

	public void setSrcProvince(String src_province) {
		putValue(AlarmConstants.SRCPROVINCE, src_province);
	}

	public String getSrcCity() {
		return getString(AlarmConstants.SRCCITY);
	}

	public void setSrcCity(String src_city) {
		putValue(AlarmConstants.SRCCITY, src_city);
	}

	public String getDstAddress() {
		return getString(AlarmConstants.DSTADDRESS);
	}

	public void setDstAddress(String dst_address) {
		putValue(AlarmConstants.DSTADDRESS, dst_address);
	}

	public Integer getDstPort() {
		return getInteger(AlarmConstants.DSTPORT);
	}

	public void setDstPort(Integer dst_port) {
		putValue(AlarmConstants.DSTPORT, dst_port);
	}

	public GeoPoint getDstGeo() {
		return getGeoPoint(AlarmConstants.DSTGEO);
	}

	public void setDstGeo(GeoPoint dst_geo) {
		putValue(AlarmConstants.DSTGEO, dst_geo);
	}

	public String getDstCountry() {
		return getString(AlarmConstants.DSTCOUNTRY);
	}

	public void setDstCountry(String dst_country) {
		putValue(AlarmConstants.DSTCOUNTRY, dst_country);
	}

	public String getDstProvince() {
		return getString(AlarmConstants.DSTPROVINCE);
	}

	public void setDstProvince(String dst_province) {
		putValue(AlarmConstants.DSTPROVINCE, dst_province);
	}

	public String getDstCity() {
		return getString(AlarmConstants.DSTCITY);
	}

	public void setDstCity(String dst_city) {
		putValue(AlarmConstants.DSTCITY, dst_city);
	}

	public String getOccurAddress() {
		return getString(AlarmConstants.OCCURADDRESS);
	}

	public void setOccurAddress(String occurAddress) {
		putValue(AlarmConstants.OCCURADDRESS, occurAddress);
	}

	public Integer getOccurPort() {
		return getInteger(AlarmConstants.OCCURPORT);
	}

	public void setOccurPort(Integer occur_port) {
		putValue(AlarmConstants.OCCURPORT, occur_port);
	}

	public GeoPoint getOccurGeo() {
		return getGeoPoint(AlarmConstants.OCCURGEO);
	}

	public void setOccurGeo(GeoPoint occur_geo) {
		putValue(AlarmConstants.OCCURGEO, occur_geo);
	}

	public String getOccurCountry() {
		return getString(AlarmConstants.OCCURCOUNTRY);
	}

	public void setOccurCountry(String occur_country) {
		putValue(AlarmConstants.OCCURCOUNTRY, occur_country);
	}

	public String getOccurProvince() {
		return getString(AlarmConstants.OCCURPROVINCE);
	}

	public void setOccurProvince(String occur_province) {
		putValue(AlarmConstants.OCCURPROVINCE, occur_province);
	}

	public String getOccurCity() {
		return getString(AlarmConstants.OCCURCITY);
	}

	public void setOccurCity(String occur_city) {
		putValue(AlarmConstants.OCCURCITY, occur_city);
	}
	
	public Set<Long> getEventIds() {
		return eventIds;
	}

	public void addEventId(Long event_id) {
		eventIds.add(event_id);
	}

	public void setEventIds(Set<Long> event_ids) {
		eventIds = event_ids;
	}
	
	// 工具方法 /////////////////////////////////////////////////////
	
	@Override
	public void putValue(String field, Object value) {
		if(AlarmConstants.INTEGERSET.contains(field)) {
			if(value != null)
				valueMap.put(field, Integer.parseInt(value.toString()));
		} else if(AlarmConstants.LONGSET.contains(field)) {
			if(value != null)
				valueMap.put(field, Long.parseLong(value.toString()));
		} else if(AlarmConstants.IPSET.contains(field)) {
			if(value != null) {
				Matcher matcher = Constants.IPPATTERN.matcher((String)value);
				if(matcher.matches())
					valueMap.put(field, value);
			}
		} else if(AlarmConstants.GEOPOINTSET.contains(field)) {
			valueMap.put(field, value);
		} else {
			valueMap.put(field, value);
		}
	}
}
