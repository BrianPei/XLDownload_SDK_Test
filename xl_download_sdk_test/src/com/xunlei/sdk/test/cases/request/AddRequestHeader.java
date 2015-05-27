package com.xunlei.sdk.test.cases.request;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.util.Pair;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.ReflectUtils;

/*
 * addRequestHeader 添加HTTP请求头信息
 */
public class AddRequestHeader extends BaseCase {
	private Request request;

	@SuppressWarnings("unchecked")
	public void testAddRequestHeader() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.addRequestHeader("TestKey", "TestValue");
		Object mRequestHeaders = ReflectUtils.getPrivateAttr(request,
				"mRequestHeaders");
		List<Pair<String, String>> headerList = (ArrayList<Pair<String, String>>) mRequestHeaders;
		assertTrue(!headerList.isEmpty());
	}

}
