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
public class DeleteSteps {

    private Tree tree;
    private Node root;
    int[] values;

    @Given("^list of tree numbers")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @When("^tree created")
    public void insertValues() {
        this.tree = new Tree(this.values);
        this.root = tree.getRoot();
    }

    @Then("^tree must remain the same after deleting nonexistent node")
    public void equalTreeAfterDeletingNonexistentNode() {
        Tree treeTest = tree.clone();
        tree.delete(20);
        Assert.assertTrue(Tree.equals(root, treeTest.getRoot()),
                "After deleting the element, the tree must remain the same");
    }

    @And("^after deleting node 9, the node 10 becomes the root")
    public void deletingTheRoot() {
        tree.delete(9);
        Assert.assertEquals(root.getData(), 10,
                "The root must be 10");
    }

    @And("^after deleting node 19, the right son of the node 16 must become null")
    public void deletingRightSon() {
        tree.delete(19);
        Assert.assertEquals(tree.find(root, 16).getRight(), null,
                "The right son of the node 16 must be null");
    }

    @And("^after deleting node 4, the right son of the node 6 must become null")
    public void deletingLeftSon() {
        tree.delete(4);
        Assert.assertEquals(tree.find(root, 6).getLeft(), null,
                "The left son of the node 6 must be null");
    }
}
