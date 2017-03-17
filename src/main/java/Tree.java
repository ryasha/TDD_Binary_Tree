import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryasha on 07.03.17.
 */
public class Tree implements Cloneable {

    public enum TraverseType {
        INORDER,
        PREORDER,
        POSTORDER
    }

    @Getter
    @Setter
    private Node root;

    Tree() {
        this.root = null;
    }

    Tree(int[] values) {
        for(int value : values) {
            insert(value);
        }
    }

    void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
        } else if (data < current.getData()) {
            current.setLeft(insert(current.getLeft(), data));
        } else {
            current.setRight(insert(current.getRight(), data));
        }
        return current;
    }

    public Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.getData() == data)
            return current;
        return find(data < current.getData() ?
                current.getLeft() : current.getRight(), data);
    }

    public Node findMin(Node root) {
        Node min = root;
        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    public Node delete(Node startNode, int data) {
        Node root = startNode;

        if (root == null)
            return root;
        if (data < root.getData()) {
            root.setLeft(delete(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(delete(root.getRight(), data));
        } else if ((root.getLeft() != null) && (root.getRight() != null)) {
            root.setData(findMin(root.getRight()).getData());
            root.setRight(delete(root.getRight(), root.getData()));
        } else {
            if (root.getLeft() != null) {
                root = root.getLeft();
            } else root = root.getRight();
        }

        return root;
    }

    void traverseTree(Node current, TraverseType traverseType) {
        if (current == null)
            return;
        switch (traverseType) {
            case INORDER:
                traverseTree(current.getLeft(), traverseType);
                System.out.println(current.getData());
                traverseTree(current.getRight(), traverseType);
                break;
            case PREORDER:
                System.out.println(current.getData());
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                break;
            case POSTORDER:
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                System.out.println(current.getData());
                break;
        }
    }

    public static boolean equals(Node root1, Node root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (!root1.equals(root2))
            return false;

        if (!equals(root1.getLeft(), root2.getLeft()))
            return false;
        if (!equals(root1.getRight(), root2.getRight()))
            return false;
        return true;
    }

    protected Tree clone() {
        if(this.root == null)
            return null;
        Tree tree = new Tree();
        tree.setRoot(this.root.clone());
        return tree;
    }
}
    /*void traverseTree(Node current, TraverseType traverseType) {
        if (current == null)
            return;
        switch (traverseType) {
            case INORDER:
                traverseTree(current.getLeft(), traverseType);
                System.out.println(current.getData());
                traverseTree(current.getRight(), traverseType);
                break;
            case PREORDER:
                System.out.println(current.getData());
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                break;
            case POSTORDER:
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                System.out.println(current.getData());
                break;
        }
    }*/