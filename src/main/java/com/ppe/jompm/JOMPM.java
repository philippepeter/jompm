package com.ppe.jompm;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Slf4j
public class JOMPM {

    private File folder;


    public JOMPM(File folder) {
        this.folder = folder;
        if(folder.exists() == false) {
            folder.mkdirs();
        }

    }

    public void launchTask(String task1Id, List<String> commands) {
        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        processBuilder.directory(folder);
        processBuilder.redirectErrorStream(true);
        processBuilder.inheritIO();

        try {
            Process process = processBuilder.start();
            log.info(process.getClass().getSimpleName());
        } catch (IOException e) {
            log.error("",e);
        }
    }
}
