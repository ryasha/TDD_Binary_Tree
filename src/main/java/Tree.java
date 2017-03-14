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
        for(int value : values) {
            insert(value);
        }
    }

    public void insert(int data) {
        root = insert(root, data, null);
    }

    private Node insert(Node current, int data, Node parent) {
        if (current == null) {
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
            current.setParent(parent);
        } else if (data < current.getData()) {
            current.setLeft(insert(current.getLeft(), data, current));
        } else {
            current.setRight(insert(current.getRight(), data, current));
        }
        return current;
    }

    public Node find(int data) {
        return find(root, data);
    }

    private Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.getData() == data)
            return current;
        return find(
                data < current.getData() ? current.getLeft()
                        : current.getRight(), data);
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


    public void traverseTree(TraverseType traverseType) {
        traverseTree(root, traverseType);
        System.out.println();
    }

    private void traverseTree(Node current, TraverseType traverseType) {
        if (current == null)
            return;
        switch (traverseType) {
            case INORDER:
                traverseTree(current.getLeft(), traverseType);
                System.out.println(current.getData() + " ");
                traverseTree(current.getRight(), traverseType);
                break;
            case PREORDER:
                System.out.println(current.getData() + " ");
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                break;
            case POSTORDER:
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                System.out.println(current.getData() + " ");
                break;
        }
    }
}
