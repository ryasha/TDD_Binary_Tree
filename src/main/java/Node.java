import lombok.Data;

/**
 * Created by ryasha on 07.03.17.
 */
@Data
public class Node {
    private int data;
    private Node left;
    private Node right;
    private Node parent;

    @Override
    public String toString() {
        return "Data: " + this.data + ";";
    }
}
