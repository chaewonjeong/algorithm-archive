package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        // 1. 절댓값 비교
        // 2. 절댓값이 같으면 실제 값으로 비교

        // Comparator 설정 중요!!!
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt((Integer o) -> Math.abs(o)).thenComparingInt(o -> o)
        );

        int n =Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                if(pq.isEmpty()){
                    answer.append(0).append("\n");
                } else {
                    answer.append(pq.poll()).append("\n");

                }
            } else {
                pq.add(a);
            }
        }

        System.out.println(answer);
    }
}
