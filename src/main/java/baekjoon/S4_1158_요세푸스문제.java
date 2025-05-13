package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S4_1158_요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> deque = new ArrayDeque<>();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                deque.add(deque.poll());
            }
            sb.append(deque.poll());

            if (!deque.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
