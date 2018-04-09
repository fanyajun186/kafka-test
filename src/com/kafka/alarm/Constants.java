package com.kafka.alarm;

import java.util.regex.Pattern;

/**
 *
 * @author Arvin
 *
 */
public interface Constants {

	// ID
	public static final String ID = "id";

	// 索引类型
	public static final String INDEXTYPE = "index_type";
	
	// IP验证
	public static final Pattern IPPATTERN = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
}
