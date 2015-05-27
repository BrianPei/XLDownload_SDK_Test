package com.xunlei.sdk.test.cases.manager;

import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * getReason 获取下载失败任务的失败原因码
 */
public class GetReason extends BaseCase{

	// 下载状态为492
	public void testGetReason() {
		printDivideLine();
		long reason = XunLeiDownloadManager.getReason(492);
		Log.d("Test_Debug", String.valueOf(reason));
		assertEquals(XunLeiDownloadManager.ERROR_FILE_ERROR, reason);
	}

}
