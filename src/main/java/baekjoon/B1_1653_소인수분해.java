package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        int i = 2;
        while (i * i <= n) {
            if(n % i == 0) {
                answer.append(i).append("\n");
                n /= i;
            } else {
                i++;
            }
        }
        if(n != 1) answer.append(n).append("\n");
        System.out.println(answer);
    }
}
