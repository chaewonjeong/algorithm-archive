package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9095_123더하기_dp {

    static int[] dp = new int[12];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i<11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < T; i++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
