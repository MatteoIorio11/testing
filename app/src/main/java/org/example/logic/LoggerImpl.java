package org.example.logic;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerImpl implements MyLogger {
    private final static Logger logger = LogManager.getLogger(LoggerImpl.class);
    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }
}
