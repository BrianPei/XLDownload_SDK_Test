package com.xunlei.sdk.test.cases.request;

import android.net.Uri;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.ReflectUtils;

/*
 * allowScanningByMediaScanner 允许系统媒体库扫描
 */
public class AllowScanningByMediaScanner extends BaseCase {
	private Request request;

	public void testAllowScanningByMediaScanner() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.allowScanningByMediaScanner();
		Object mScannable = ReflectUtils.getPrivateAttr(request, "mScannable");
		assertEquals(true, mScannable);
	}
}
