package org.example.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.logic.LoggerImpl;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;

import java.time.LocalTime;
import java.util.Optional;

public class NonFunctional {
    private Logic myLogic;
    private static final int SIZE = 10;
    private Optional<Integer> myReturnedValue;
    private long duration = 0;
    @Given("An empty board.")
    public void anEmptyBoard() {
       this.myLogic =  new LogicImpl(SIZE, new LoggerImpl());
    }

    @When("The user hits a random positions in the board:")
    public void theUserHitsARandomPositionsInTheBoard(final String board) {
        final long currentTime = System.currentTimeMillis();
        this.myLogic.hit(null);
    }


}
