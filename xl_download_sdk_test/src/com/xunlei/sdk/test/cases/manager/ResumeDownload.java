package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * resumeDownload 下载任务续传
 */
public class ResumeDownload extends BaseCase{

	public void testResumeDownload() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDownloadDelay(true);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int result = downloadManager.resumeDownload(id);
		assertEquals(1, result);
		sleep(1);
		int downloadStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(192, downloadStatus);
	}

}
