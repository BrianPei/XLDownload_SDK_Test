package com.xunlei.sdk.test.suites;


import com.xunlei.sdk.test.cases.request.AddRequestHeader;
import com.xunlei.sdk.test.cases.request.AllowScanningByMediaScanner;
import com.xunlei.sdk.test.cases.request.SetAllowedNetworkTypes;
import com.xunlei.sdk.test.cases.request.SetAllowedOverRoaming;
import com.xunlei.sdk.test.cases.request.SetDescription;
import com.xunlei.sdk.test.cases.request.SetDestinationInExternalFilesDir;
import com.xunlei.sdk.test.cases.request.SetDestinationInExternalPublicDir;
import com.xunlei.sdk.test.cases.request.SetDestinationUri;
import com.xunlei.sdk.test.cases.request.SetDownloadDelay;
import com.xunlei.sdk.test.cases.request.SetMimeType;
import com.xunlei.sdk.test.cases.request.SetNotificationVisibility;
import com.xunlei.sdk.test.cases.request.SetTitle;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class RequestRunner extends InstrumentationTestRunner{

	public TestSuite getTestSuite(){
		TestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(AddRequestHeader.class);
		suite.addTestSuite(AllowScanningByMediaScanner.class);
		suite.addTestSuite(SetAllowedNetworkTypes.class);
		suite.addTestSuite(SetAllowedOverRoaming.class);
		suite.addTestSuite(SetDescription.class);
		suite.addTestSuite(SetDestinationInExternalFilesDir.class);
		suite.addTestSuite(SetDestinationInExternalPublicDir.class);
		suite.addTestSuite(SetDestinationUri.class);
		suite.addTestSuite(SetDownloadDelay.class);
		suite.addTestSuite(SetMimeType.class);
		suite.addTestSuite(SetNotificationVisibility.class);
		suite.addTestSuite(SetTitle.class);
		return suite;
	}
	
	public ClassLoader getLoader(){
		return RequestRunner.class.getClassLoader();
	}
}
