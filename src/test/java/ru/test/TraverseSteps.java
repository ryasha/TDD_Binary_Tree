package ru.test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class TraverseSteps {

    private Tree tree;
    private Node root;
    int[] values;

    List<Integer> inOrderList;
    List<Integer> preOrderList;
    List<Integer> postOrderList;

    @Given("^list of data")
    public void givenArrayOfValues(List<Integer> listValues) {
        this.values = listValues.stream().mapToInt(i -> i).toArray();
    }

    @Given("^list for checking inOrder type")
    public void listForInorder(List<Integer> list) {
        inOrderList = list;
    }

    @Given("^list for checking preOrder type")
    public void listForPreOrder(List<Integer> list) {
        preOrderList = list;
    }

    @Given("^list for checking postOrder type")
    public void listForPostOrder(List<Integer> list) {
        postOrderList = list;
    }

    @When("^nodes are inserted")
    public void insertValues() {
        this.tree = new Tree(this.values);
        this.root = tree.getRoot();
    }

    @Then("^check inOrder type of traverse")
    public void checkInOrder() {
        List<Integer> inOrderCheck = Tree.traverseTree(root, Tree.TraverseType.INORDER);
        Assert.assertEquals(inOrderCheck, inOrderList, "InOrder lists must be equal");
    }

    @And("^check preOrder type of traverse")
    public void checkPreOrder() {
        List<Integer> preOrderCheck = Tree.traverseTree(root, Tree.TraverseType.PREORDER);
        Assert.assertEquals(preOrderCheck, preOrderList, "PreOrder lists must be equal");
    }

    @And("^check postOrder type of traverse")
    public void checkPostOrder() {
        List<Integer> postOrderCheck = Tree.traverseTree(root, Tree.TraverseType.POSTORDER);
        Assert.assertEquals(postOrderCheck, postOrderList, "PostOrder lists must be equal");
    }
}
