package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long[] AB = new long[n * n];
        long[] CD = new long[n * n];

        int indexAB = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long num = A[i] + B[j];
                AB[indexAB++] = num;
            }
        }

        int indexCD = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long num = C[i] + D[j];
                CD[indexCD++] = num;
            }
        }

        long count = 0;

        Arrays.sort(AB);
        Arrays.sort(CD);

        for (int i = 0; i < n * n; i++) {
            long target = AB[i];
            int lb = lowerBound(CD, -target);
            int ub = upperBound(CD, -target);

            if (ub >= lb) {
                count += ub - lb + 1;
//
//                System.out.println("target : " + target);
//                System.out.println(lb);
//                System.out.println(CD[lb]);
//                System.out.println();
//                System.out.println(ub);
//                System.out.println(CD[ub]);
//                System.out.println();
            }
        }
        System.out.println(count);
    }

    static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
