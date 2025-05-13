package baekjoon;

import java.util.*;
import java.io.*;

public class G4_1504_특정한최단경로 {
    // 무방향 그래프
    // 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동할려고함
    // 조건
    // 최단 경로가 없을때는 -1
    static int INF = 200_000_001;
    static class Node {
        int index, cost;
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static void dijkstra(int start, List<List<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowIndex = cur.index;

            if(dist[nowIndex] != cur.cost) continue;
            for(Node adjNode : graph.get(nowIndex)) {
                int adjCost = dist[nowIndex] + adjNode.cost;
                if(adjCost < dist[adjNode.index]) {
                    dist[adjNode.index] = adjCost;
                    pq.add(new Node(adjNode.index, adjCost));
                }
            }
        }
    }

    static int[] createDist(int n){
        int[] dist = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dist[i] = INF;
        }
        return dist;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 경유해야하는 점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] start1 = createDist(N);
        int[] startV1 = createDist(N);
        int[] startV2 = createDist(N);

        dijkstra(1,graph,start1);
        dijkstra(v1, graph, startV1);
        dijkstra(v2, graph, startV2);

        int case1 = start1[v1] + startV1[v2] + startV2[N];
        int case2 = start1[v2] + startV2[v1] + startV1[N];
        int answer = Math.min(case1, case2);

        if(answer >= INF){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }
    }
}
