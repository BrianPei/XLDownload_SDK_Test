package com.xunlei.sdk.test.cases.request;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setTitle 设置下载任务的标题
 */
public class SetTitle extends BaseCase {
	private Request request;

	public void testSetTitle() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		String titleString = "Test Title";
		CharSequence titleChar = (CharSequence) titleString;
		request.setTitle(titleChar);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String titleColomn = cursor.getString(cursor.getColumnIndex("title"));
		Log.d("Test_Debug", titleColomn);
		assertEquals(titleString, titleColomn);
	}
}
