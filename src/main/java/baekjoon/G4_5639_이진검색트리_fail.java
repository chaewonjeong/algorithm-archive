package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G4_5639_이진검색트리_fail {

    // 전위순회한 결과가 주어졌을 때, 후위순회한 결과를 구하는 프로그램을 작성하라
    // 노드의 왼쪽 서브트리는 노드 보다 작음
    // 노드의 오른쪽 서브트리는 노드 보다 크다

    // 트리의 순회결과가 주어졌을때 원래 트리를 복원할 수 있는가???


    static int[] tree = new int[10001];
    static StringBuilder answer = new StringBuilder();
    static void postOrder(int cur){
        if(tree[cur] == 0) return;

        postOrder(2*cur);
        postOrder(2*cur+1);
        answer.append(tree[cur]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> inputNums = new ArrayList<>();

        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int input = Integer.parseInt(line);
            inputNums.add(input);
        }

        tree[1] = inputNums.get(0);

        int cur = 1;

        for(int i = 1; i < inputNums.size(); i++) {
            int num = inputNums.get(i);

            if (tree[cur] > num) {
                cur *= 2;
                tree[cur] = num;
            } else if (tree[cur] < num) {
                // cur 의 부모보다 내가 작을때까지 cur를 바꿔
                while (cur/2 > 0 && tree[cur/2] < num){
                    cur /= 2;
                }
                cur = 2*cur + 1;
                tree[cur] = num;
            }
        }

        postOrder(1);
        System.out.println(answer);
    }
}
