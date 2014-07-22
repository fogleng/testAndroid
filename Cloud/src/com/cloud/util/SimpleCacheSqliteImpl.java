/**
 * 
 */
package com.cloud.util;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author : qing
 * @fileName : com.cloud.util.SimpleCacheSqliteImpl.java
 * date | author | version | 
 * 2014-7-22 | qing | 1.0 |
 *
 * @describe :
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED 2014
 */

/**
 * @author qing| 2014-7-22|ÏÂÎç9:11:29
 * @describe
 */
public class SimpleCacheSqliteImpl implements SimpleCache {

	@Override
	public String get(String key) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.util.SimpleCache#getLatest(int)
	 */
	@Override
	public ArrayList<String> getLatest(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.util.SimpleCache#put(java.lang.String, java.lang.String)
	 */
	@Override
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.util.SimpleCache#remove(java.lang.String)
	 */
	@Override
	public String remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.util.SimpleCache#removeAll()
	 */
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.util.SimpleCache#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	public class SQLiteHelp extends SQLiteOpenHelper {

		public String LOCK = "dblock";

		private String mTableName;

		public SQLiteHelp(Context context, String name, CursorFactory factory,
				int version, String tbName) {
			super(context, name, factory, version);
			mTableName = tbName;
			try {
				SQLiteDatabase sqLiteDatabase = getWritableDatabase();
				onCreate(sqLiteDatabase);
				sqLiteDatabase.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		public void insertCOByKey(String key, String value) {
			synchronized (LOCK) {
				SQLiteDatabase db = null;
				try {
					db = getWritableDatabase();
					ContentValues contentValues = new ContentValues();
					contentValues.put("key", key);
					contentValues.put("value", value);
					contentValues.put("cacheTime", System.currentTimeMillis());
					db.insert(mTableName, null, contentValues);
				} finally {
					if (db != null)
						db.close();
				}
			}

		}

		public void updateCOByKey(String key, String value) {
			synchronized (LOCK) {
				SQLiteDatabase db = null;
				try {
					db = getWritableDatabase();
					ContentValues contentValues = new ContentValues();
					contentValues.put("key", key);
					contentValues.put("value", value);
					contentValues.put("cacheTime", System.currentTimeMillis());
					db.update(mTableName, contentValues, "key=?",
							new String[] { key });
				} finally {
					if (db != null)
						db.close();
				}
			}

		}

		public void deleteCOByKey(String key) {
			synchronized (LOCK) {
				SQLiteDatabase db = null;
				try {
					db = getWritableDatabase();
					ContentValues contentValues = new ContentValues();

					db.delete(mTableName, "key=?", new String[] { key });
				} finally {
					if (db != null)
						db.close();
				}
			}
		}

		public void deleteAllKey() {
			synchronized (LOCK) {
				SQLiteDatabase db = null;
				try {
					db = getWritableDatabase();
					ContentValues contentValues = new ContentValues();

					db.delete(mTableName, null, null);
				} finally {
					if (db != null)
						db.close();
				}
			}
		}

		public CacheObject getCOByKey(String key) {
			SQLiteDatabase db = null;
			Cursor c = null;
			synchronized (LOCK) {
				try {
					db = getReadableDatabase();
					c = db.query(mTableName, new String[] { "value",
							"cacheTime" }, "key=?", new String[] { key }, null,
							null, null);
					if (c.moveToFirst()) {
						String value = c.getString(0);
						long cacheTime = c.getLong(1);
						CacheObject co = new CacheObject(key, value);
						co.cacheTime = cacheTime;
						return co;
					} else {
						return null;
					}

				} finally {
					if (c != null) {
						c.close();
					}
					if (db != null)
						db.close();
				}
			}
		}

		public ArrayList<CacheObject> getLastestCOS(int num) {
			SQLiteDatabase db = null;
			Cursor c = null;
			ArrayList<CacheObject> cos = new ArrayList<CacheObject>();
			synchronized (LOCK) {
				try {

					db = getReadableDatabase();
					c = db.rawQuery("select `key`,`value`,`cacheTime` from `"
							+ mTableName + "`order by cacheTime desc limit"
							+ num, null);
					if (c.moveToFirst()) {
						while (!c.moveToLast()) {
							String key = c.getString(0);
							String value = c.getString(1);
							long cacheTime = c.getLong(2);
							CacheObject co = new CacheObject(key, value);
							co.cacheTime = cacheTime;
							cos.add(co);
						}
						return cos;
					} else {
						return null;
					}

				} finally {
					if (c != null) {
						c.close();
					}
					if (db != null)
						db.close();
				}
			}
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("Create table if not exist+" + mTableName + "("
					+ "key varchar(128) primary key," + "value varchar(4096),"
					+ "cacheTime long)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}

	}

}
