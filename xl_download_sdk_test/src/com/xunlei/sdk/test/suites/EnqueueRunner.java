package com.xunlei.sdk.test.suites;

import com.xunlei.sdk.test.cases.enqueue.FileTypeTest;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class EnqueueRunner extends InstrumentationTestRunner{

	public TestSuite getTestSuite(){
		TestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(FileTypeTest.class);
		return suite;
	}
	
	public ClassLoader getLoader(){
		return EnqueueRunner.class.getClassLoader();
	}
}
