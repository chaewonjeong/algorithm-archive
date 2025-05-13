package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class G4_2295_세수의합_fail {
    // 해당 문제는 조합을 직접적으로 다 구할 필요가 없다.
    static int n;
    static int[] nums;
    static int[] optimal = new int[4];


    static void dfs(int depth, ArrayList<Integer> result) {
        if (depth == 3) {
            int x = result.get(0);
            int y = result.get(1);
            int z = result.get(2);

            int k = x + y + z;
            if(k < optimal[3]){
                return;
            }

            int idx = binarySearch(nums,k);

            if (idx != -1) {
                if(optimal[3] < nums[idx]){
                    optimal[0] = x;
                    optimal[1] = y;
                    optimal[2] = z;
                    optimal[3] = nums[idx];
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(nums[i]);
            dfs(depth + 1, result);
            result.remove(result.size() - 1);
        }

    }

    static int binarySearch(int[] nums, int target) {
        int st = 0, en = nums.length - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }

        return -1; // 못 찾으면 -1
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        optimal[3] = -1;

        dfs(0, new ArrayList<>());
//        System.out.println(optimal[0]);
//        System.out.println(optimal[1]);
//        System.out.println(optimal[2]);
        System.out.println(optimal[3]);
    }
}
