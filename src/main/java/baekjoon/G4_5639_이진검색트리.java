package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G4_5639_이진검색트리 {

    // 전위순회한 결과가 주어졌을 때, 후위순회한 결과를 구하는 프로그램을 작성하라
    // 노드의 왼쪽 서브트리는 노드 보다 작음
    // 노드의 오른쪽 서브트리는 노드 보다 크다

    // 트리의 순회결과가 주어졌을때 원래 트리를 복원할 수 있는가???
    // BST 에서는 전위, 후위 순회 결과가 주어지면 원래 트리 복원 가능
    static class Node {
        int val;
        Node left = null;
        Node right = null;

        public Node(int x) {
            this.val = x;
        }
    }

    static void insert(Node root, Node newNode) {
        if(newNode.val < root.val) {
            if(root.left == null){
                root.left = newNode;
            } else {
                insert(root.left, newNode);
            }
        } else {
            if(root.right == null){
                root.right = newNode;
            } else {
                insert(root.right, newNode);
            }
        }
    }
    static StringBuilder answer = new StringBuilder();

    static void postOrder(Node cur){
        if(cur == null) return;

        postOrder(cur.left);
        postOrder(cur.right);
        answer.append(cur.val).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputNums = new ArrayList<>();

        String line;
        // 별도의 입력 갯수가 주어 지지 안았을때 BufferedReader 는 입력값이 없다면 null을 반환
        Node root = null;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int input = Integer.parseInt(line);
            if (root != null) {
                insert(root, new Node(input));
            } else {
                root = new Node(input);
            }
        }

        postOrder(root);
        System.out.println(answer);
    }

}








