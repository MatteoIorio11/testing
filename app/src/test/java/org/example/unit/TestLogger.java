package org.example.unit;

import jdk.jfr.Description;
import org.example.logic.LoggerImpl;
import org.example.logic.MyLogger;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class TestLogger {
    private final static String TEST = "TEST";
    private final MyLogger myLogger;
    private final PrintStream myOutPrintStream;
    private final ByteArrayOutputStream myOutByteArrayOutputStream;

    public TestLogger() {
        this.myLogger = new LoggerImpl();
        this.myOutByteArrayOutputStream = new ByteArrayOutputStream();
        this.myOutPrintStream = System.out;
    }

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(this.myOutByteArrayOutputStream));
    }

    @Test
    @Description("The info message should be printend on the standard output console.")
    public void testInfoOnStandardOutput() {
        this.myLogger.info(TEST);
        assertTrue(this.myOutByteArrayOutputStream.toString().contains(TEST));
    }

    @After
    public void restoreStreams() {
        System.setOut(this.myOutPrintStream);
    }


}
