package com.xunlei.sdk.test.cases.request;

import android.net.Uri;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.ReflectUtils;

/*
 * setAllowedOverRoaming 设置是否允许数据漫游时下载
 */
public class SetAllowedOverRoaming extends BaseCase{
	private Request request;

	// 设置为不允许漫游
	public void testSetAllowedOverRoaming() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setAllowedOverRoaming(false);
		Object mRoamingAllowed = ReflectUtils.getPrivateAttr(request,
				"mRoamingAllowed");
		assertEquals(false, mRoamingAllowed);
	}

	// 设置为允许漫游
	public void testSetAllowedOverRoaming2() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setAllowedOverRoaming(true);
		Object mRoamingAllowed = ReflectUtils.getPrivateAttr(request,
				"mRoamingAllowed");
		assertEquals(true, mRoamingAllowed);
	}
}
