package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920_수찾기_fail {

    static int search(int[] nums, int target) {
        int center = nums.length / 2;

        if(nums[center] == target) return 1;
        if(center == 0) return 0;

        if(nums[center] > target){
            return search(Arrays.copyOfRange(nums, 0, center), target);
        } else {
            return search(Arrays.copyOfRange(nums, center, nums.length), target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());

        int[] targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : targets) {
            System.out.println(search(nums, i));
        }
    }
}
