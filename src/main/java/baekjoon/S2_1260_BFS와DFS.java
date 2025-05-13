package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_1260_BFS와DFS {
    /*
    그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, -> 재귀 dfs
    더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
     */

    // 익숙하지 않은 비재귀 방식으로 DFS 구현을 연습해본 문제

    // 재귀 방식으로 구현해볼 것
    static StringBuilder bfsAnswer = new StringBuilder();
    static StringBuilder dfsAnswer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[V+1];

        for(int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>(); // 그래프 초기화
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            graph[V1].add(V2);
            graph[V2].add(V1);
        }

        for(int i = 1; i <= V; i++) {
            ArrayList<Integer> adjacentVertices = graph[i];
            adjacentVertices.sort(Integer::compareTo);
        }

        BFS(startVertex, graph);
        DFS(startVertex, graph);
        System.out.println(dfsAnswer);
        System.out.println(bfsAnswer);
    }

    static void BFS(int startVertex, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startVertex);
        visited[startVertex] = true;

        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
            bfsAnswer.append(curVertex + " ");

            for(int neighbor : graph[curVertex]) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    static void DFS(int startVertex, ArrayList<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while(!stack.isEmpty()) {
            int curVertex = stack.pop();
            if(!visited[curVertex]) {
                dfsAnswer.append(curVertex + " ");
                visited[curVertex] = true;
            }
            // 비재귀 방식에서 작은 번호순으로 출력할려면 스택에 역순으로 삽입해야 함
            for(int i = graph[curVertex].size() - 1; i >= 0; i--) {
                int neighbor = graph[curVertex].get(i);
                if(!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }

        }
    }
}
