package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_11779_최소비용구하기2 {
    // 1 <= n <= 1_000 도시
    // 1 <= m <= 100_000 간선

    // a -> b 로의 최소비용거리
    // 경로 출력 -> 갱신이 일어날때 해당 노드가 어떤 노드를 타고 왔는지 기록하는 prev 배열 선언해주면 됨

    static final int INF = 0x3f3f3f3f;
    static int[] prev;

    static class Node implements Comparable<Node> {
        int val;
        int price;

        Node(int val, int price){
            this.val = val;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

    static int[] dijkstra(int start, int n, ArrayList<Node>[] adjList){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curVal = cur.val;
            int curPrice = cur.price;

            if(dist[curVal] != curPrice) continue;

            for(Node next : adjList[curVal]){
                int nextVal = next.val;
                int nextPrice = next.price;

                if(dist[nextVal] > nextPrice + curPrice){
                    dist[nextVal] = nextPrice + curPrice;
                    prev[nextVal] = curVal;
                    pq.add(new Node(nextVal, dist[nextVal]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        prev = new int[n + 1];
        Arrays.fill(prev, -1);

        ArrayList<Node>[] adjList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            adjList[src].add(new Node(dest, price));
        }

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        int[] dist = dijkstra(src, n, adjList);

        StringBuilder answer = new StringBuilder();
        answer.append(dist[dest]).append("\n");

        Stack<Integer> course = new Stack<>();
        course.push(dest);

        int pre = prev[dest];
        while (pre != -1) {
            course.push(pre);
            pre = prev[pre];
        }

        answer.append(course.size()).append("\n");
        while (!course.isEmpty()) {
            answer.append(course.pop()).append(" ");
        }

        System.out.println(answer);

    }
}
