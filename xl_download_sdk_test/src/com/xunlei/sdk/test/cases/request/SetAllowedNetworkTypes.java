package com.xunlei.sdk.test.cases.request;

import android.net.Uri;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.ReflectUtils;

/*
 * setAllowedNetworkTypes 设置允许下载的网络类型
 */
public class SetAllowedNetworkTypes extends BaseCase {
	private Request request;

	// 设置为允许移动网络下载
	public void testSetAllowedNetworkTypes() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setAllowedNetworkTypes(Request.NETWORK_MOBILE);
		Object mAllowedNetworkTypes = ReflectUtils.getPrivateAttr(request,
				"mAllowedNetworkTypes");
		assertEquals(1, mAllowedNetworkTypes);
	}

	// 设置为只允许wifi下载
	public void testSetAllowedNetworkTypes2() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setAllowedNetworkTypes(Request.NETWORK_WIFI);
		Object mAllowedNetworkTypes = ReflectUtils.getPrivateAttr(request,
				"mAllowedNetworkTypes");
		assertEquals(2, mAllowedNetworkTypes);
	}
}
