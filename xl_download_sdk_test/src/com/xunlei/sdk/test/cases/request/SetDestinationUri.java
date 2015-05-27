package com.xunlei.sdk.test.cases.request;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setDestinationUri 设置下载任务的目标位置（绝对路径）
 */
public class SetDestinationUri extends BaseCase{
	private Request request;

	public void testSetDestinationUri() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationUri(Uri
				.parse("file:///storage/emulated/0/Download/sdk_test/201412181_uc.apk"));
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String hint = cursor.getString(cursor.getColumnIndex("hint"));
		Log.d("Test_Debug", hint);
		assertEquals(
				"file:///storage/emulated/0/Download/sdk_test/201412181_uc.apk",
				hint);
	}
}
