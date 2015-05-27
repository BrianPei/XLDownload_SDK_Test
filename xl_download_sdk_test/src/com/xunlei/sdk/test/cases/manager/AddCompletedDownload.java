package com.xunlei.sdk.test.cases.manager;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * addCompletedDownload 添加本地文件至下载管理库
 */
public class AddCompletedDownload extends BaseCase {

	// 未设置allowWrite
	public void testAddCompletedDownload() {
		printDivideLine();
		String path = "/storage/sdcard0/Download/1147_微会.apk";
		String title = "weihui";
		String description = "Test Description";
		String mimeType = "application/vnd.android.package-archive";
		long id = downloadManager.addCompletedDownload(title, description,
				true, mimeType, path, 2076180L, true);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertEquals(title, cursor.getString(cursor.getColumnIndex("title")));
		assertEquals(description,
				cursor.getString(cursor.getColumnIndex("description")));
		assertEquals(mimeType,
				cursor.getString(cursor.getColumnIndex("mimeType")));
		assertEquals(path,
				cursor.getString(cursor.getColumnIndex("local_filename")));
		assertEquals(2076180L,
				cursor.getLong(cursor.getColumnIndex("total_size")));
		assertEquals(200,
				cursor.getInt(cursor.getColumnIndex("status_original")));
		assertEquals(0, cursor.getInt(cursor.getColumnIndex("allow_write")));
		assertEquals(6, cursor.getInt(cursor.getColumnIndex("destination")));
	}

	// 设置allowWrite
	public void testAddCompletedDownloadAllowWrite() {
		printDivideLine();
		String path = "/storage/sdcard0/Download/1147_微会.apk";
		String title = "weihui";
		String description = "Test Description";
		String mimeType = "application/vnd.android.package-archive";
		long id = downloadManager.addCompletedDownload(title, description,
				true, mimeType, path, 2076180L, true, true);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertEquals(title, cursor.getString(cursor.getColumnIndex("title")));
		assertEquals(description,
				cursor.getString(cursor.getColumnIndex("description")));
		assertEquals(mimeType,
				cursor.getString(cursor.getColumnIndex("media_type")));
		assertEquals(path,
				cursor.getString(cursor.getColumnIndex("local_filename")));
		assertEquals(2076180L,
				cursor.getLong(cursor.getColumnIndex("total_size")));
		assertEquals(200,
				cursor.getInt(cursor.getColumnIndex("status_original")));
		assertEquals(1, cursor.getInt(cursor.getColumnIndex("allow_write")));
		assertEquals(6, cursor.getInt(cursor.getColumnIndex("destination")));
	}

}
