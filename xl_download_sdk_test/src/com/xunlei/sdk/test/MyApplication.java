package com.xunlei.sdk.test;

import com.android.providers.downloads.DownloadProvider;
import com.xunlei.download.XLDownloadProvider;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		DownloadProvider.init(this, XLDownloadProvider.class);
		Log.d("Test_Debug","App is called!");
	}
}
