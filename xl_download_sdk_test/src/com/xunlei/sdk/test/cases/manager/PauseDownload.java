package com.xunlei.sdk.test.cases.manager;

import android.content.Context;

import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * pauseDownload 暂停下载任务
 */
public class PauseDownload extends BaseCase{

	public void testPauseDownload() {
		printDivideLine();
		long id = CaseUtils.insertDownloadTask(downloadManager);
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int downloadStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(192, downloadStatus);
		int result = downloadManager.pauseDownload(id);
		assertEquals(1, result);
		sleep(1);
		int pauseStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(193, pauseStatus);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertEquals(0, speed);
	}

}
