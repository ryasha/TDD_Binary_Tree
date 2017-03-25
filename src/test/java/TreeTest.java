import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ru.test.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryasha on 14.03.17.
 */
public class TreeTest {

    @Test
    public void rootNotNullTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        Assert.assertFalse(tree.getRoot() == null, "The root must not be null");
    }

    @Test(dependsOnMethods = {"rootNotNullTest"})
    public void checkOfAllNodesTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        Assert.assertEquals(tree.getRoot().getData(), 9, "The root must be 9");
        Assert.assertEquals(tree.getRoot().getLeft().getData(), 6,
                "The left son of the root must be 6");
        Assert.assertEquals(tree.find(tree.getRoot(), 6).getLeft().getData(), 4,
                "The left son of the node 6 must be 4");
        Assert.assertEquals(tree.find(tree.getRoot(), 6).getRight().getData(), 7,
                "The right son of the node 6 must be 7");

        Assert.assertEquals(tree.getRoot().getRight().getData(), 16,
                "The right son of the root must be 16");
        Assert.assertEquals(tree.find(tree.getRoot(), 16).getLeft().getData(), 10,
                "The left son of the node 16 must be 10");
        Assert.assertEquals(tree.find(tree.getRoot(), 16).getRight().getData(), 19,
                "The right son of the node 16 must be 19");

        Reporter.log("Test checkOfAllNodes complete");
    }

    @Test(dependsOnMethods = {"rootNotNullTest"})
    public void findMinOfTreeTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        Assert.assertEquals(4, tree.findMin(tree.getRoot()).getData(),
                "The min node must be 4");

        Reporter.log("Test findMinOfTree complete");
    }

    @Test(dependsOnMethods = {"rootNotNullTest"})
    public void traverseTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        List<Integer> inorderList = new ArrayList<>(Arrays.asList(4, 6, 7, 9, 10, 16, 19));
        List<Integer> preorderList = new ArrayList<>(Arrays.asList(9, 6, 4, 7, 16, 10, 19));
        List<Integer> postorderList = new ArrayList<>(Arrays.asList(4, 7, 6, 10, 19, 16, 9));

        List<Integer> inorderCheck = Tree.traverseTree(tree.getRoot(), Tree.TraverseType.INORDER);
        Assert.assertEquals(inorderCheck, inorderList, "Inorder lists must be equal");

        List<Integer> preorderCheck = Tree.traverseTree(tree.getRoot(), Tree.TraverseType.PREORDER);
        Assert.assertEquals(preorderCheck, preorderList, "Preorder lists must be equal");

        List<Integer> postorderCheck = Tree.traverseTree(tree.getRoot(), Tree.TraverseType.POSTORDER);
        Assert.assertEquals(postorderCheck, postorderList, "Postorder lists must be equal");

        Reporter.log("Test traverseTest complete");
    }

    @Test(dependsOnMethods = {"rootNotNullTest", "traverseTest"})
    public void equalsTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree1 = new Tree(values);

        Tree tree2 = tree1;

        Assert.assertTrue(Tree.equals(tree1.getRoot(), tree2.getRoot()),
                "Trees must be equal by reference");

        tree2 = new Tree();
        Assert.assertFalse(Tree.equals(tree1.getRoot(), tree2.getRoot()),
                "Trees must not be equal because the second tree does not exist");

        tree2.insert(8);
        Assert.assertFalse(Tree.equals(tree1.getRoot(), tree2.getRoot()),
                "Trees must not be equal by root");

        tree2 = new Tree(values);
        Assert.assertTrue(Tree.equals(tree1.getRoot(), tree2.getRoot()), "Trees must be equal");

        values[2] = 15;
        tree2 = new Tree(values);
        Assert.assertFalse(Tree.equals(tree1.getRoot(), tree2.getRoot()), "Trees must not be equal");

        Reporter.log("Test equalsTest complete");
    }

    @Test(dependsOnMethods = {"rootNotNullTest", "equalsTest"})
    public void deletingTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        Tree treeTest = tree.clone();
        tree.delete(20);
        Assert.assertTrue(Tree.equals(tree.getRoot(), treeTest.getRoot()),
                "After deleting the element, the tree must remain the same");

        tree.delete(9);
        Assert.assertEquals(tree.getRoot().getData(), 10,
                "The root must be 10");

        tree.delete(19);
        Assert.assertEquals(tree.find(tree.getRoot(), 16).getRight(), null,
                "The right son of the node 16 must be null");

        tree.delete(4);
        Assert.assertEquals(tree.find(tree.getRoot(), 6).getRight(), null,
                "The left son of the node 6 must be null");

        Reporter.log("Test deletingTest complete");
    }

    @Test(dependsOnMethods = {"rootNotNullTest", "equalsTest"})
    public void cloneTest() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        Tree tree = new Tree(values);

        Tree treeClone = tree.clone();

        Assert.assertTrue(Tree.equals(tree.getRoot(), treeClone.getRoot()),
                "Trees must be equal");

        Reporter.log("Test cloneTest complete");
    }
}