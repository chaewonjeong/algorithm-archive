package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_11725_트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int V = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        // 트리 : V개의 정점을 가질때 V-1 개의 간선을 가진다

        for(int i = 0; i < V-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            adj[V1].add(V2);
            adj[V2].add(V1);
        }

        int[] parent = new int[V + 1];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : adj[cur]){
                if(next != parent[cur]){
                    queue.add(next);
                    parent[next] = cur;
                }
            }
        }

        for(int i = 2; i <= V; i++){
            answer.append(parent[i]).append("\n");
        }
        System.out.println(answer.toString());
    }
}
