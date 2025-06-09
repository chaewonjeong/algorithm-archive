package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        long[] answer = new long[4];
        answer[0] = Long.MAX_VALUE;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                long sum = arr[i] + arr[j];

                int left = j + 1;
                int right = n - 1;

                while (left <= right) {
                    int mid =(left + right) / 2;

                    if (Math.abs(sum + arr[mid]) <= Math.abs(answer[0])) {
                        answer[0] = sum + arr[mid];
                        answer[1] = i;
                        answer[2] = j;
                        answer[3] = mid;
                    }

                    if (sum + arr[mid] >= 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        for (int i = 1; i < 4; i++) {
            System.out.print(arr[(int) answer[i]] + " ");
        }
    }
}
