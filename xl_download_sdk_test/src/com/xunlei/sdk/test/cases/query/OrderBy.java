package com.xunlei.sdk.test.cases.query;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.sdk.test.utils.BaseCase;

/*
 * orderBy 排列查询结果
 */
public class OrderBy extends BaseCase {
	// 按ID升序
	public void testOrderByIDAcsend() {
		printDivideLine();
		query.orderBy("_id", 1);
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		for (int i = 1; i <= cursor.getCount(); i++) {
			long id = cursor.getInt(cursor.getColumnIndex("_id"));
			Log.d("Test_Debug", String.valueOf(id));
			assertEquals((long) i, id);
			cursor.moveToNext();
		}
	}

	// 按ID降序
	public void testOrderByIDDecsend() {
		printDivideLine();
		query.orderBy("_id", 2);
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		for (int i = cursor.getCount(); i >= 1; i--) {
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			Log.d("Test_Debug", String.valueOf(id));
			assertEquals(i, id);
			cursor.moveToNext();
		}
	}

}
