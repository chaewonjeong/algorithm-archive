package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2579_계단오르기_plus {
    //todo
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // dp[i] = i 번째 계단까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 단 i 번째 계단은 반드시 밟지 않을 계단으로 선택
    }
}
