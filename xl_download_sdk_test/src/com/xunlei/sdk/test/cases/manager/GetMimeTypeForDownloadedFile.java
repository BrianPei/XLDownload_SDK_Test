package com.xunlei.sdk.test.cases.manager;

import android.database.Cursor;
import android.util.Log;

import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * getMimeTypeForDownloadFile 获取已下载文件的mimeType
 */
public class GetMimeTypeForDownloadedFile extends BaseCase {

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

}
