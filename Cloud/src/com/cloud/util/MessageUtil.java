/**
 * 
 */
package com.cloud.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author : qing
 * @fileName : com.cloud.util.MessageUtil.java
 * date | author | version | 
 * 2014-7-21 | qing | 1.0 |
 *
 * @describe : 封装Toast 有单利模式
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED 2014
 */

/**
 * @author qing| 2014-7-21|上午11:45:05
 * @describe
 */
public class MessageUtil {

	public static Toast mToast;

	public static void showSingletonToast(Context context, String text) {
		try {
			if (mToast == null)
				mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
			mToast.setText(text);
			mToast.show();
		} catch (Exception e) {
		}
	}

	public static void showLongToast(Context context, String text) {
		try {
			Toast.makeText(context, text, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
		}
	}

	public static void showShortToast(Context context, String text) {
		try {
			Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
		}
	}

	public static void showLongToast(Context context, int res) {
		try {
			Toast.makeText(context, res, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
		}
	}

	public static void showShortToast(Context context, int res) {
		try {
			Toast.makeText(context, res, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
		}
	}
}
