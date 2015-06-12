package com.xunlei.sdk.test.suites;

import android.test.AndroidTestCase;

import com.xunlei.sdk.test.cases.query.OrderBy;
import com.xunlei.sdk.test.cases.query.SetFilterById;
import com.xunlei.sdk.test.cases.query.SetFilterByStatus;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QueryTests extends AndroidTestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(QueryTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(OrderBy.class);
		suite.addTestSuite(SetFilterById.class);
		suite.addTestSuite(SetFilterByStatus.class);
		//$JUnit-END$
		return suite;
	}

}
