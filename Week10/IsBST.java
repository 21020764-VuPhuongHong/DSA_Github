import java.util.ArrayList;
import java.util.List;

public class IsBST {
    public void inOrder(Node root, List<Integer> trav) {
        if (root == null) {
            return;
        }
        inOrder(root.left, trav);
        trav.add(root.data);
        inOrder(root.right, trav);
    }

    public boolean checkBST(Node root) {
        if (root == null) {
            return true;
        }
        List<Integer> inOrderedTrav = new ArrayList<>();
        inOrder(root, inOrderedTrav);
        for (int i = 0; i < inOrderedTrav.size() - 1; i++) {
            if (inOrderedTrav.get(i) >= inOrderedTrav.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
