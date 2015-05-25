package com.xunlei.sdk.test.utils;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.download.XunLeiDownloadManager.Query;
import com.xunlei.download.XunLeiDownloadManager.Request;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class CaseUtils {

	/**
	 * Start Main Activity of the Test Project
	 * 
	 * @param context
	 */
	// 执行了添加下载任务后，必须启动一下测试app，才会开始下载，原因暂时未知
	public static void startActivity(Context context) {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(context,
				"com.xunlei.sdk.test.MainActivity"));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	/**
	 * 添加一个下载任务
	 * 
	 * @param downloadManager
	 * @return Task id
	 */
	public static long insertDownloadTask(XunLeiDownloadManager downloadManager) {
		Request request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationInExternalPublicDir("Download/sdk_test",
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		return id;
	}

	/**
	 * 暂停指定的下载任务
	 * 
	 * @param downloadManager
	 * @param ids
	 * @return result code
	 */
	public static int pauseDownloadTask(XunLeiDownloadManager downloadManager,
			long... ids) {
		return downloadManager.pauseDownload(ids);
	}
	
	/**
	 * 筛选所有下载成功的任务
	 * 
	 * @param downloadManager
	 * @return Cursor
	 */
	public static Cursor selectSuccessfulTask(
			XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		query.setFilterByStatus(XunLeiDownloadManager.STATUS_SUCCESSFUL);
		return downloadManager.query(query);
	}

	/**
	 * 获取最新一行下载数据
	 * 
	 * @param downloadManager
	 * @return Cursor
	 */
	public static Cursor selectNewRow(XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		return cursor;
	}

	/**
	 * 获取最新一个下载任务的下载速度
	 * 
	 * @param downloadManager
	 * @return int speed
	 */
	public static int selectDownloadSpeed(XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		int speed = cursor.getInt(cursor.getColumnIndex("download_speed"));
		Log.d("Test_Debug", String.valueOf(speed));
		return speed;
	}

	/**
	 * 获取最新一个下载任务的下载状态
	 * 
	 * @param downloadManager
	 * @return int status
	 */
	public static int selectDownloadStatus(XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		int status = cursor.getInt(cursor.getColumnIndex("status_original"));
		Log.d("Test_Debug", String.valueOf(status));
		return status;
	}

	/**
	 * 获取最新一个下载任务的目标文件大小
	 * 
	 * @param downloadManager
	 * @return int size(byte)
	 */
	public static int selectTargetSize(XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		int size = cursor.getInt(cursor.getColumnIndex("total_size"));
		Log.d("Test_Debug", String.valueOf(size));
		return size;
	}

	/**
	 * 获取最新一个下载任务的文件类型
	 * 
	 * @param downloadManager
	 * @return String mimeType
	 */
	public static String selectMimeType(XunLeiDownloadManager downloadManager) {
		Query query = new Query();
		Cursor cursor = downloadManager.query(query);
		cursor.moveToFirst();
		String mimeType = cursor.getString(cursor.getColumnIndex("media_type"));
		Log.d("Test_Debug", mimeType);
		return mimeType;
	}
}
