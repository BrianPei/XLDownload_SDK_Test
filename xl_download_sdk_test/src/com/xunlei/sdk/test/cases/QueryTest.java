package com.xunlei.sdk.test.cases;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

public class QueryTest extends BaseCase {
	/*
	 * orderBy 排列查询结果
	 */
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

	/*
	 * setFilterByStatus 按状态筛选下载任务
	 */
	// 下载成功(status=200)
	public void testSetFilterByStatus() {
		printDivideLine();
		query.setFilterByStatus(XunLeiDownloadManager.STATUS_SUCCESSFUL);
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		for (int i = 0; i < cursor.getCount(); i++) {
			int status = cursor
					.getInt(cursor.getColumnIndex("status_original"));
			Log.d("Test_Debug", String.valueOf(status));
			assertEquals(200, status);
			cursor.moveToNext();
		}
	}

	/*
	 * setFilterById 按ID筛选下载任务
	 */
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
