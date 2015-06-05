package com.xunlei.sdk.test.cases.query;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.log.DebugLog;

/*
 * orderBy 排列查询结果
 */
public class OrderBy extends BaseCase {
	// 按ID升序
	public void testOrderByIDAcsend() {
		printDivideLine();
		// 调用接口
		query.orderBy("_id", 1);
		// 查询数据库验证结果
		Cursor cursor = downloadManager.query(query);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 1; i <= cursor.getCount(); i++) {
				long id = cursor.getInt(cursor.getColumnIndex("_id"));
				DebugLog.d("Test_Debug", "ID = " + String.valueOf(id));
				assertEquals("ID排序错误", (long) i, id);
				cursor.moveToNext();
			}
		}
	}

	// 按ID降序
	public void testOrderByIDDecsend() {
		printDivideLine();
		// 调用接口
		query.orderBy("_id", 2);
		// 查询数据库验证结果
		Cursor cursor = downloadManager.query(query);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = cursor.getCount(); i >= 1; i--) {
				int id = cursor.getInt(cursor.getColumnIndex("_id"));
				Log.d("Test_Debug", "ID = " + String.valueOf(id));
				assertEquals("ID排序错误", i, id);
				cursor.moveToNext();
			}
		}
	}

}
