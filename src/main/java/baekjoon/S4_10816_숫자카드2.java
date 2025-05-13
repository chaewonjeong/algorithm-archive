package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_10816_숫자카드2 {
    static int[] nums;
    static int[] targets;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        m = Integer.parseInt(br.readLine());
        targets = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for(int target: targets){
            int upIdx = upperSearch(target);
            int lowIdx = lowerSearch(target);

            answer.append(upIdx - lowIdx).append(" ");
        }

        System.out.println(answer);
    }

    private static int upperSearch(int target) {
        int right = nums.length;
        int left = 0;
        while(left < right){
            int center = (left + right) / 2;
            if (nums[center] > target) {
                right = center;
            } else {
                left = center + 1;
            }
        }
        return left;
    }

    private static int lowerSearch(int target) {
        int right = nums.length;
        int left = 0;
        while(left < right){
            int center = (left + right) / 2;
            if (nums[center] >= target) {
                right = center;
            }
            else left = center + 1;
        }
        return left;
    }
}
