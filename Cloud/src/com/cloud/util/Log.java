package com.cloud.util;

/**
 * @author qing| 2014-7-21|ÉÏÎç11:36:18
 * @describe ·â×°Log
 */
public class Log {

	static final boolean SHOWLOG = true;

	public static void i(String tag, String msg) {
		if (SHOWLOG)
			android.util.Log.i(tag, msg);
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (SHOWLOG)
			android.util.Log.i(tag, msg, tr);
	}

	public static void v(String tag, String msg) {
		if (SHOWLOG)
			android.util.Log.v(tag, msg);
	}

	public static void v(String tag, String msg, Throwable tr) {
		if (SHOWLOG)
			android.util.Log.v(tag, msg, tr);
	}

	public static void d(String tag, String msg) {
		if (SHOWLOG)
			android.util.Log.d(tag, msg);
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (SHOWLOG)
			android.util.Log.d(tag, msg, tr);
	}

	public static void e(String tag, String msg) {
		if (SHOWLOG)
			android.util.Log.e(tag, msg);
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (SHOWLOG)
			android.util.Log.e(tag, msg, tr);
	}

	public static void w(String tag, String msg) {
		if (SHOWLOG)
			android.util.Log.w(tag, msg);
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (SHOWLOG)
			android.util.Log.w(tag, msg, tr);
	}

}
