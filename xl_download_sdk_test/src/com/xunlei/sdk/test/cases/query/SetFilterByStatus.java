package com.xunlei.sdk.test.cases.query;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * setFilterByStatus 按状态筛选下载任务
 */
public class SetFilterByStatus extends BaseCase {

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

}
