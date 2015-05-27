package com.xunlei.sdk.test.cases.enqueue;

import android.content.Context;

import android.net.Uri;
import android.util.Log;

import com.xunlei.download.XunLeiDownloadManager.Request;
import com.xunlei.sdk.test.utils.BaseCase;
import com.xunlei.sdk.test.utils.CaseUtils;

/*
 * 文件类型下载测试
 */
public class FileTypeTest extends BaseCase {
	public static String DOWNLOADPATH = "Download/sdk_test";

	// 类型为APK
	public void test_APK() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cache.iruan.cn/201412/201412181_uc.apk"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"201412181_uc.apk");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(2);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("application/vnd.android.package-archive", type);
	}

	// 类型为JPG
	public void test_JPG() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://m.qqtn.com/up/2014-6/14035028369055418.jpg"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"14035028369055418.jpg");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("image/jpeg", type);
	}

	// 类型为PNG
	public void test_PNG() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://simg3.gelbooru.com/images/b2/48/b24896de29cdc2a25cefa256e9b376ef.png"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"b24896de29cdc2a25cefa256e9b376ef.png");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("image/png", type);
	}

	// 类型为MP#
	public void test_MP3() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cdn.lizhi.fm/audio/2014/01/14/8787707910288262_hd.mp3"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"8787707910288262_hd.mp3");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("audio/mpeg", type);
	}

	// 类型为WMV
	// 资源连接490
	public void test_WMV() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://cdnuni.115.com/gdown_group332/M00/0B/6E/d5OWY0-_bVcAAAAAOGK3fz71ngM0150638/100089-all.wmv?k=sgs6axlCZLA00D-XJBVGVA&t=1419830076&u=2099433270-363775315-at3qgni1yq8pwh44v&s=307200&file=100089-all.wmv"));
		request.setDestinationInExternalPublicDir(
				DOWNLOADPATH,
				"100089-all.wmv?k=sgs6axlCZLA00D-XJBVGVA&t=1419830076&u=2099433270-363775315-at3qgni1yq8pwh44v&s=307200&file=100089-all.wmv");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(490, status);
	}

	// 类型为AVI
	// 资源连接490
	public void test_AVI() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://bj.baidupcs.com/file/156cc23b8f0b3529085f1249d64145c4?bkt=p2-qd-158&fid=1561548257-250528-900150976259165&time=1419777111&sign=FDTAXERLBH-DCb740ccc5511e5e8fedcff06b081203-tYu37wWEmBy0y%2BLbGHiSTfB6pfM%3D&to=bb&fm=Nan,B,M,ny&newver=1&newfm=1&flow_ver=3&sl=81723466&expires=8h&rt=pr&r=523148587&mlogid=3189288449&vuk=1561548257&vbdid=3931372812&fin=%E8%A7%86%E9%A2%91.AVI"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "test.AVI");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(490, status);
	}

	// 类型为TXT
	// 资源连接490
	public void test_TXT() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://bj.baidupcs.com/file/cb12a4f302ac01fb86346aac05d353cf?bkt=p2-nj-247&fid=455716051-250528-681488767235985&time=1419808402&sign=FDTAXERLBH-DCb740ccc5511e5e8fedcff06b081203-a8iGooHq0Pxa9wOh%2BASqLofuNbY%3D&to=bb&fm=Qin,B,M,mn&newver=1&newfm=1&flow_ver=3&sl=80412750&expires=1419809002&rt=sh&r=199170751&mlogid=3829081663&sh=1&vuk=1397976785&vbdid=1684674285&fin=XHaloFloatingWindow%E5%8F%AF%E9%85%8D%E5%90%88%E4%BD%BF%E7%94%A8%E7%9A%84%E8%BD%AF%E4%BB%B6.txt&fn=XHaloFloatingWindow%E5%8F%AF%E9%85%8D%E5%90%88%E4%BD%BF%E7%94%A8%E7%9A%84%E8%BD%AF%E4%BB%B6.txt"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "testTXT.txt");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int status = CaseUtils.selectDownloadStatus(downloadManager);
		assertEquals(490, status);
	}

	// 类型为ZIP
	public void test_ZIP() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://bigota.d.miui.com/4.12.5/miui_MI2A_4.12.5_9a4dd2b79d_4.1.zip"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"miui_MI2A_4.12.5_9a4dd2b79d_4.1.zip");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("application/zip", type);
	}

	// 类型为RAR
	public void test_RAR() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://wap.23bbbb.com/bt/20140117/xjtzftp.rar"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH, "xjtzftp.rar");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int size = CaseUtils.selectTargetSize(downloadManager);
		assertTrue(size > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("application/x-rar-compressed", type);
	}

	// 类型为BIN
	public void test_BIN() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://bigota.miwifi.com/xiaoqiang/rom/r1cm/miwifi_r1cm_all_02508_0.7.15.bin"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"miwifi_r1cm_all_02508_0.7.15.bin");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("application/octet-stream", type);
	}

	// 类型为MDS
	public void test_MDS() {
		printDivideLine();
		Request request = new Request(
				Uri.parse("http://f1.market.mi-img.com/download/AppStore/00fb740fc6c938a5dfe4e09fa3bd757c39741d52f/%E5%85%A8%E6%B0%91%E5%88%87%E6%B0%B4%E6%9E%9C_1.0.7_1007.mds"));
		request.setDestinationInExternalPublicDir(DOWNLOADPATH,
				"1.0.7_1007.mds");
		long id = downloadManager.enqueue(request);
		Log.d("Test_Debug", "Task ID = " + String.valueOf(id));
		assertTrue(id > 0);
		Context context = this.getContext();
		CaseUtils.startActivity(context);
		sleep(3);
		int speed = CaseUtils.selectDownloadSpeed(downloadManager);
		assertTrue(speed > 0);
		String type = CaseUtils.selectMimeType(downloadManager);
		assertEquals("application/octet-stream", type);
	}
}
