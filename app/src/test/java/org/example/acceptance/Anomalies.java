package org.example.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.logic.LoggerImpl;
import org.example.logic.Logic;
import org.example.logic.LogicImpl;
import org.example.logic.MyLogger;
import org.example.utils.Position;

public class Anomalies {
    private Logic myLogic;
    private final MyLogger myLogger = new LoggerImpl();

    private void initialiseLogic(final int size) {
        this.myLogic = new LogicImpl(size, myLogger);
    }
    @Given("A board with an edge of {int}.")
    public void aBoardWithAnEdgeOf(final int arg0) {
        if (arg0 > 0) {
            this.initialiseLogic(arg0);
        }
    }

    @When("The user hits a position outside from the board.")
    public void theUserHitsAPositionOutsideFromTheBoard() {
        
    }

    @Then("The system must handle this problem and avoid to save the input position.")
    public void theSystemMustHandleThisProblemAndAvoidToSaveTheInputPosition() {
    }
}
