package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1149_RGB거리 {
    //dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        // 비용의 최솟값
        int[][] dp = new int[N + 1][3];
        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        System.out.println(Arrays.stream(dp[N]).min().getAsInt());
    }
}
