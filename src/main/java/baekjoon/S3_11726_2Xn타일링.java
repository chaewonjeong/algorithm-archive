package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_11726_2Xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100005]; // 별다른 제약 조건이 없다면 dp 테이블은 넉넉하게 잡자

        dp[1] = 1;
        dp[2] = 2; // 만약 n = 1이라면 여기서 런타임에러 발생 -> 예외처리를 해주면 좋지만 dp 테이블이 넉넉하다면 문제 x

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%10_007; // 마지막에 mod 연산을 하면 intoverflow 발생 가능
        }
        System.out.println(dp[n]);
    }
}
