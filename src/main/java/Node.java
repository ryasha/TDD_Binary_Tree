import lombok.Data;

/**
 * Created by ryasha on 07.03.17.
 */
@Data
public class Node implements Cloneable {
    private int data;
    private Node left;
    private Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    boolean equals(Node node) {
        return this.data == node.getData();
    }

    protected Node clone() {
        Node node = new Node(this.data);
        if(this.left != null)
            node.setLeft(this.left.clone());
        else
            node.setLeft(null);
        if(this.right != null)
            node.setRight(this.right.clone());
        else
            node.setRight(null);
        return node;
    }

    @Override
    public String toString() {
        return "Data: " + this.data + ";";
    }
}
