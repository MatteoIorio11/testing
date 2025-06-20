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

import java.util.Optional;

public class StepLogic {
    private Logic logic;
    private Optional<Integer> lastOutput;
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
}
