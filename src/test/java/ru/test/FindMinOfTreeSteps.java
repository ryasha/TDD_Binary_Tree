package ru.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

/**
 * Created by ryasha on 25.03.17.
 */
public class FindMinOfTreeSteps {

    private Tree tree;
    int[] values;

    @Given("^list of node values")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @When("^all nodes created")
    public void createNodes() {
        this.tree = new Tree(this.values);
    }

    @Then("^min node must be '(\\d*)'")
    public void findMin(int minValue) {
        Assert.assertEquals(tree.findMin(tree.getRoot()).getData(), minValue,
                "The min node must be " + minValue);
    }
}
