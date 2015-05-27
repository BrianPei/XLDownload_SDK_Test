package com.xunlei.sdk.test.cases.manager;

import android.content.Context;
import android.database.Cursor;

import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * remove 删除下载任务
 */
public class Remove extends BaseCase {

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
