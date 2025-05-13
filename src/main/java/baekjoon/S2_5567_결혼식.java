package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_5567_결혼식 {
    // 친구의 친구까지만 초대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] visited = new int[n+1];
        Arrays.fill(visited,-1);

        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        visited[1] = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int friend: adj[cur]) {
                if(visited[friend] == -1) {
                    visited[friend] = visited[cur] + 1;
                    queue.add(friend);
                }
            }
        }

        int count = 0;
        for (int i : visited) {
            if (i > 0 && i <= 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}
