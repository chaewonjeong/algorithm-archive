package example.tree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root; // static 제거

    public BinaryTree() {
        // 트리 생성 (생성자 사용)
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    public void DFS_preorder(Node node) {
        if (node == null) return; // null 체크
        System.out.print(node.data + " ");
        DFS_preorder(node.left);
        DFS_preorder(node.right);
    }

    public void DFS_inorder(Node node) {
        if (node == null) return; // null 체크
        DFS_inorder(node.left);
        System.out.print(node.data + " ");
        DFS_inorder(node.right);
    }

    public void DFS_postorder(Node node) {
        if (node == null) return; // null 체크
        DFS_postorder(node.left);
        DFS_postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(); // 객체 생성 후 root 사용

        tree.DFS_preorder(tree.root);
        System.out.println();
        tree.DFS_inorder(tree.root);
        System.out.println();
        tree.DFS_postorder(tree.root);
    }
}
