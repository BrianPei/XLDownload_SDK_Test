package com.xunlei.sdk.test.cases.manager;

import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * getDownloadUri 获取DownloadProvider的位置
 */
public class GetDownloadUri extends BaseCase {

	// 不传ID
	public void testGetDownloadUri() {
		printDivideLine();
		Uri downloadUri = XunLeiDownloadManager.getDownloadUri();
		Log.d("Test_Debug", downloadUri.toString());
		assertEquals(
				Uri.parse("content://com.xunlei.sdk.test.downloadprovider/xl_downloads"),
				downloadUri);
	}

	// 传入ID为1
	public void testGetDownloadUriWithID() {
		printDivideLine();
		Uri downloadUri = XunLeiDownloadManager.getDownloadUri(1L);
		Log.d("Test_Debug", downloadUri.toString());
		assertEquals(
				Uri.parse("content://com.xunlei.sdk.test.downloadprovider/xl_downloads/1"),
				downloadUri);
	}

}
