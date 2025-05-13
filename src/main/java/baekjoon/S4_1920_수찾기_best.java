package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920_수찾기_best {

    static int search(int[] nums,int left, int right, int target) {
        if(left > right) return 0;
        int center = (left + right) / 2;
        if(nums[center] == target) return 1;
        else if( nums[center] > target) {
            return search(nums, left, center - 1, target);
        }else {
            return search(nums, center + 1, right, target);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
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
            int ans = search(nums, 0, nums.length - 1, i);
            answer.append(ans).append("\n");
        }

        System.out.println(answer.toString());
    }
}
