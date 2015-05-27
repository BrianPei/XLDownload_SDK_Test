package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * getRecommendedMaxBytesOverMobile 获取建议的移动网络下载限制
 */
public class GetRecommendedMaxBytesOverMobile extends BaseCase {

	public void testGetRecommendedMaxBytesOverMobile() {
		printDivideLine();
		Context context = this.getContext();
		long bytes = XunLeiDownloadManager
				.getRecommendedMaxBytesOverMobile(context);
		Log.d("Test_Debug", String.valueOf(bytes));
	}

}
