package com.xunlei.sdk.test.cases.manager;

import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Query;
import com.xunlei.sdk.test.utils.BaseCase;

/*
 * getUriForDownloadedFile 获取已下载文件的位置
 */
public class GetUriForDownloadedFile extends BaseCase{

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

}
