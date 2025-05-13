package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230_수고르기_by이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int target = nums[i] + m;
            int left = i + 1;
            int right = n - 1;

            while (left<=right){
                int mid = left + (right - left)/2;
                if(nums[mid]>=target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if(left != n){
                answer = Math.min(answer, nums[left] - nums[i]);
            }
        }

        System.out.println(answer);
    }
}