package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1822_차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(A);
        Arrays.sort(B);

        // 집합 A에는 속하면서 B에는 속하지 않는 모든 원소
        int count = 0;
        StringBuilder answer = new StringBuilder();
        for (int i : A) {
            // Arrays.binarySearch 함수는 못찾았을 때 -삽입위치 - 1 을 반환함
            // 음수를 반환
            if(Arrays.binarySearch(B,i) < 0){
                // 못 찾았을때
                count++;
                answer.append(i + " ");
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println(count);
            System.out.println(answer);
        }



    }
}
