package org.example.integration;

import org.example.logic.LoggerImpl;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.logic.MyLogger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TestLogicLogger {
    private static final int SIZE = 10;
    private static Logic logic;
    final MyLogger logger = Mockito.spy(LoggerImpl.class);

    @Before
    public void initLogic() {
        logic = new LogicImpl(SIZE, logger);
    }

    @Test
    public void testIsOverPrintsLog() {
        assertFalse(logic.isOver());
        verify(logger, times(1)).info("Check if the game is over");
    }

    @Test
    public void testHitPrintsLogs() {
        final var pos1 = Mockito.mock(org.example.utils.Position.class);
        when(pos1.x()).thenReturn(1);
        when(pos1.y()).thenReturn(1);
        assertFalse(logic.hit(pos1).isEmpty());
        verify(logger, atLeast(2)).info(anyString());
        verify(logger, times(1)).info("Hit at position: " + pos1);
        verify(logger, times(1)).info("Check if the game is over");
    }

    @Test
    public void testGetMarkPrintsLog() {
        final var pos1 = Mockito.mock(org.example.utils.Position.class);
        when(pos1.x()).thenReturn(1);
        when(pos1.y()).thenReturn(1);
        assertTrue(logic.getMark(pos1).isEmpty());
        verify(logger, times(1)).info("Get mark for position: " + pos1);
    }
}
