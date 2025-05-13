package example.graph;

import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
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

    public static void dijkstra(int start, List<List<Node>> graph, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;

            // 현재 노드의 비용이 저장된 거리보다 크다면 무시
            if(dist[now] < current.cost) continue;

            // 인접 노드 탐색
            for(Node neighbor : graph.get(now)) {
                int cost = dist[now] + neighbor.cost;

                if(cost < dist[neighbor.index]) {
                    dist[neighbor.index] = cost;
                    pq.add(new Node(neighbor.index, cost));
                }
            }
        }
    }
}
