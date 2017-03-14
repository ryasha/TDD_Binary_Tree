import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryasha on 14.03.17.
 */
public class TreeTest {
    Tree tree = new Tree();

    @Before
    public void insertMassiveOfValues() {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};
        tree = new Tree(values);
    }

    @Test
    public void checkOfAllNodes() {
        Assert.assertEquals("The root must be 9",
                9, tree.getRoot() == null ? -1 : tree.getRoot().getData());
        Assert.assertEquals("The left son of the root must be 6",
                6, tree.getRoot() == null ? -1 : tree.getRoot().getLeft().getData());
        Assert.assertEquals("The left son of the node 6 must be 4",
                4, tree.find(6) == null ? -1 : tree.find(6).getLeft().getData());
        Assert.assertEquals("The right son of the node 6 must be 7",
                7, tree.find(6) == null ? -1 : tree.find(6).getRight().getData());

        Assert.assertEquals("The right son of the root must be 16",
                16, tree.getRoot() == null ? -1 : tree.getRoot().getRight().getData());
        Assert.assertEquals("The left son of the node 16 must be 10",
                10, tree.find(16) == null ? -1 : tree.find(16).getLeft().getData());
        Assert.assertEquals("The left son of the node 16 must be 19",
                19, tree.find(16) == null ? -1 : tree.find(16).getRight().getData());
    }

    @Test
    public void findMinOfTree() {
        Assert.assertEquals("The min node must be 4",
                4, tree.getRoot() == null ? -1 : tree.findMin(tree.getRoot()).getData());
    }

    @Test
    public void deletingTest() {
        tree.delete(9);
        Assert.assertEquals("The root must be 10",
                10, tree.getRoot() == null ? -1 : tree.getRoot().getData());

        tree.delete(19);
        Assert.assertEquals("The left son of the node 16 must be null",
                null, tree.find(16) == null ? -1 : tree.find(16).getRight());

        tree.delete(4);
        Assert.assertEquals("The left son of the node 6 must be null",
                null, tree.find(6) == null ? -1 : tree.find(16).getRight());
    }
}
