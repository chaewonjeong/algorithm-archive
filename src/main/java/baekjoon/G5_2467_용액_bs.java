package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2467_용액_bs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Long[] nums = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }


        Long min = Long.MAX_VALUE;
        Long[] answer = new Long[2];

        for (int i = 0; i < n; i++) {
            long base = nums[i];

            int left = i + 1;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if(Math.abs(base + nums[mid]) < min) {
                    min = Math.abs(base + nums[mid]);
                    answer[0] = base;
                    answer[1] = nums[mid];
                }

                if(base + nums[mid] < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
