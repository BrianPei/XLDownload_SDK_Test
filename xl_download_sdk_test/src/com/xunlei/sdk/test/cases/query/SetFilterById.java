package com.xunlei.sdk.test.cases.query;

import com.xunlei.sdk.test.utils.BaseCase;

import android.database.Cursor;
import android.util.Log;

/*
 * setFilterById 按ID筛选下载任务
 */
public class SetFilterById extends BaseCase {

	// ID为1、2、3
	public void testSetFilterById() {
		printDivideLine();
		query.setFilterById(1L, 2L, 3L);
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
}
