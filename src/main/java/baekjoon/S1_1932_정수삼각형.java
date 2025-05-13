package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1932_정수삼각형 {
    //dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];


        for (int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + map[i][j];
                } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - 1]) + map[i][j];
                }

            }
        }

        System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());

    }
}
