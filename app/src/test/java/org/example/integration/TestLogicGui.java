package org.example.integration;

import org.example.GUI;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.logic.MyLogger;
import org.example.utils.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TestLogicGui {
    private final static int SIZE = 10;
    private static GUI gui;
    private static final MyLogger mockLogger = Mockito.mock(MyLogger.class);
    private static final Logic spyLogic = Mockito.spy(new LogicImpl(SIZE, mockLogger));

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException {
        gui = new GUI(SIZE);
        gui.setVisible(false);
        doNothing().when(mockLogger).info(anyString());
        doNothing().when(mockLogger).error(anyString());
        replaceLogic();
    }

    @Test
    public void testWhenButtonPressLogicHits() {
        try {
            final Map<JButton, Position> cells = this.getGUICells();
            final JButton button = cells.keySet().iterator().next();
            final Position position = cells.get(button);
            button.doClick();
            verify(spyLogic, times(1)).hit(position);
            verify(spyLogic, atLeast(1)).isOver();
        }catch (Exception e) {
            fail();
        }
    }

    @SuppressWarnings("unchecked")
    private Map<JButton, Position> getGUICells() throws NoSuchFieldException, IllegalAccessException {
        final Field field = gui.getClass().getDeclaredField("cells");
        field.setAccessible(true);
        return (Map<JButton, Position>) field.get(gui);
    }

    private void replaceLogic() throws NoSuchFieldException, IllegalAccessException {
        final Field field = gui.getClass().getDeclaredField("logic");
        field.setAccessible(true);
        field.set(gui, spyLogic);
    }

}
