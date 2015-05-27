package com.xunlei.sdk.test.suites;

import com.xunlei.sdk.test.cases.query.OrderBy;
import com.xunlei.sdk.test.cases.query.SetFilterById;
import com.xunlei.sdk.test.cases.query.SetFilterByStatus;

import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class QueryRunner extends InstrumentationTestRunner{

	public TestSuite getTestSuite(){
		TestSuite suite = new InstrumentationTestSuite(this);
		suite.addTestSuite(OrderBy.class);
		suite.addTestSuite(SetFilterByStatus.class);
		suite.addTestSuite(SetFilterById.class);
		return suite;
	}
	
	public ClassLoader getLoader(){
		return QueryRunner.class.getClassLoader();
	}
}
