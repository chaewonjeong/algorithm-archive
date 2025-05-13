package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_1368_물대기 {
    // mst
    // 핵심은 -> 우물을 가상의 정점으로 생각할것
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 논의 수
        parent = new int[n+1];

        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[][] graph = new int[n+1][n+1];


        for(int i = 1; i <= n; i++) {
            graph[0][i] = Integer.parseInt(br.readLine());
        }

        ArrayList<int[]> edgeList = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i <= n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int w = graph[i][j];

                edgeList.add(new int[]{w, i, j});
            }
        }

        Collections.sort(edgeList, Comparator.comparing(o -> o[0]));

        int mstWeight = 0;
        int mstSize = 0;

        for(int[] edge : edgeList) {
            int w = edge[0];
            int x = edge[1];
            int y = edge[2];

            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY) {
                mstWeight += w;
                mstSize += 1;
                union(rootX, rootY);
            }

            if(mstSize == n){
                break;
            }
        }


        System.out.println(mstWeight);

    }
}
