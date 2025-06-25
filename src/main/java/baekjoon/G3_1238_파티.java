package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1238_파티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adjList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[v1].add(new int[] {v2, w});
        }

        int[] distStartToX = dijkstra(x,adjList,n);
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int[] dist = dijkstra(i,adjList,n);
            int iToX = dist[x];
            int xToi = distStartToX[i];

            if (answer < iToX + xToi) {
                answer = iToX + xToi;
            }
        }

        System.out.println(answer);


    }
    static int[] dijkstra(int startNode, ArrayList<int[]>[] adjList, int n){
        // (거리, 노드)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[startNode] = 0;
        pq.add(new int[]{0, startNode});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curW = cur[0];
            int curV = cur[1];

            if(dist[curV] != curW) continue;

            for(int[] adj : adjList[curV]) {
                int adjV = adj[0];
                int adjW = adj[1];

                if (dist[adjV] > dist[curV] + adjW) {
                    dist[adjV] = dist[curV] + adjW;
                    pq.add(new int[]{dist[adjV], adjV});
                }
            }
        }
        return dist;
    }
}


