package org.example.logic;

import org.example.utils.Position;

import java.util.Optional;

public interface Logic {

    Optional<Integer> hit(Position position);

    Optional<Integer> getMark(Position position);

    boolean isOver();
}
