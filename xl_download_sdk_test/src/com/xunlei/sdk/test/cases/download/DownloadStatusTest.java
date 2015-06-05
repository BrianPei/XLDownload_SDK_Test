package com.xunlei.sdk.test.cases.download;

import android.content.Context;
import android.net.Uri;
import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;
import com.xunlei.sdk.test.utils.log.DebugLog;

public class DownloadStatusTest extends BaseCase {

	public void test_403() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cdnuni.115.com/gdown_group332/M00/0B/6E/d5OWY0-_bVcAAAAAOGK3fz71ngM0150638/100089-all.wmv?k=sgs6axlCZLA00D-XJBVGVA&t=1419830076&u=2099433270-363775315-at3qgni1yq8pwh44v&s=307200&file=100089-all.wmv"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "fail.wmv");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		int status;
		do {
			sleep(1);
			status = CaseUtils.selectDownloadStatus(context, downloadManager,
					id);
			break;
		} while (status > 400);
		DebugLog.d("Test_Debug", "Final Status = " + String.valueOf(status));
	}
}
