package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_11659_구간합구하기4 {
    // prefix sum
    // dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[100_001];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = nums[1];
        dp[2] = dp[1] + nums[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j]-dp[i-1]);
        }

    }
}

