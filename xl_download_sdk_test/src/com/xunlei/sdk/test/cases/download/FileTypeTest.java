package com.xunlei.sdk.test.cases.download;

import android.content.Context;

import android.net.Uri;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;
import com.xunlei.sdk.test.utils.VerifyUtils;
import com.xunlei.sdk.test.utils.log.DebugLog;

/*
 * 文件类型下载测试
 */
public class FileTypeTest extends BaseCase {

	// 类型为APK
	public void test_APK() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://cdn.vko.cn/pai/ppandroid.apk"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "application/vnd.android.package-archive", type);
	}

	// 类型为JPG
	public void test_JPG() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://imgsrc.baidu.com/baike/pic/item/3b292df5e0fe99254496c22237a85edf8db1712e.jpg"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"3b292df5e0fe99254496c22237a85edf8db1712e.jpg");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "image/jpeg", type);
	}

	// 类型为PNG
	public void test_PNG() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://simg3.gelbooru.com/images/b2/48/b24896de29cdc2a25cefa256e9b376ef.png"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"b24896de29cdc2a25cefa256e9b376ef.png");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "image/png", type);
	}

	// 类型为GIF
	public void test_GIF() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://s1.dwstatic.com/group1/M00/11/E2/be59ad075cd3df35eb65326e6507c979.gif"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"be59ad075cd3df35eb65326e6507c979.gif");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "image/gif", type);
	}

	// 类型为MP3
	public void test_MP3() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://cdn.lizhi.fm/audio/2014/01/14/8787707910288262_hd.mp3"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"8787707910288262_hd.mp3");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "audio/mpeg", type);
	}

	// 类型为MP4
	public void test_MP4() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(Uri.parse("http://ad.youku.com/ad1.mp4"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "ad1.mp4");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "audio/mpeg", type);
	}

	// 类型为TXT
	public void test_TXT() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://dt.80txt.com/48670/%E6%97%A0%E9%99%90%E8%BF%9B%E5%8C%96.txt"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "testTXT.txt");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "text/plain", type);
	}

	// 类型为ZIP
	public void test_ZIP() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://bigota.d.miui.com/4.12.5/miui_MI2A_4.12.5_9a4dd2b79d_4.1.zip"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"miui_MI2A_4.12.5_9a4dd2b79d_4.1.zip");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "application/zip", type);
	}

	// 类型为BIN
	public void test_BIN() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://bigota.miwifi.com/xiaoqiang/rom/r1cm/miwifi_r1cm_all_02508_0.7.15.bin"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"miwifi_r1cm_all_02508_0.7.15.bin");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "application/octet-stream", type);
	}

	// 类型为MDS
	public void test_MDS() {
		printDivideLine();
		// 建立下载任务
		Request request = new Request(
				Uri.parse("http://f1.market.mi-img.com/download/AppStore/00fb740fc6c938a5dfe4e09fa3bd757c39741d52f/%E5%85%A8%E6%B0%91%E5%88%87%E6%B0%B4%E6%9E%9C_1.0.7_1007.mds"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"1.0.7_1007.mds");
		long id = downloadManager.enqueue(request);
		DebugLog.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue("下载任务建立失败", id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(5);
		VerifyUtils.verifyDownloadResult(context, downloadManager, id);
		// 验证下载任务的文件类型
		String type = CaseUtils.selectMimeType(context, downloadManager, id);
		assertEquals("文件类型错误", "application/octet-stream", type);
	}
}
