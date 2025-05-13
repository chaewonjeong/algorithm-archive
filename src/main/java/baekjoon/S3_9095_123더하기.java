package baekjoon;

import java.util.Scanner;

public class S3_9095_123더하기 {
    //static int count;
    static int[] dp = new int[11];

    static int fun(int n){
        if(n == 0) return 1;
        if(dp[n] != 0) return dp[n];

        int result = fun(n-1);
        if(n-2 >= 0) result += fun(n - 2);
        if(n-3 >= 0) result += fun(n-3);

        return dp[n] = result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] test = new int[T];

        for (int i = 0; i < T; i++) {
            test[i] = scanner.nextInt();
        }
        for(int t : test){

            System.out.println(fun(t));
        }
    }
}
