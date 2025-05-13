package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_15663_N과M9 {
    static int n;
    static int m;
    static int[] nums;
    static StringBuilder answer = new StringBuilder();
    //static HashSet<List<Integer>> answerSet = new HashSet<>();

    static void dfs(int depth, boolean[] visited, List<Integer> result) {
        if(depth == m) {
            for (int i : result) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && prev != nums[i]) {
                result.add(nums[i]);
                prev = nums[i];
                visited[i] = true;
                dfs(depth + 1, visited, result);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
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

        dfs(0,new boolean[n], new ArrayList<>());
        System.out.println(answer.toString());
    }
}
