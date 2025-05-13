package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S2_1874_스택수열 {
    /*
    입력
    첫줄에 n (1<= n <= 100,000)
    push 하는 순서가 오름차순이어야하는거야
    수열은 상관없음
    두개의 스택이 필요한가??
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int a = 1;
        for (int s : sequence) {
            if(s > stack.peek()) {
                while(s > stack.peek()) {
                    stack.push(a++);
                    sb.append("+").append("\n");
                }
            }

            if (s == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            } else if(s < stack.peek()) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}
