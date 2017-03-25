package ru.test;

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

    public Tree() {
        this.root = null;
    }

    public Tree(int[] values) {
        for(int value : values) {
            insert(value);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node current, int data) {
        if (current == null) {
            current = new Node(data);
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

    private Node delete(Node startNode, int data) {
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

    public static List<Integer> traverseTree(Node current, TraverseType traverseType) {
        List<Integer> nodeVal = new ArrayList<>();
        if (current == null)
            return nodeVal;
        switch (traverseType) {
            case INORDER:
                nodeVal.addAll(traverseTree(current.getLeft(), traverseType));
                nodeVal.add(current.getData());
                nodeVal.addAll(traverseTree(current.getRight(), traverseType));
                break;
            case PREORDER:
                nodeVal.add(current.getData());
                nodeVal.addAll(traverseTree(current.getLeft(), traverseType));
                nodeVal.addAll(traverseTree(current.getRight(), traverseType));
                break;
            case POSTORDER:
                nodeVal.addAll(traverseTree(current.getLeft(), traverseType));
                nodeVal.addAll(traverseTree(current.getRight(), traverseType));
                nodeVal.add(current.getData());
                break;
        }
        return nodeVal;
    }

    public static boolean equals(Node root1, Node root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (!root1.equals(root2))
            return false;

        List<Integer> tree1 = Tree.traverseTree(root1, TraverseType.INORDER);
        List<Integer> tree2 = Tree.traverseTree(root2, TraverseType.INORDER);

        return tree1.equals(tree2);
    }

    public Tree clone() {
        if(this.root == null)
            return null;
        Tree tree = new Tree();
        tree.setRoot(this.root.clone());
        return tree;
    }
}