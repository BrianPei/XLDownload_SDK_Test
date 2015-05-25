package com.xunlei.sdk.test.cases;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.download.XunLeiDownloadManager.Query;
import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

public class ManagerTest extends BaseCase {

	/*
	 * addCompletedDownload 添加本地文件至下载管理库
	 */
	// 未设置allowWrite
	public void testAddCompletedDownload() {
		printDivideLine();
		String path = "/storage/sdcard0/Download/1147_微会.apk";
		String title = "weihui";
		String description = "Test Description";
		String mimeType = "application/vnd.android.package-archive";
		long id = downloadManager.addCompletedDownload(title, description,
				true, mimeType, path, 2076180L, true);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertEquals(title, cursor.getString(cursor.getColumnIndex("title")));
		assertEquals(description,
				cursor.getString(cursor.getColumnIndex("description")));
		assertEquals(mimeType,
				cursor.getString(cursor.getColumnIndex("mimeType")));
		assertEquals(path,
				cursor.getString(cursor.getColumnIndex("local_filename")));
		assertEquals(2076180L,
				cursor.getLong(cursor.getColumnIndex("total_size")));
		assertEquals(200,
				cursor.getInt(cursor.getColumnIndex("status_original")));
		assertEquals(0, cursor.getInt(cursor.getColumnIndex("allow_write")));
		assertEquals(6, cursor.getInt(cursor.getColumnIndex("destination")));
	}

	// 未设置allowWrite
	public void testAddCompletedDownloadAllowWrite() {
		printDivideLine();
		String path = "/storage/sdcard0/Download/1147_微会.apk";
		String title = "weihui";
		String description = "Test Description";
		String mimeType = "application/vnd.android.package-archive";
		long id = downloadManager.addCompletedDownload(title, description,
				true, mimeType, path, 2076180L, true, true);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertEquals(title, cursor.getString(cursor.getColumnIndex("title")));
		assertEquals(description,
				cursor.getString(cursor.getColumnIndex("description")));
		assertEquals(mimeType,
				cursor.getString(cursor.getColumnIndex("media_type")));
		assertEquals(path,
				cursor.getString(cursor.getColumnIndex("local_filename")));
		assertEquals(2076180L,
				cursor.getLong(cursor.getColumnIndex("total_size")));
		assertEquals(200,
				cursor.getInt(cursor.getColumnIndex("status_original")));
		assertEquals(1, cursor.getInt(cursor.getColumnIndex("allow_write")));
		assertEquals(6, cursor.getInt(cursor.getColumnIndex("destination")));
	}

	/*
	 * getDownloadUri 获取DownloadProvider的位置
	 */
	public void testGetDownloadUri() {
		printDivideLine();
		Uri downloadUri = XunLeiDownloadManager.getDownloadUri();
		Log.d("Test_Debug", downloadUri.toString());
		assertEquals(
				Uri.parse("content://com.xunlei.sdk.test.downloadprovider/xl_downloads"),
				downloadUri);
	}

	/*
	 * getDownloadUri 根据指定ID获取DownloadProvider的位置
	 */
	// 传入ID为1
	public void testGetDownloadUriWithID() {
		printDivideLine();
		Uri downloadUri = XunLeiDownloadManager.getDownloadUri(1L);
		Log.d("Test_Debug", downloadUri.toString());
		assertEquals(
				Uri.parse("content://com.xunlei.sdk.test.downloadprovider/xl_downloads/1"),
				downloadUri);
	}

	/*
	 * translateStatus 将下载任务状态码转换为DownloadManager的状态标识
	 */
	// 下载状态为200
	public void testTranslateStatus() {
		printDivideLine();
		int status = XunLeiDownloadManager.translateStatus(200);
		Log.d("Test_Debug", String.valueOf(status));
		assertEquals(XunLeiDownloadManager.STATUS_SUCCESSFUL, status);
	}

	/*
	 * getReason 获取下载失败任务的失败原因码
	 */
	// 下载状态为492
	public void testGetReason() {
		printDivideLine();
		long reason = XunLeiDownloadManager.getReason(492);
		Log.d("Test_Debug", String.valueOf(reason));
		assertEquals(XunLeiDownloadManager.ERROR_FILE_ERROR, reason);
	}

