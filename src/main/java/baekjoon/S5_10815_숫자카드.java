package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        // 숫자카드의 갯수 N
        // 적혀있는수 -10_000_000 ~ 10_000_000
        // 같은 수 없음
        StringBuilder answer = new StringBuilder();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list1[i] = Integer.parseInt(st.nextToken());
        }


        int M = Integer.parseInt(br.readLine());
        int[] list2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            list2[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(list1);

        for (int target : list2) {
            int left = 0;
            int right = N-1;
            int isPresent = 0;

            while (left <= right) {
                int mid = (left+ right)/ 2;

                if(list1[mid] == target){
                    isPresent = 1;
                    break;
                } else if (list1[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            answer.append(isPresent + " ");

        }

        System.out.println(answer);





    }
}
