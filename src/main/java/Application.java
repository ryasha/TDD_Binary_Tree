/**
 * Created by ryasha on 07.03.17.
 */
public class Application {

    public static void main(String[] args) {
        int[] values = new int [] {9, 6, 16, 4, 10, 7, 19};

        Tree tree = new Tree(values);
        if (tree.getRoot().getData() == 9)
            System.out.println("Insert: success");
        else {
            System.out.println("Insert: failure");
            return;
        }

        System.out.println("Deleting root (node \"9\"):");
        tree.delete(9);
        if (tree.getRoot().getData() == 10)
            System.out.println("Deleting node \"9\": success");
        else {
            System.out.println("Deleting node \"9\": failure");
            return;
        }

        System.out.println("Deleting root (node \"19\"):");
        tree.delete(19);
        if (tree.find(16).getRight() == null)
            System.out.println("Deleting node \"19\": success");
        else {
            System.out.println("Deleting node \"19\": failure");
            return;
        }

        System.out.println("Deleting root (node \"4\"):");
        tree.delete(4);
        if (tree.find(6).getLeft() == null)
            System.out.println("Deleting node \"4\": success");
        else {
            System.out.println("Deleting node \"4\": failure");
            return;
        }

        System.out.println("All tests are completed");
    }
}
