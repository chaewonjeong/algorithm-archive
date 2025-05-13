package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11724_연결요소의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[V+1];
        for(int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>(); // 인접리스트 배열 초기화 해줘야하는거 주의
        }


        for (int i = 0; i < E; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(line.nextToken());
            int v2 = Integer.parseInt(line.nextToken());

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        // 연결 요소의 갯수 탐색
        int count = 0;

        boolean[] visited = new boolean[V+1];



        for(int i = 1; i <= V; i++) {
            if(!visited[i]) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = true;

                while(!q.isEmpty()) {
                    int cur = q.poll();

                    for(int j : adj[cur]) {
                        if(!visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }

                }
                count++;
            }
        }
        System.out.println(count);
    }
}
