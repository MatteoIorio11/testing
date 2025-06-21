package org.example.integration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.logic.LoggerImpl;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.logic.MyLogger;
import org.example.utils.Position;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

public class StepLogic {
    private Logic logic;
    private Optional<Integer> lastOutput;
    private Position lastHit;
    final MyLogger logger = new LoggerImpl();

    public StepLogic() {
        this.logic = new LogicImpl(10, logger);
    }

    private void clearAndCreate() {
        this.logic = new LogicImpl(10, logger);
    }


    @When("The user hits the position at x=0, y=0")
    @Then("The returned value should be one")
    public void theReturnedValueShouldBeOne() {
        this.clearAndCreate();
        this.lastOutput = this.logic.hit(new Position(0, 0));
        assertFalse(this.lastOutput.isEmpty());
        final int value = this.lastOutput.get();
        assertEquals(1, value);
    }

    @When("The user hits position x={int}, y={int} and x={int}, y={int}")
    public void theUserHitsPositionXYAndXY(int arg0, int arg1, int arg2, int arg3) {
        this.clearAndCreate();
        final Position position = new Position(arg0, arg1);
        final Position position2 = new Position(arg2, arg3);
        this.logic.hit(position);
        this.lastOutput = this.logic.hit(position2);
    }

    @Then("The returned value should be two")
    public void theReturnedValueShouldBeTwo() {
        System.out.println(this.lastOutput);
        if (this.lastOutput.isEmpty()) {
            fail();
        }
        final int value = this.lastOutput.get();
        assertEquals(2, value);
    }

    @Given("The board is empty")
    public void theBoardIsEmpty() {
        this.clearAndCreate();
    }

    @When("The user hits position x={int},y={int} and a neighbouring position such as x={int}, y={int}")
    public void theUserHitsPositionXYAndANeighbouringPositionSuchAsXY(int arg0, int arg1, int arg2, int arg3) {
        this.logic.hit(new Position(arg0, arg1));
        this.lastOutput = this.logic.hit(new Position(arg2, arg3));
    }

    @Then("The game is over")
    public void theGameIsOver() {
        assertTrue(this.logic.isOver());
    }

    @When("The user hits two positions which are neighbouring and not at the boarder such as x={int}, y={int} and x={int}, y={int}")
    public void theUserHitsTwoPositionsWhichAreNeighbouringAndNotAtTheBoarderSuchAsXYAndXY(int arg0, int arg1, int arg2, int arg3) {
        this.logic.hit(new Position(arg0, arg1));
        this.lastOutput = this.logic.hit(new Position(arg2, arg3));
    }

    @Then("The hitted positions start moving")
    public void theHittedPositionsStartMoving() {
        assertTrue(this.lastOutput.isEmpty());
    }

    @When("The user hits a random cell at x={int}, y={int}")
    public void theUserHitsARandomCellAtXY(int arg0, int arg1) {
        this.lastHit = new Position(arg0, arg1);
        this.logic.hit(this.lastHit);
    }

    @Then("all {int} adjacent cells are identified as neighbors")
    public void allAdjacentCellsAreIdentifiedAsNeighbors(int arg0) {
        final List<Position> directions = List.of(new Position(0, 0), new Position(0, 1),
                new Position(1, 0), new Position(1, 1), new Position(0, -1), new Position(1, -1),
                new Position(-1, 0), new Position(-1, 1));
        assertTrue(directions.stream().allMatch(direction ->
                        this.logic.areNeighbours(new Position(this.lastHit.x() + direction.x(),
                                this.lastHit.y() + direction.y()), this.lastHit)));
    }
}
