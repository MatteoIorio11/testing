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


    public StepLogic() {
    }


    @Given("The board is empty")
    @When("The user hits the position at x=0, y=0")
    @Then("The returned value should be one")
    public void theReturnedValueShouldBeOne() {
        final MyLogger logger = new LoggerImpl();
        final Logic logic = new LogicImpl(10, logger);
        final Optional<Integer> output = logic.hit(new Position(0, 0));
        assertFalse(output.isEmpty());
        final int value = output.get();
        assertEquals(1, value);
    }
}
