package com.xunlei.sdk.test.cases.request;

import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setMimeType 设置下载任务文件的类型
 */
public class SetMimeType extends BaseCase {
	private Request request;

	public void testSetMimeType() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setMimeType("TestMimeType");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		String mimeType = CaseUtils.selectMimeType(downloadManager);
		assertEquals("TestMimeType", mimeType);
	}
}
