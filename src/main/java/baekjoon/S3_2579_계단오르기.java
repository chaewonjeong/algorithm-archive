package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][3];

        // 규칙
        // 한번에 한칸 or 두칸
        // 연속된 세개의 계단은 안됨
        // 마지막 도착 계단은 반드시 밟아야함

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        } else if (n == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }


        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[1] + stairs[2];


        for(int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
            dp[i][2] = dp[i-1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
