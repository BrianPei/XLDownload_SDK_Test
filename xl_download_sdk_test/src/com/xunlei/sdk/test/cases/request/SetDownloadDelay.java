package com.xunlei.sdk.test.cases.request;

import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * setDownloadDelay 设置是否立即下载
 */
public class SetDownloadDelay extends BaseCase {
	private Request request;

	// 设置为不立即下载
	public void testSetDownloadDelay() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDownloadDelay(true);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(193, status);
	}

	// 设置为立即下载
	public void testSetDownloadDelay2() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDownloadDelay(false);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(190, status);
	}
}
