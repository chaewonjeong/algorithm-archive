package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_16041_과자나눠주기 {
    public static void main(String[] args) throws IOException {
        // 같은 길이로 과자를 나눠줘야함
        // M명의 조카 1 ~ 1_000_000
        // 과자의 수 N : 1 ~ 1_000_000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 범위 잘보고 lb ub 지정
        // lb 를 0으로 잡아버리면 mid 값이 0 이 될 수 있음
        int lb = 1;
        int ub = 1_000_000_000;

        // 막대 과자의 최대길이를 구해야함
        while (lb <= ub) {
            int mid = (lb + ub) / 2;

            if (solve(arr, mid, M)) {
                lb = mid + 1;
            } else {
                ub = mid - 1;
            }
        }

        System.out.println(ub);

    }

    static boolean solve(int[] arr, int length, int m){
        int count = 0;
        for (int i : arr) {
            count += i / length;
        }

        return count >= m;
    }

}
