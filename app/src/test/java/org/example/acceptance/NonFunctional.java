package org.example.acceptance;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.acceptance.util.Parser;
import org.example.logic.LoggerImpl;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.utils.Position;

import java.time.LocalTime;
import java.util.Optional;

import static org.junit.Assert.fail;

public class NonFunctional {
    private Logic myLogic;
    private static final int SIZE = 10;
    private Optional<Integer> myReturnedValue;
    private long elapsedTime = 0;
    private Position myLastHit;
    @Given("An empty board.")
    public void anEmptyBoard() {
       this.myLogic =  new LogicImpl(SIZE, new LoggerImpl());
    }

    @When("The user hits a random positions in the board:")
    public void theUserHitsARandomPositionsInTheBoard(final String board) {
        this.myLastHit = Parser.parseBoard(board, (logic, position) -> {
            final long currentTime = System.currentTimeMillis();
            logic.hit(position);
            this.elapsedTime = System.currentTimeMillis() - currentTime;
        }, this.myLogic);
    }


    @Then("The returned value should be returned in under {int} seconds.")
    public void theReturnedValueShouldBeReturnedInUnderSeconds(final int time) {
        if (time > 0 && (this.elapsedTime / 1000) > time) {
            fail();
        }
    }

    @When("The user hits a random positions in the board and asks for its mark:")
    public void theUserHitsARandomPositionsInTheBoardAndAsksForItsMark(final String board) {
        this.myLastHit = Parser.parseBoard(board, Logic::hit, this.myLogic);
        final long currentTime = System.currentTimeMillis();
        this.myLogic.getMark(this.myLastHit);
        this.elapsedTime = System.currentTimeMillis() - currentTime;
    }

    @And("Cheks if two positions are neighbours")
    public void cheksIfTwoPositionsAreNeighbours() {
        final Position other = new Position(0, 0);
        final long currentTime = System.currentTimeMillis();
        this.myLogic.areNeighbours(this.myLastHit, other);
        this.elapsedTime = System.currentTimeMillis() - currentTime;
    }
}
