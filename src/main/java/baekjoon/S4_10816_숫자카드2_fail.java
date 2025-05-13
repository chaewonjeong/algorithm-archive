package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_10816_숫자카드2_fail {

    static int binarySearch(int[] nums, int left, int right, int target) {
        int center = (left + right) / 2;
        if(left > right) {
            return 0;
        }

        if(nums[center] == target) {
            while (nums[left++] < nums[center]);
            while (nums[right--] > nums[center]);
            return right - left;
        }
        if(nums[center] > target) {
            return binarySearch(nums, left, center - 1 , target);
        } else{
            return binarySearch(nums, center + 1, right, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        int[] target = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : target) {
            answer.append(binarySearch(nums, 0, n - 1, i)).append(" ");
        }

        System.out.println(answer);
    }
}
