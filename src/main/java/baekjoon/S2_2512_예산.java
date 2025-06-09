package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2512_예산 {
    // 가능한 한 최대의 총예산
    // 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
    // 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계싼하여 그 이상인 예산 요청에는 모두 상한액을 배정한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(arr, mid, m)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);

    }

    static boolean solve(int[] arr, int k, int m) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                sum += arr[i];
            } else {
                sum += k;
            }
        }

        if (sum <= m) {
            return true;
        } else {
            return false;
        }
    }
}
