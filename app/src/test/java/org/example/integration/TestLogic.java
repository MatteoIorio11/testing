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

    
}
