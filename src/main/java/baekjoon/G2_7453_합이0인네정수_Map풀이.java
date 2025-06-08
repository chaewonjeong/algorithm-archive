package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class G2_7453_합이0인네정수_Map풀이 {
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

        int indexAB = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long num = A[i] + B[j];
                AB[indexAB++] = num;
            }
        }

        // 해시 테이블에 삽입될 데이터가 많을 경우
        // 리사이징에 소비되는 비용을 고려하여 미리 크기를 정해두는게 좋다.
        // 실제로 이렇게 지정해야 시간초과가 발생하지 않는다.
        HashMap<Long, Integer> numsMap = new HashMap<>(n*n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long num = C[i] + D[j];
                //getOrDefault 보다 속도면에서 빠름
                numsMap.merge(num, 1, Integer::sum);
            }
        }

        long count = 0;
        for (long num : AB) {
            count += numsMap.getOrDefault(-num, 0);
        }
        System.out.println(count);


    }


}
