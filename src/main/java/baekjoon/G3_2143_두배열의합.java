package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G3_2143_두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[] prefixA = new long[n];
        prefixA[0] = A[0];
        for(int i = 1; i < n; i++) {
            prefixA[i] = prefixA[i - 1] + A[i];
        }


        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        long[] prefixB = new long[m];
        prefixB[0] = B[0];
        for(int i = 1; i < m; i++) {
            prefixB[i] = prefixB[i - 1] + B[i];
        }
    // 부분 배열의 합을 약간 복잡하게 구함. 실제로 이렇게 할 필요 없음
    // 아이디어대로 구현했지만, 실제로는 이중 루프로 i부터 j까지 누적합을 계산하는 방식이 더 직관적이고 간단함.

        ArrayList<Long> subA = new ArrayList<>();
        ArrayList<Long> subB = new ArrayList<>();

        for(int i = -1; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(i == -1){
                    subA.add(prefixA[j]);
                } else{
                    subA.add(prefixA[j] - prefixA[i]);
                }
            }
        }

        for (int i = -1; i < m - 1; i++) {
            for(int j = i + 1; j < m; j++) {
                if(i == -1){
                    subB.add(prefixB[j]);
                } else {
                    subB.add(prefixB[j] - prefixB[i]);
                }
            }
        }

        long[] subAList = subA.stream().sorted().mapToLong(Long::longValue).toArray();
        long[] subBList = subB.stream().sorted().mapToLong(Long::longValue).toArray();
        long count = 0;
        for (long l : subAList) {
            long target = T - l;
            int lb = lowerBound(subBList, target);
            int ub = upperBound(subBList, target);
            if (ub >= lb) {
                count += ub - lb + 1;
            }
        }

        System.out.println(count);

    }

    static int upperBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
