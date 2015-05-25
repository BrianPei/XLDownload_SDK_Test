package com.xunlei.sdk.test.cases;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;
import com.xunlei.sdk.test.utils.ReflectUtils;

public class RequestTest extends BaseCase {
	private Request request;

	/*
	 * addRequestHeader 添加HTTP请求头信息
	 */
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

	/*
	 * allowScanningByMediaScanner 允许系统媒体库扫描
	 */
	public void testAllowScanningByMediaScanner() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.allowScanningByMediaScanner();
		Object mScannable = ReflectUtils.getPrivateAttr(request, "mScannable");
		assertEquals(true, mScannable);
	}

	/*
	 * setAllowedNetworkTypes 设置允许下载的网络类型
	 */
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

	/*
	 * setAllowedOverRoaming 设置是否允许数据漫游时下载
	 */
	// 设置为允许漫游
	public void testSetAllowedOverRoaming() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setAllowedOverRoaming(false);
		Object mRoamingAllowed = ReflectUtils.getPrivateAttr(request,
				"mRoamingAllowed");
		assertEquals(false, mRoamingAllowed);
	}

	/*
	 * setDescription 添加任务描述
	 */
	public void testSetDescription() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		String descString = "Test Description";
		CharSequence descChar = (CharSequence) descString;
		request.setDescription(descChar);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String descColomn = cursor.getString(cursor
				.getColumnIndex("description"));
		Log.d("Test_Debug", descColomn);
		assertEquals(descString, descColomn);
	}

	/*
	 * setDestinationInExternalFilesDir 设置下载到内置存储的路径
	 */
	public void testSetDestinationInExternalFilesDir() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		Context context = this.getContext();
		request.setDestinationInExternalFilesDir(context, "DownloadTest",
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String hint = cursor.getString(cursor.getColumnIndex("hint"));
		Log.d("Test_Debug", hint);
		assertEquals(
				"file:///storage/emulated/0/Android/data/com.xunlei.sdk.test/files/DownloadTest/201412181_uc.apk",
				hint);
	}

	/*
	 * setDestinationInExternalPublicDir 设置下载到外置存储的路径
	 */
	public void testSetDestinationInExternalPublicDir() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationInExternalPublicDir("Download/sdk_test",
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String hint = cursor.getString(cursor.getColumnIndex("hint"));
		Log.d("Test_Debug", hint);
		assertEquals(
				"file:///storage/emulated/0/Download/sdk_test/201412181_uc.apk",
				hint);
	}

	/*
	 * setDestinationUri 设置下载任务的目标位置（绝对路径）
	 */
	public void testSetDestinationUri() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationUri(Uri
				.parse("file:///storage/emulated/0/Download/sdk_test/201412181_uc.apk"));
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String hint = cursor.getString(cursor.getColumnIndex("hint"));
		Log.d("Test_Debug", hint);
		assertEquals(
				"file:///storage/emulated/0/Download/sdk_test/201412181_uc.apk",
				hint);
	}

	/*
	 * setDownloadDelay 设置是否立即下载
	 */
	// 设置为不立即下载
	public void testSetDownloadDelay() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDownloadDelay(true);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(193, status);
	}

	/*
	 * setMimeType 设置下载任务文件的类型
	 */
	public void testSetMimeType() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setMimeType("TestMimeType");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		String mimeType = CaseUtils.selectMimeType(downloadManager);
		assertEquals("TestMimeType", mimeType);
	}

	/*
	 * setNotificationVisibility 设置下载任务在提醒栏中的显示方式
	 */
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

	/*
	 * setTitle 设置下载任务的标题
	 */
	public void testSetTitle() {
		printDivideLine();
		request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		String titleString = "Test Title";
		CharSequence titleChar = (CharSequence) titleString;
		request.setTitle(titleChar);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		String titleColomn = cursor.getString(cursor.getColumnIndex("title"));
		Log.d("Test_Debug", titleColomn);
		assertEquals(titleString, titleColomn);
	}
}
