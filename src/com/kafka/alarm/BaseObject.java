package com.kafka.alarm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.geo.GeoPoint;

/**
 * 平台处理数据的基类
 * @author Arvin
 *
 */
public abstract class BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Map<String, Object> valueMap = new HashMap<>();
	
	public Long getId() {
		return getLong(Constants.ID);
	}

	public void setId(Long id) {
		putValue(Constants.ID, id);
	}

	public String getIndexType() {
		return getString(Constants.INDEXTYPE);
	}

	public void setIndexType(String indexType) {
		putValue(Constants.INDEXTYPE, indexType);
	}
	
	// 工具方法 /////////////////////////////////////////////////////
	
	protected void putValue(String field, Object value) {
		
	}
	
	public Map<String, Object> getValue() {
		return valueMap;
	}
	
	protected Object getValue(String field) {
		return valueMap.get(field);
	}
	
	protected Long getLong(String field) {
		Object obj = getValue(field);
		if(obj == null)
			return null;
		return (Long)obj;
	}
	
	protected Integer getInteger(String field) {
		Object obj = getValue(field);
		if(obj == null)
			return null;
		return (Integer)obj;
	}
	
	protected Double getDouble(String field) {
		Object obj = getValue(field);
		if(obj == null)
			return null;
		return (Double)obj;
	}
	
	protected GeoPoint getGeoPoint(String field) {
		Object obj = getValue(field);
		if(obj == null)
			return null;
		return (GeoPoint)obj;
	}
	
	public String getString(String field) {
		Object obj = getValue(field);
		if(obj == null)
			return null;
		return (String)obj;
	}
}
