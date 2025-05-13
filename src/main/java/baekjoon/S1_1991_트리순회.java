package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_1991_트리순회 {
    static ArrayList<Integer> preOrderAnswer = new ArrayList<>();
    static ArrayList<Integer> inOrderAnswer = new ArrayList<>();
    static ArrayList<Integer> postOrderAnswer = new ArrayList<>();

    static int[] lc;
    static int[] rc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();
        int V = Integer.parseInt(br.readLine());

        // 노드의 이름은 A 부터 차례대로 알파벳 대문자로 자식 노드가 없는 경우에는 .
        // 대문자 A의 아스키 코드 -> 65

        lc = new int[V+1];
        rc = new int[V+1];
        //알파벳 형변환 하는 방법 숙지

        for (int i = 0; i < V - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cur = st.nextToken().charAt(0) - 'A' + 1; // 'A'를 1로 변환
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            lc[cur] = Character.isAlphabetic(left) ? left - 'A' + 1 : 0;
            rc[cur] = Character.isAlphabetic(right) ? right - 'A' + 1 : 0;
        }
        preOrder(1);
        inOrder(1);
        postOrder(1);

        for(int i = 0; i < V; i++){
            int v = preOrderAnswer.get(i) + 64;
            pre.append((char)v);
        }

        for(int i = 0; i < V; i++){
            int v = inOrderAnswer.get(i) + 64;
            in.append((char)v);
        }

        for(int i = 0; i < V; i++){
            int v = postOrderAnswer.get(i) + 64;
            post.append((char)v);
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preOrder(int cur){
        preOrderAnswer.add(cur);
        if(lc[cur] != 0) preOrder(lc[cur]);
        if(rc[cur] != 0) preOrder(rc[cur]);
    }

    static void inOrder(int cur){
        if(lc[cur] != 0) inOrder(lc[cur]);
        inOrderAnswer.add(cur);
        if(rc[cur] != 0) inOrder(rc[cur]);
    }

    static void postOrder(int cur){
        if(lc[cur] != 0) postOrder(lc[cur]);
        if(rc[cur] != 0) postOrder(rc[cur]);
        postOrderAnswer.add(cur);
    }
}
