package org.example.integration;

import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.utils.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

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

    @Test
    public void testHitANeighbourPosition() {
        final Position pos1 = Mockito.mock(Position.class);
        final Position pos2 = Mockito.mock(Position.class);
        when(pos1.x()).thenReturn(1);
        when(pos1.y()).thenReturn(1);
        assertFalse(logic.hit(pos1).isEmpty());
        when(pos2.x()).thenReturn(2);
        when(pos2.y()).thenReturn(2);
        assertTrue(logic.hit(pos2).isEmpty());
    }

    @Test
    public void testIsOver() {
        final Position pos1 = Mockito.mock(Position.class);
        final Position pos2 = Mockito.mock(Position.class);
        when(pos1.x()).thenReturn(0);
        when(pos1.y()).thenReturn(0);
        when(pos2.x()).thenReturn(1);
        when(pos2.y()).thenReturn(1);
        assertFalse(logic.hit(pos1).isEmpty());
        assertTrue(logic.hit(pos2).isEmpty());
        assertTrue(logic.isOver());
    }

    @Test
    public void testPrivateNeighbours() {
        final Position pos1 = Mockito.mock(Position.class);
        final Position pos2 = Mockito.mock(Position.class);
        when(pos1.x()).thenReturn(0);
        when(pos1.y()).thenReturn(0);
        when(pos2.x()).thenReturn(1);
        when(pos2.y()).thenReturn(1);
        assertTrue(logic.areNeighbours(pos1, pos2));
    }
}