	/*
	 * getMaxBytesOverMobile 获取移动网络下载限制
	 */
	public void testGetMaxBytesOverMobile() {
		printDivideLine();
		Context context = this.getContext();
		long bytes = XunLeiDownloadManager.getMaxBytesOverMobile(context);
		Log.d("Test_Debug", String.valueOf(bytes));
	}

	/*
	 * getRecommendedMaxBytesOverMobile 获取建议的移动网络下载限制
	 */
	public void testGetRecommendedMaxBytesOverMobile() {
		printDivideLine();
		Context context = this.getContext();
		long bytes = XunLeiDownloadManager
				.getRecommendedMaxBytesOverMobile(context);
		Log.d("Test_Debug", String.valueOf(bytes));
	}

	/*
	 * getMimeTypeForDownloadFile 获取已下载文件的mimeType
	 */
	public void testGetMimeTypeForDownloadedFile() {
		printDivideLine();
		Cursor cursor = CaseUtils.selectSuccessfulTask(downloadManager);
		cursor.moveToFirst();
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		String media_type = cursor.getString(cursor
				.getColumnIndex("media_type"));
		String fileType = downloadManager.getMimeTypeForDownloadedFile(id);
		Log.d("Test_Debug", fileType);
		assertEquals(media_type, fileType);
	}

	/*
	 * getUriForDownloadedFile 获取已下载文件的位置
	 */
	public void testGetUriForDownloadedFile() {
		printDivideLine();
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		String localUri = cursor.getString(cursor.getColumnIndex("local_uri"));
		Uri fileUri = downloadManager.getUriForDownloadedFile(id);
		Log.d("Test_Debug", fileUri.toString());
		assertEquals(Uri.parse(localUri), fileUri);
	}

	/*
	 * pauseDownload 暂停下载任务
	 */
	public void testPauseDownload() {
		printDivideLine();
		long id = CaseUtils.insertDownloadTask(downloadManager);
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int downloadStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(192, downloadStatus);
		int result = downloadManager.pauseDownload(id);
		assertEquals(1, result);
		sleep(1);
		int pauseStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(193, pauseStatus);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertEquals(0, speed);
	}

	/*
	 * resumeDownload 下载任务续传
	 */
	public void testResumeDownload() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDownloadDelay(true);
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int result = downloadManager.resumeDownload(id);
		assertEquals(1, result);
		sleep(1);
		int downloadStatus = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(192, downloadStatus);
	}

	/*
	 * restartDownload 重启下载任务
	 */
	// 重启一个已下载成功的任务
	public void testRestartDownload() {
		printDivideLine();
		Cursor cursor = CaseUtils.selectSuccessfulTask(downloadManager);
		cursor.moveToLast();
		long id = cursor.getLong(cursor.getColumnIndex("_id"));
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		int result = downloadManager.restartDownload(id);
		assertEquals(1, result);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		Query query = new Query();
		Cursor cursor2 = downloadManager.query(query);
		cursor2.moveToFirst();
		for (int i = 0; i < cursor2.getCount(); i++) {
			long id2 = cursor2.getLong(cursor.getColumnIndex("_id"));
			if (id2 == id) {
				int status = cursor2.getInt(cursor2
						.getColumnIndex("status_original"));
				assertEquals(192, status);
				break;
			}
			cursor2.moveToNext();
		}
	}

	/*
	 * markRowDeleted 标记指定下载任务为已删除
	 */
	public void testMarkRowDeleted() {
		printDivideLine();
		long id = CaseUtils.insertDownloadTask(downloadManager);
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int result = downloadManager.markRowDeleted(id);
		assertEquals(1, result);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertTrue(cursor.getLong(cursor.getColumnIndex("_id")) < id);
	}

	/*
	 * remove 删除下载任务
	 */
	public void testRemove() {
		printDivideLine();
		long id = CaseUtils.insertDownloadTask(downloadManager);
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int result = downloadManager.remove(id);
		assertEquals(1, result);
		sleep(1);
		Cursor cursor = CaseUtils.selectNewRow(downloadManager);
		assertTrue(cursor.getLong(cursor.getColumnIndex("_id")) < id);
	}
}
