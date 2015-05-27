package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * getMaxBytesOverMobile 获取移动网络下载限制
 */
public class GetMaxBytesOverMobile extends BaseCase{

	public void testGetMaxBytesOverMobile() {
		printDivideLine();
		Context context = this.getContext();
		long bytes = XunLeiDownloadManager.getMaxBytesOverMobile(context);
		Log.d("Test_Debug", String.valueOf(bytes));
	}

}
