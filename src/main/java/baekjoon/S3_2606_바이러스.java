package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2606_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n+1];

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

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        // 1번에 의해 바이러스에 걸리는 컴퓨터를 구해
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int adjV : adj[cur]) {
                if(!visited[adjV]) {
                    visited[adjV] = true;
                    count++;
                    q.add(adjV);
                }
            }
        }
        System.out.println(count);
    }
}
