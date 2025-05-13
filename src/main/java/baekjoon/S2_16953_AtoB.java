package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_16953_AtoB {

    static class Node{
        Long value;
        int count;

        Node(Long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new ArrayDeque<>();
        Node node = new Node(A,0);

        queue.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.value == B) {
                System.out.println(cur.count+1);
                return;
            }

            if(cur.value < B){
                queue.add(new Node(cur.value*2, cur.count+1));
                queue.add(new Node(cur.value*10 + 1, cur.count+1));
            }
        }

        System.out.println(-1);

    }
}
