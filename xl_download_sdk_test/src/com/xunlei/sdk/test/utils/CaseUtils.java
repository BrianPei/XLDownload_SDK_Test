package com.xunlei.sdk.test.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.xunlei.download.XunLeiDownloadManager;
import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.log.DebugLog;

public class CaseUtils extends AndroidTestCase {

	/**
	 * Start Main Activity of the Test Project
	 * 执行了添加下载任务后，必须启动一下测试Activity，才会开始下载
	 * 
	 * @param context
	 */
	public static void startActivity(Context context) {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(context,
				"com.xunlei.sdk.test.MainActivity"));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);

	}

	/**
	 * 添加一个固定下载任务
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
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		return id;
	}

	/**
	 * 添加一个下载异常的任务
	 * 
	 * @param context
	 * @param downloadManager
	 * @return
	 */
	public static long insertFailedTask(Context context,
			XunLeiDownloadManager downloadManager) {
		Request request = new Request(
				Uri.parse("http://cdnuni.115.com/gdown_group332/M00/0B/6E/d5OWY0-_bVcAAAAAOGK3fz71ngM0150638/100089-all.wmv?k=sgs6axlCZLA00D-XJBVGVA&t=1419830076&u=2099433270-363775315-at3qgni1yq8pwh44v&s=307200&file=100089-all.wmv"));
		request.setDestinationInExternalPublicDir("Download/sdk_test",
				"fail.wmv");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		CaseUtils.startActivity(context);
		int status = 0;
		do {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cursor cursor = CaseUtils.selectTask(context, downloadManager, id);
			status = cursor.getInt(cursor.getColumnIndex("status"));
		} while (status < 400);
		DebugLog.d("Test_Debug", "Fail Status = " + String.valueOf(status));
		return id;
	}

	/**
	 * 按下载状态筛选任务
	 * 
	 * @param downloadManager
	 * @return Cursor
	 */
	public static Cursor selectTaskByStatus(Context context,
			XunLeiDownloadManager downloadManager, int status) {
		DatabaseHelper dbHelper = new DatabaseHelper(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"select * from xl_downloads where status = "
						+ String.valueOf(status), null);
		return cursor;
	}

	/**
	 * 从本地数据库获取指定下载任务
	 * 
	 * @param context
	 * @param downloadManager
	 * @param id
	 * @return Cursor
	 */
	public static Cursor selectTask(Context context,
			XunLeiDownloadManager downloadManager, long id) {
		DatabaseHelper dbHelper = new DatabaseHelper(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from xl_downloads where _id = "
				+ String.valueOf(id), null);
		cursor.moveToNext();
		return cursor;
	}

	/**
	 * 从本地数据库获取指定下载任务的下载速度
	 * 
	 * @param context
	 * @param downloadManager
	 * @param id
	 * @return int speed
	 */
	public static int selectDownloadSpeed(Context context,
			XunLeiDownloadManager downloadManager, long id) {
		Cursor cursor = selectTask(context, downloadManager, id);
		int speed = cursor.getInt(cursor.getColumnIndex("download_speed"));
		DebugLog.d("Test_Debug", "Download Speed = " + String.valueOf(speed));
		return speed;
	}

	/**
	 * 从本地数据库获取指定下载任务的下载状态
	 * 
	 * @param context
	 * @param downloadManager
	 * @param id
	 * @return int status
	 */
	public static int selectDownloadStatus(Context context,
			XunLeiDownloadManager downloadManager, long id) {
		Cursor cursor = selectTask(context, downloadManager, id);
		int status = cursor.getInt(cursor.getColumnIndex("status"));
		DebugLog.d("Test_Debug", "Download Status = " + String.valueOf(status));
		return status;
	}

	/**
	 * 从本地数据库获取指定下载任务的目标文件大小
	 * 
	 * @param context
	 * @param downloadManager
	 * @param id
	 * @return int size(byte)
	 */
	public static int selectTargetSize(Context context,
			XunLeiDownloadManager downloadManager, long id) {
		Cursor cursor = selectTask(context, downloadManager, id);
		int size = cursor.getInt(cursor.getColumnIndex("total_bytes"));
		DebugLog.d("Test_Debug", "File Size = " + String.valueOf(size));
		return size;
	}

	/**
	 * 从本地数据库获取指定下载任务的文件类型
	 * 
	 * @param context
	 * @param downloadManager
	 * @param id
	 * @return String mimeType
	 */
	public static String selectMimeType(Context context,
			XunLeiDownloadManager downloadManager, long id) {
		Cursor cursor = selectTask(context, downloadManager, id);
		String mimeType = cursor.getString(cursor.getColumnIndex("mimetype"));
		DebugLog.d("Test_Debug", "MimeType = " + mimeType);
		return mimeType;
	}

	/**
	 * 从本地数据库获取最新一条下载任务
	 * 
	 * @param context
	 * @param downloadManager
	 * @return
	 */
	public static Cursor selectNewTask(Context context,
			XunLeiDownloadManager downloadManager) {
		DatabaseHelper dbHelper = new DatabaseHelper(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"select * from xl_downloads order by _id desc limit 1", null);
		cursor.moveToNext();
		return cursor;
	}
}
