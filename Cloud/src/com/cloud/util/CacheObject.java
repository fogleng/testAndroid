/**
 * 
 */
package com.cloud.util;

/**
 * @author : qing
 * @fileName : com.cloud.util.CacheObject.java
 * date | author | version | 
 * 2014-7-22 | qing | 1.0 |
 *
 * @describe :
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED 2014
 */

/**
 * @author qing| 2014-7-22|下午8:55:39
 * @describe
 */
public class CacheObject implements Comparable<CacheObject> {

	public String key;

	public String value;

	/**
	 * 缓存 时间控制
	 */
	public long cacheTime;

	public CacheObject(String key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.cacheTime = System.currentTimeMillis();
	}

	@Override
	public int compareTo(CacheObject co) {
		if (cacheTime > co.cacheTime) {
			return 1;
		} else if (cacheTime < co.cacheTime) {
			return -1;
		} else
			return 0;
	}
}
