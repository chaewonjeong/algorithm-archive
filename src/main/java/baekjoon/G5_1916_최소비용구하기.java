package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_1916_최소비용구하기 {
    // 최소비용을 구해라
    // 한도시에서 출발 : 다익스트라, 플로이드??
    // 시간제한 0.5초 : V 가 최대 1000 이기때문에
    // 플로이드 O(v^3) -> 0.5초내에에 실행될 가능성 x
    // 다익스트라로 하자

    static class Node implements Comparable<Node> {
        int index, cost;
        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        int[] dist = new int[n + 1];



        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            // 출발 - 도착 - 비용
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            int c = Integer.parseInt(line.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        StringTokenizer line = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(line.nextToken());
        int end = Integer.parseInt(line.nextToken());

        // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        // 시작점 우선순위큐에 넣기 -> 우선수누이 큐에는 거리와 정점의 인덱스 번호 저장
        pq.add(new Node(start, 0));

        // 최단거리 테이블에 시작점을 0으로 초기화
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curent = pq.poll();
            int now = curent.index;

            if(dist[now] < curent.cost) continue;
            for(Node neighbor : graph.get(now)){
                int cost = dist[now] + neighbor.cost;
                if(cost < dist[neighbor.index]){
                    dist[neighbor.index] = cost;
                    pq.add(new Node(neighbor.index, cost));
                }
            }
        }


        System.out.println(dist[end]);
    }
}
