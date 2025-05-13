package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연속된 수들의 부분합중 s 이상이 되는데 그길이가 가장 짧은것의 길이
        int answer = Integer.MAX_VALUE;

        int end = 0;
        int sum = 0;
        for (int start = 0; start < n; start++) {
            while (end < n && sum < s) {
                sum += nums[end];
                end++;
            }

            if (sum >= s) {
                answer = Math.min(answer, end - start);
            }

            sum -= nums[start];
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else{
            System.out.println(answer);
        }
    }
}
