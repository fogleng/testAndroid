/**
 * 
 */
package com.cloud.util;

import java.util.ArrayList;
/**
 * @author : qing
 * @fileName : com.cloud.util.SimpleCache.java
 * date | author | version | 
 * 2014-7-22 | qing | 1.0 |
 *
 * @describe :
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED 2014
 */

/**
 * @author qing| 2014-7-22|下午9:04:04
 * @describe K/V String
 */
public interface SimpleCache {
	
	public String get(String key);
	
	/** 获取最新的缓存数据
	 * @param num
	 * @return
	 */
	public ArrayList<String> getLatest(int num) ;
	
	public String put(String key,String value);
	
	public String remove(String key);
	
	public void removeAll();

	public void close();
}
