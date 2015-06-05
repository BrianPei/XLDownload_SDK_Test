package com.xunlei.sdk.test.suites;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.suitebuilder.TestSuiteBuilder;

public class DownloadRunner extends InstrumentationTestRunner {

	public TestSuite getTestSuite() {
		return new TestSuiteBuilder(DownloadRunner.class).includePackages(
				"download").build();
	}

	public ClassLoader getLoader() {
		return DownloadRunner.class.getClassLoader();
	}
}
