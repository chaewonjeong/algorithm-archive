package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_2056_작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n+1];
        int[] degree = new int[n+1];
        int[] dp = new int[n+1];

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            cost[i] = c;
            for(int j = 0 ; j < k ; j++) {
                int v = Integer.parseInt(st.nextToken());
                adjList[v].add(i);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int v : adjList[i]) {
                degree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                dp[i] = cost[i];
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : adjList[cur]) {
                degree[next]--;
                dp[next] = Math.max(dp[next], dp[cur]+ cost[next]);
                if(degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        int answer = 0;
        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}
