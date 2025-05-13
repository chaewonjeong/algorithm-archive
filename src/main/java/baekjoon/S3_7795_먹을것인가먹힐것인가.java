package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S3_7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            a = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
            Arrays.sort(b);

            // a의 크기가 b의 크기보다 큰 쌍이 몇개인지
            int count = 0;
            int bp = m - 1;

            for (int ap = 0; ap < n && bp >= 0; ap++) {
                while(bp > 0 && a[ap] <= b[bp]){
                    bp--;
                }

                if(a[ap] > b[bp]){
                    count += bp + 1;
                }
            }
            answer.append(count).append("\n");
        }

        System.out.println(answer);
    }
}
