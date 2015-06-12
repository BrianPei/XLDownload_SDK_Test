package com.xunlei.sdk.test.suites;

import android.test.AndroidTestCase;

import com.xunlei.sdk.test.cases.manager.*;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by Brian on 15/6/9.
 */
public class ManagerTests extends AndroidTestCase {

    public static Test suite() {
        TestSuite managerSuite = new TestSuite(ManagerTests.class.getName());
        //$JUnit-BEGIN$
        managerSuite.addTestSuite(AddCompletedDownload.class);
        managerSuite.addTestSuite(Enqueue.class);
        managerSuite.addTestSuite(GetDownloadUri.class);
        managerSuite.addTestSuite(GetMaxBytesOverMobile.class);
        managerSuite.addTestSuite(GetMimeTypeForDownloadedFile.class);
        managerSuite.addTestSuite(GetReason.class);
        managerSuite.addTestSuite(GetRecommendedMaxBytesOverMobile.class);
        managerSuite.addTestSuite(GetUriForDownloadedFile.class);
        managerSuite.addTestSuite(MarkRowDeleted.class);
        managerSuite.addTestSuite(PauseDownload.class);
        managerSuite.addTestSuite(Query.class);
        managerSuite.addTestSuite(Remove.class);
        managerSuite.addTestSuite(RestartDownload.class);
        managerSuite.addTestSuite(ResumeDownload.class);
        managerSuite.addTestSuite(TranslateStatus.class);
        //$JUnit-END$
        return managerSuite;
    }
}
