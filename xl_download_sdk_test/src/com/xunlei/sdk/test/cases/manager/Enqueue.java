package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.net.Uri;
import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;
import com.xunlei.sdk.test.utils.VerifyUtils;
import com.xunlei.sdk.test.utils.log.DebugLog;

/*
 * enqueue 添加下载任务
 */
public class Enqueue extends BaseCase {

	// 以默认设置添加一个下载任务
	public void testEnqueue() {
		printDivideLine();
		// 添加测试Request
		Request request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"201412181_uc.apk");
		// 调用接口建立下载任务
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		// 验证下载结果
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
	}
}
