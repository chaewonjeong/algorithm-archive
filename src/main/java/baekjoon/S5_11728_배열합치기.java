package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;

        while(i != n && j != m){
            if(A[i] < B[j]){
                sb.append(A[i]).append(" ");
                i++;
            } else {
                sb.append(B[j]).append(" ");
                j++;
            }
        }

        if (i == n) {
            for(int p = j; p < m; p++){
                sb.append(B[p]).append(" ");
            }
            System.out.println(sb);
            return;
        } else if(j == m){
            for(int p = i; p < n; p++){
                sb.append(A[p]).append(" ");
            }
            System.out.println(sb);
            return;
        }

    }
}
