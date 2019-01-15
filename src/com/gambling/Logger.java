package com.gambling;

import java.time.Instant;

public class Logger {

    /* It writes information to the console. Only this class can contain calls to System.out.println().

    It has the following method:

    log(String type, String message) it writes to the console in a formatted way. E.g. TimeStamp Type Message
    type should be something like "INFO" or "ERROR" depending on what you want to display. */
    public Logger() {

    }

    public void log(String type, String message) {
        Instant timestamp = Instant.now();
        System.out.println(timestamp + " " + type + " " + message);
    }

}