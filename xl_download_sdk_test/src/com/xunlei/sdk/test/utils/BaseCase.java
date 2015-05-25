package com.xunlei.sdk.test.utils;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.download.XunLeiDownloadManager.Query;

public class BaseCase extends AndroidTestCase {
	protected XunLeiDownloadManager downloadManager;
	protected Query query;

	public BaseCase() {
	}

	public void setUp() {
		Context context = this.getContext();
		downloadManager = new XunLeiDownloadManager(context);
		query = new Query();
	}

	public void tearDown() {
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void printDivideLine() {
		String caseName = Thread.currentThread().getStackTrace()[3]
				.getMethodName();
		Log.d("Test_Debug", "*******" + caseName + " Start!*******");
	}
}
