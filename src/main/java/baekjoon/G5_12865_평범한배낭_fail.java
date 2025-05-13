package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_12865_평범한배낭_fail {
    // todo
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] some = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            some[i][0] = Integer.parseInt(st.nextToken()); // 무게
            some[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int[][] dp = new int[n][2];
        dp[0][0] = some[0][0]; // 무게
        dp[0][1] = some[0][1]; // 가치

        for (int i = 1; i < n; i++) {
            int weight = some[i][0];
            int val = some[i][1];
            for(int j = 0; j < i; j++) {
                if(weight + dp[j][0] <= k){
                    weight += dp[j][0];
                    val += dp[j][1];
                }
            }
            dp[i][0] = weight;
            dp[i][1] = val;
        }

        int max = 0;
        for (int[] i : dp) {
            if(i[1] > max) max = i[1];
        }
        System.out.println(max);
    }
}
