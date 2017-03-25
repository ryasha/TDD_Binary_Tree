package ru.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckOfAllNodesSteps {

    private Tree tree;
    private Node root;
    int[] values;

    @Given("^list of values")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @When("^values are inserted")
    public void insertValues() {
        this.tree = new Tree(this.values);
        this.root = tree.getRoot();
    }

    @Then("^check all left sons")
    public void checkLeftSons(Map<Integer, Integer> values) {
        for (Map.Entry<Integer, Integer> pair : values.entrySet()) {
            Assert.assertEquals(tree.find(root, pair.getKey()).getLeft().getData(), Math.toIntExact(pair.getValue()),
                    "The left son of node " + pair.getKey() + " must be " + pair.getValue());
        }
    }

    @And("^check all right sons")
    public void checkRightSons(Map<Integer, Integer> values) {
        for (Map.Entry<Integer, Integer> pair : values.entrySet()) {
            Assert.assertEquals(tree.find(root, pair.getKey()).getRight().getData(), Math.toIntExact(pair.getValue()),
                    "The right son of node " + pair.getKey() + " must be " + pair.getValue());
        }
    }

    /*@Then("^the left son of root must be '(\\d*)'")
    public void leftSonOfRoot(int value) {
        Assert.assertEquals(root.getLeft().getData(), value,
                "The left son of the root must be " + value);
    }

    @Then("^the left son of node 6 must be '(\\d*)'")
    public void leftSonOfSix(int value) {
        Assert.assertEquals(tree.find(root, 6).getLeft().getData(), value,
                "The left son of the node 6 must be " + value);
    }

    @Then("^the right son of node 6 must be '(\\d*)'")
    public void rightSonOfSix(int value) {
        Assert.assertEquals(tree.find(root, 6).getRight().getData(), value,
                "The right son of the node 6 must be " + value);
    }

    @Then("^the right son of root must be '(\\d*)'")
    public void rightSonOfRoot(int value) {
        Assert.assertEquals(root.getRight().getData(), value,
                "The right son of the root must be 16");
    }

    @Then("^the left son of node 16 must be '(\\d*)'")
    public void leftSonOfSixteen(int value) {
        Assert.assertEquals(tree.find(root, 16).getLeft().getData(), value,
                "The left son of the node 6 must be " + value);
    }

    @Then("^the right son of node 16 must be '(\\d*)'")
    public void rightSonOfSixeen(int value) {
        Assert.assertEquals(tree.find(root, 16).getRight().getData(), value,
                "The right son of the node 6 must be " + value);
    }*/
}
