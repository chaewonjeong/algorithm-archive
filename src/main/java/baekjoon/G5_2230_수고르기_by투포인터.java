package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230_수고르기_by투포인터 {
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

//        int start = 0;
//        int end = 0;
//        int dif = 0;

//        while (end < n) {
//            if (start == end) {
//                end++;
//            }
//            if(end == n) break;
//
//            dif = nums[end] - nums[start];
//
//            if(dif >= m){
//                answer = Math.min(answer, dif);
//                start++;
//            } else {
//                end++;
//            }
//        }

        int end = 0;
        for(int start = 0; start < n; start++) {
            while(end < n && nums[end] - nums[start] < m) {
                end++;
            }
            if(end == n) break;
            answer = Math.min(answer, nums[start] - nums[end]);
        }

        System.out.println(answer);
    }
}
