package org.example.integration;

import org.example.GUI;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.logic.MyLogger;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;

public class TestLogicGui {
    private final static int SIZE = 10;
    private GUI gui;
    private final MyLogger mockLogger = Mockito.mock(MyLogger.class);
    private final Logic spyLogic = Mockito.spy(new LogicImpl(SIZE, mockLogger));
    @BeforeEach
    public void setUp() {
        gui = new GUI(SIZE);
        gui.setVisible(false);
        doNothing().when(mockLogger).info(anyString());
        doNothing().when(mockLogger).error(anyString());
    }

}
