package org.example.integration;

import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.utils.Position;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class TestLogic {
    private static final int SIZE = 10;
    private final Logic logic = new LogicImpl(SIZE);

    @Test
    public void testValidHit() {
        final Position pos1 = Mockito.mock(Position.class);
        when(pos1.x()).thenReturn(1);
        when(pos1.y()).thenReturn(1);
        assertFalse(this.logic.hit(pos1).isEmpty());
    }

    @Test
    public void testMultipleValidHits() {
        final Position pos1 = Mockito.mock(Position.class);
        when(pos1.x()).thenReturn(0);
        when(pos1.y()).thenReturn(0);
        assertFalse(this.logic.hit(pos1).isEmpty());

        final Position pos2 = Mockito.mock(Position.class);
        when(pos2.x()).thenReturn(SIZE - 1);
        when(pos2.y()).thenReturn(SIZE - 1);
        assertFalse(this.logic.hit(pos2).isEmpty());

        final Position pos3 = Mockito.mock(Position.class);
        when(pos3.x()).thenReturn(SIZE / 2);
        when(pos3.y()).thenReturn(0);
        assertFalse(this.logic.hit(pos3).isEmpty());
    }

    
}
