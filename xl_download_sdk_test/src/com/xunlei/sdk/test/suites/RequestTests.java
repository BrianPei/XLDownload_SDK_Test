package com.xunlei.sdk.test.suites;

import android.test.AndroidTestCase;

import com.xunlei.sdk.test.cases.request.*;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by Brian on 15/6/9.
 */
public class RequestTests extends AndroidTestCase {

    public static Test suite() {
        TestSuite requestSuite = new TestSuite(RequestTests.class.getName());
        //$JUnit-BEGIN$
        requestSuite.addTestSuite(AddRequestHeader.class);
        requestSuite.addTestSuite(AllowScanningByMediaScanner.class);
        requestSuite.addTestSuite(SetAllowedNetworkTypes.class);
        requestSuite.addTestSuite(SetAllowedOverRoaming.class);
        requestSuite.addTestSuite(SetDescription.class);
        requestSuite.addTestSuite(SetDestinationInExternalFilesDir.class);
        requestSuite.addTestSuite(SetDestinationInExternalPublicDir.class);
        requestSuite.addTestSuite(SetDestinationUri.class);
        requestSuite.addTestSuite(SetDownloadDelay.class);
        requestSuite.addTestSuite(SetMimeType.class);
        requestSuite.addTestSuite(SetTitle.class);
        //$JUnit-END$
        return requestSuite;
    }
}
