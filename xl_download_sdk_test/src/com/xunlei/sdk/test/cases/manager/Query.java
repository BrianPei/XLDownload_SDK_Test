package com.xunlei.sdk.test.cases.manager;

import android.database.Cursor;

import com.xunlei.sdk.test.utils.BaseCase;

/*
 * query 查询所有已下载的任务
 */
public class Query extends BaseCase {

	// 验证列名
	public void testQuery() {
		printDivideLine();
		String[] colomn = { "_id", "local_filename", "mediaprovider_uri",
				"destination", "title", "description", "uri", "status", "hint",
				"media_type", "total_size", "last_modified_timestamp",
				"bytes_so_far", "download_speed", "origin_speed", "p2s_speed",
				"errorMsg", "allow_write", "local_uri", "reason",
				"status_original" };
		query.orderBy("_id", 1);
		Cursor cursor = downloadManager.query(query);
		for (int i = 0; i < cursor.getColumnCount(); i++) {
			String colomnName = cursor.getColumnName(i);
			assertEquals(colomn[i], colomnName);
		}
	}

}
