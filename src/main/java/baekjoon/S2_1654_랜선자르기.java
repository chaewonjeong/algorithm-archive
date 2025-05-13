package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1654_랜선자르기 {
    static int n;
    static int k;
    static int[] arr;

    static boolean solve(Long x) {
        Long cur = 0L;
        for (int i = 0; i < k; i++) {
            cur += arr[i]/x;
        }
        return cur >= n;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Integer.MAX_VALUE;

        while(left < right) {
            long mid = (left + right+1)/2;
            if (solve(mid)) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
