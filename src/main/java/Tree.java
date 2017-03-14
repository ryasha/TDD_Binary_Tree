import lombok.Getter;

/**
 * Created by ryasha on 07.03.17.
 */
public class Tree {

    public enum TraverseType {
        INORDER,
        PREORDER,
        POSTORDER;
    }

    @Getter
    private Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(int[] values) {

    }

    public void insert(int data) {

    }

    private Node insert(Node current, int data, Node parent) {
        return null;
    }

    public Node find(int data) {
        return null;
    }

    private Node find(Node current, int data) {
        return null;
    }

    public Node findMin(Node root) {
        return null;
    }

    public void delete(int data) {

    }

    public Node delete(Node startNode, int data) {
        return null;
    }


    public void traverseTree(TraverseType traverseType) {

    }

    private void traverseTree(Node current, TraverseType traverseType) {

    }
}
