package com.xunlei.sdk.test.cases.manager;

import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * translateStatus 将下载任务状态码转换为DownloadManager的状态标识
 */
public class TranslateStatus extends BaseCase {

	// 下载状态为200
	public void testTranslateStatus() {
		printDivideLine();
		int status = XunLeiDownloadManager.translateStatus(200);
		Log.d("Test_Debug", String.valueOf(status));
		assertEquals(XunLeiDownloadManager.STATUS_SUCCESSFUL, status);
	}

}
