package ru.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

/**
 * Created by ryasha on 25.03.17.
 */
public class EqualsSteps {

    private Tree tree;
    private Node root;
    int[] values;

    @Given("^list of nodes")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @When("^nodes are created")
    public void insertValues() {
        this.tree = new Tree(this.values);
        this.root = tree.getRoot();
    }

    @Then("^equals must return true, when trees have same references")
    public void equalReferences() {
        Tree tree2 = tree;

        Assert.assertTrue(Tree.equals(root, tree2.getRoot()),
                "Trees must be equal by reference");
    }

    @And("^equals must return false, if the second tree does not exist")
    public void notEqualsIfTreeDoesNotExist() {
        Tree tree2 = new Tree();
        Assert.assertFalse(Tree.equals(root, tree2.getRoot()),
                "Trees must not be equal because the second tree does not exist");
    }

    @And("^equals must return false, if roots are not equal")
    public void notEqualsIfRootsNotEqual() {
        Tree tree2 = new Tree();
        tree2.insert(8);
        Assert.assertFalse(Tree.equals(root, tree2.getRoot()),
                "Trees must not be equal by root");
    }

    @And("^equals must return true, if trees have the same nodes")
    public void equalsIfSameNodes() {
        Tree tree2 = new Tree(values);
        Assert.assertTrue(Tree.equals(root, tree2.getRoot()), "Trees must be equal");
    }

    @And("^equals must return false, if trees have even one different node")
    public void notEqualsIfAnyDiffNode() {
        values[2] = 15;
        Tree tree2 = new Tree(values);
        Assert.assertFalse(Tree.equals(root, tree2.getRoot()), "Trees must not be equal");
    }
}
