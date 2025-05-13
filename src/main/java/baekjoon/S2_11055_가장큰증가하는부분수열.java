package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11055_가장큰증가하는부분수열 {
    // todo
    // 점화식이 쉽지 않네... ㅠ
    // 이중 for문 충분히 나올 수 있음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];

        // dp[i] => i 번째 원소를 마지막 원소로하는 증가 부분 수열의 최대 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());




    }
}
