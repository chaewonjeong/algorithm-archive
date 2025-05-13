package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_3273_두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == x) {
                count++;
                left++;
                right--;
            }

            if (nums[left] + nums[right] < x) {
                left++;
            }

            if (nums[left] + nums[right] > x) {
                right--;
            }
        }


        System.out.println(count);
    }
}
