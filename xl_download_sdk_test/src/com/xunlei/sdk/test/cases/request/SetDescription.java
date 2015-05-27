package com.xunlei.sdk.test.cases.request;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setDescription 添加任务描述
 */
public class SetDescription extends BaseCase {
	private Request request;

	public void testSetDescription() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		String descString = "Test Description";
		CharSequence descChar = (CharSequence) descString;
		request.setDescription(descChar);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String descColomn = cursor.getString(cursor
				.getColumnIndex("description"));
		Log.d("Test_Debug", descColomn);
		assertEquals(descString, descColomn);
	}
}
