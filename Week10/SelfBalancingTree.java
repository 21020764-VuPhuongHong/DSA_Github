public class SelfBalancingTree {
    private static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        Node() {

        }
    }

    static int height(Node x) {
        if (x == null)
            return -1;

        return x.ht;
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node x2 = x.right;

        x.right = y;
        y.left = x2;

        y.ht = Math.max(height(y.left), height(y.right)) + 1;
        x.ht = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node x2 = y.left;

        y.left = x;
        x.right = x2;

        x.ht = Math.max(height(x.left), height(x.right)) + 1;
        y.ht = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static int getBalance(Node x) {
        return height(x.left) - height(x.right);
    }

    static Node insert(Node root, int val) {

        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = 0;
            return root;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val)
            return rightRotate(root);

        if (balance < -1 && val > root.right.val)
            return leftRotate(root);

        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
