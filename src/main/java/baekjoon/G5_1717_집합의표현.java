package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1717_집합의표현 {
    static int[] parent;
    // 유니온 파인드 대표 예제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 0 ~ n 까지의 총 n + 1 개의 개별 집합이 주어진다.
        int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = -1; // -1로 초기화
        }

        // union 연산 : 0
        // find 연산 : 1

        for (int i = 0; i < m; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(line.nextToken());
            int u = Integer.parseInt(line.nextToken());
            int v = Integer.parseInt(line.nextToken());

            if(cmd == 0){
                union(u,v);
            } else if (cmd == 1){
                if(find(u,v)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static int find(int u) {
        if(parent[u] < 0) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }

    private static boolean find(int u, int v){
        return find(u) == find(v);
    }

    private static boolean union(int u, int v) {
        // 랭크 적용
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return false; // 이미 같은 집합

        if(parent[rootU] > parent[rootV]) { //v의 랭크가 더 큰경우
            int tmp = rootU;
            rootU = rootV;
            rootV = tmp;
        }
        // 항상 rootU의 랭크가 더 큼
        // 즉 항상 v를 u의 자식으로 union

        if(parent[rootU] == parent[rootV]) {
            parent[rootU]--;
        }
        parent[rootV] = rootU;
        return true;
    }
}
