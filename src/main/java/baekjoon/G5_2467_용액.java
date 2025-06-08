package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Long[] nums = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        int left = 0, right = n -1;
        Long min = Long.MAX_VALUE;
        Long[] answer = new Long[2];

        while (left < right) {
            if (Math.abs(nums[left] + nums[right]) < min) {
                min = Math.abs(nums[left] + nums[right]);
                answer[0] = nums[left];
                answer[1] = nums[right];
            }
            if (nums[left] + nums[right] >= 0) {
                right--;
            } else {
                left++;
            }


        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
