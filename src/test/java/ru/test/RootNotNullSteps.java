package ru.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by ryasha on 25.03.17.
 */
public class RootNotNullSteps {

    private Tree tree;
    int rootValue;

    @Given("^value of root '(\\d*)'")
    public void givenValue(int value) {
        this.rootValue = value;
    }

    @When("^insert this value")
    public void insertValue(){
        this.tree = new Tree();
        this.tree.insert(this.rootValue);
    }

    @Then("^root must be '(\\d*)'")
    public void checkRoot(int checkValue) {
        Assert.assertEquals(this.tree.getRoot().getData(), checkValue, "Root must be equal 9");
    }
}
