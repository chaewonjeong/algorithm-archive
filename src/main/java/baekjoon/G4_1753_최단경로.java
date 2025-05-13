package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1753_최단경로 {

    static class Node implements Comparable<Node> {
        int index, cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

     static void dijkstra(int start, List<List<Node>> graph, int[]dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.index;

            if(dist[now] < cur.cost)continue;

            for(Node neighbor : graph.get(now)){
                int cost = dist[now] + neighbor.cost;

                if(cost < dist[neighbor.index]){
                    dist[neighbor.index] = cost;
                    pq.add(new Node(neighbor.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }

        int[] dist = new int[V+1];

        for(int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dijkstra(start, graph, dist);

        for(int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
