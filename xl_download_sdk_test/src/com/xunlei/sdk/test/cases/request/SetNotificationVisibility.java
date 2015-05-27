package com.xunlei.sdk.test.cases.request;

import android.net.Uri;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.ReflectUtils;

/*
 * setNotificationVisibility 设置下载任务在提醒栏中的显示方式
 */
public class SetNotificationVisibility extends BaseCase {
	private Request request;

	// 设置为VISIBILITY_VISIBLE
	public void testSetNotificationVisibility() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
		Object mNotificationVisibility = ReflectUtils.getPrivateAttr(request,
				"mNotificationVisibility");
		assertEquals(0, mNotificationVisibility);
	}

	// 设置为VISIBILITY_VISIBLE_NOTIFY_COMPLETED
	public void testSetNotificationVisibility2() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		Object mNotificationVisibility = ReflectUtils.getPrivateAttr(request,
				"mNotificationVisibility");
		assertEquals(1, mNotificationVisibility);
	}

	// 设置为VISIBILITY_HIDDEN
	public void testSetNotificationVisibility3() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setNotificationVisibility(Request.VISIBILITY_HIDDEN);
		Object mNotificationVisibility = ReflectUtils.getPrivateAttr(request,
				"mNotificationVisibility");
		assertEquals(2, mNotificationVisibility);
	}

	// 设置为VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION
	public void testSetNotificationVisibility4() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION);
		Object mNotificationVisibility = ReflectUtils.getPrivateAttr(request,
				"mNotificationVisibility");
		assertEquals(3, mNotificationVisibility);
	}
}
