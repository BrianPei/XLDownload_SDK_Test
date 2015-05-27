package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Query;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * restartDownload 重启下载任务
 */
public class RestartDownload extends BaseCase {

	// 重启一个已下载成功的任务
	public void testRestartDownload() {
		printDivideLine();
		Cursor cursor = CaseUtils.selectSuccessfulTask(downloadManager);
		cursor.moveToLast();
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		int result = downloadManager.restartDownload(id);
		assertEquals(1, result);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		Query query = new Query();
		Cursor cursor2 = downloadManager.query(query);
		cursor2.moveToFirst();
		for (int i = 0; i < cursor2.getCount(); i++) {
			long id2 = cursor2.getLong(cursor.getColumnIndex("_id"));
			if (id2 == id) {
				int status = cursor2.getInt(cursor2
						.getColumnIndex("status_original"));
				assertEquals(192, status);
				break;
			}
			cursor2.moveToNext();
		}
	}

}
