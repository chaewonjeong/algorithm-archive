package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2252_줄세우기 {
    // 일부 학생들의 키를 비교한 결과 -> 정점들 간의 선후 관계 존재
    // 줄세워라 -> 정렬해라
    // -> 위상정렬

    // 입력 : A B -> A가 B 앞에 있어야한다
    // 그래프로 표현하면 a -> b

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 비교 횟수
        int[] indegree = new int[n+1];

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegree[b]++; // 추가
        }

//        for(int i = 1; i <= n; i++) {
//            for(int v: adj[i]) {
//                indegree[v]++;
//            }
//        }

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");
            for(int next : adj[v]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
