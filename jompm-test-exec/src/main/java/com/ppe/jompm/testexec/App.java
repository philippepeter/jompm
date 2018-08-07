package com.ppe.jompm.testexec;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class App {

    public static void main(String[] args) {
        log.info("Starting process...");

        int timeInSeconds = 60;

        if (args != null && args.length > 0) {
            log.info("Use param: {} seconds", args[0]);
            timeInSeconds = Integer.parseInt(args[0]);
        } else {
            log.info("No args use the default timer of 60 seconds. Use an integer argument for a custom timer in second.");
        }

        long time = System.currentTimeMillis();
        long delta;

        while ((delta = System.currentTimeMillis() - time) < timeInSeconds * 1000) {
            int done = Math.round(delta / (float) (timeInSeconds * 1000) * 100);
            log.info("Process done = {}%", done);
            writeToFile(done);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("", e);
            }


        }
        writeToFile(100);
        log.info("Process done = 100%");
        log.info("done");


    }

    private static void writeToFile(int done) {
        try {
            Files.write(Paths.get("status.data"), (done + "").getBytes());
        } catch (IOException e) {
            log.error("",e);
        }
    }

}
