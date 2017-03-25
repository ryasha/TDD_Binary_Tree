package ru.test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

/**
 * Created by ryasha on 25.03.17.
 */
public class CloneSteps {

    private Tree tree;
    private Node root;
    int[] values;

    @Given("^list of numbers")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @When("^tree is filled")
    public void insertValues() {
        this.tree = new Tree(this.values);
        this.root = tree.getRoot();
    }

    @Then("^the original tree and its clone must be equal")
    public void equalsTest() {
        Tree treeClone = tree.clone();

        Assert.assertTrue(Tree.equals(tree.getRoot(), treeClone.getRoot()),
                "Trees must be equal");
    }
}
