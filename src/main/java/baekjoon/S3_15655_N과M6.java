package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15655_N과M6 {

    static int n;
    static int m;
    static int[] nums;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int k, int now, ArrayList<Integer> result) {
        if(k == m) {
            for (int i = 0; i < result.size(); i++) {
                answer.append(result.get(i)).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i = now; i < n; i++) {
            result.add(nums[i]);
            dfs(k+1, i+1, result);
            result.remove(result.size()-1);
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
        ArrayList<Integer> result = new ArrayList<>();
        dfs(0,0,result);
        System.out.println(answer);

    }
}
