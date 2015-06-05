package com.xunlei.sdk.test.suites;

import com.xunlei.sdk.test.cases.manager.AddCompletedDownload;
import com.xunlei.sdk.test.cases.manager.Enqueue;
import com.xunlei.sdk.test.cases.manager.GetDownloadUri;
import com.xunlei.sdk.test.cases.manager.GetMaxBytesOverMobile;
import com.xunlei.sdk.test.cases.manager.GetMimeTypeForDownloadedFile;
import com.xunlei.sdk.test.cases.manager.GetReason;
import com.xunlei.sdk.test.cases.manager.GetRecommendedMaxBytesOverMobile;
import com.xunlei.sdk.test.cases.manager.GetUriForDownloadedFile;
import com.xunlei.sdk.test.cases.manager.MarkRowDeleted;
import com.xunlei.sdk.test.cases.manager.PauseDownload;
import com.xunlei.sdk.test.cases.manager.Query;
import com.xunlei.sdk.test.cases.manager.Remove;
import com.xunlei.sdk.test.cases.manager.RestartDownload;
import com.xunlei.sdk.test.cases.manager.ResumeDownload;
import com.xunlei.sdk.test.cases.manager.TranslateStatus;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class ManagerRunner extends InstrumentationTestRunner {

	public TestSuite getTestSuite() {
		TestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(Enqueue.class);
		suite.addTestSuite(Query.class);
		suite.addTestSuite(AddCompletedDownload.class);
		suite.addTestSuite(GetDownloadUri.class);
		suite.addTestSuite(GetMaxBytesOverMobile.class);
		suite.addTestSuite(GetRecommendedMaxBytesOverMobile.class);
		suite.addTestSuite(GetMimeTypeForDownloadedFile.class);
		suite.addTestSuite(GetReason.class);
		suite.addTestSuite(GetUriForDownloadedFile.class);
		suite.addTestSuite(MarkRowDeleted.class);
		suite.addTestSuite(PauseDownload.class);
		suite.addTestSuite(Remove.class);
		suite.addTestSuite(RestartDownload.class);
		suite.addTestSuite(ResumeDownload.class);
		suite.addTestSuite(TranslateStatus.class);
		return suite;
	}

	public ClassLoader getLoader() {
		return ManagerRunner.class.getClassLoader();
	}
}
