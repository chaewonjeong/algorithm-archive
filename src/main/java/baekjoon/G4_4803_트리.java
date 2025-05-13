package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_4803_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int testCase = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0) break;
            int count = 0;

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for(int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                adj[v1].add(v2);
                adj[v2].add(v1);
            }
            boolean[] visited = new boolean[n + 1];
            int[] parent = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                boolean isTree = false;
                Queue<Integer> queue = new ArrayDeque<>();

                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    isTree = true;
                }

                while(!queue.isEmpty() && isTree) {
                    int cur = queue.poll();

                    for(int neighbor : adj[cur]) {
                        if(!visited[neighbor]) {
                            parent[neighbor] = cur;
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        } else {
                            if(parent[cur] != neighbor){ // 방문을 한곳인데 나의 부모가 아니다?? -> 사이클
                                isTree = false;
                                break;
                            }
                        }
                    }
                }
                if(isTree){
                    count++;
                }
            }
            if(count > 1){
                answer.append("Case " + testCase+":" + " A forest of " + count +  " trees.").append("\n");
            } else if(count == 1){
                answer.append("Case " + testCase+":" + " There is one tree.").append("\n");
            } else {
                answer.append("Case " + testCase+":" + " No trees.").append("\n");
            }
            testCase++;
        }

        System.out.println(answer);
    }
}
