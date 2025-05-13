package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S2_15664_N과M10 {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder answer = new StringBuilder();
    static void dfs(int depth, int now, List<Integer> result) {
        if(depth == m) {
            for (int i : result) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }
        int prev = -1;
        for (int i = now; i < n; i++) {
            if(prev == nums[i]) continue;
            result.add(nums[i]);
            prev = nums[i];
            dfs(depth + 1, i + 1, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0,0,new ArrayList<>());
        System.out.println(answer);

    }
}
