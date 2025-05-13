package baekjoon;

import java.util.*;

public class S1_12852_1로만들기2 {
    // 1<= n <= 1,000,000;
    // dp
    // dp 에서의 경로 복원
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1_000_005];
        int[] pre = new int[1_000_005]; // 경로 복원용 테이블

        dp[1] = 0;
        pre[1] = 1;
        dp[2] = 1;
        pre[2] = 1;
        dp[3] = 1;
        pre[3] = 1;



        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            pre[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i / 2] + 1;
                pre[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
        }

        System.out.println(dp[n]);
        int cur = n;
        while (true) {
            System.out.print(cur + " ");
            if(cur == 1) break;
            cur = pre[cur];
        }

    }
}
