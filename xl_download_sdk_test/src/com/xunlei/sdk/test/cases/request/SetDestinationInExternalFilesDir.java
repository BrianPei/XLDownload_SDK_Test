package com.xunlei.sdk.test.cases.request;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setDestinationInExternalFilesDir 设置下载到内置存储的路径
 */
public class SetDestinationInExternalFilesDir extends BaseCase {
	private Request request;

	public void testSetDestinationInExternalFilesDir() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		Context context = this.getContext();
		request.setDestinationInExternalFilesDir(context, "DownloadTest",
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String hint = cursor.getString(cursor.getColumnIndex("hint"));
		Log.d("Test_Debug", hint);
		assertEquals(
				"file:///storage/emulated/0/Android/data/com.xunlei.sdk.test/files/DownloadTest/201412181_uc.apk",
				hint);
	}
}
