package org.example.unit;

import org.example.logic.MyLogger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestLogger {
    private static MyLogger logger;

    @Before
    public void initLogger() {
        logger = Mockito.mock(MyLogger.class);
    }

}
