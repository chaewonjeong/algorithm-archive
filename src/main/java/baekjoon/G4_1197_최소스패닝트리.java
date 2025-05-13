package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G4_1197_최소스패닝트리 {

    static int[] parent;

    static int find(int v){
        if(parent[v]==v){
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int mstW = 0;
        int mstSize = 0;

        parent = new int[v+1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        ArrayList<int[]> edgeList = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList.add(new int[]{a, b, w});
        }

        Collections.sort(edgeList, Comparator.comparing(o->o[2]));

        for(int[] edge : edgeList) {
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];

            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                union(a,b);
                mstW += w;
                mstSize++;
            }

            if (mstSize == v - 1) {
                break;
            }
        }

        System.out.println(mstW);


    }
}
