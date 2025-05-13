package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class G4_2295_세수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        HashSet<Integer> two = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                two.add(nums[i] + nums[j]);
            }
        }


        for(int i = n-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                int temp = nums[i] - nums[j];
                if(two.contains(temp)) {
                    max = Math.max(max, nums[i]);
                }
            }
        }


        System.out.println(max);

    }
}
