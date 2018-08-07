package com.ppe.jompm;


import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class JOMPMTest {

    private static final String TEST_FOLDER = "test-folder";

    @Test
    public void test1Kill() {
        JOMPM jompm = new JOMPM(new File(TEST_FOLDER));

        String path = new File("src/test/resources").getAbsolutePath();
        jompm.launchTask("Task1Id", Arrays.asList("java", "-jar", path + File.separator + "jompm-test-exec-1.0-SNAPSHOT.jar"));


    }


}
