package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_1753_최단경로_2 {

    static final int INF = 0x3f3f3f3f;
    public static void main(String[] args) throws IOException {
        // (거리, 정점)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[] dist = new int[v+1];

        Arrays.fill(dist, INF);

        ArrayList<int[]>[] adjLIst = new ArrayList[v + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for(int i = 0 ; i <= v ; i++){
            adjLIst[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjLIst[v1].add(new int[]{w, v2});
        }

        pq.add(new int[]{0, start});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll(); // (가중치, 정점)
            int curW = cur[0];
            int curV = cur[1];

            if(dist[curV] != curW) continue;

            for(int[] neighbor : adjLIst[curV]){
                int neighborW = neighbor[0];
                int neighborV = neighbor[1];

                if(dist[neighborV] > dist[curV] + neighborW){
                    dist[neighborV] = dist[curV] + neighborW;
                    pq.add(new int[]{dist[neighborV], neighborV});
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            int d = dist[i];
            if(d == INF) {
                answer.append("INF").append("\n");
            } else {
                answer.append(d).append("\n");
            }
        }

        System.out.println(answer);

    }
}
