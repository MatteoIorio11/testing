package org.example.logic;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerImpl implements MyLogger {
    @Override
    public void info(String message) {
        System.out.println("INFO: " + message);
    }

    @Override
    public void error(String message) {
        System.err.println("ERROR: " + message);
    }
}
