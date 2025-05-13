package baekjoon;

import java.util.Scanner;

public class S1_11403_경로찾기_2 {
    static int n;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 정점 개수
        graph = new int[n][n];

        // 그래프 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 모든 정점에서 DFS 수행
        for (int i = 0; i < n; i++) {
            visited = new boolean[n]; // 방문 여부 배열 초기화
            dfs(i, i);
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    // DFS를 활용하여 i에서 j로 갈 수 있는지 탐색
    // i -> i 번째 입력 배열이 모두 0이라고 문제 조건에 적혀있음
    static void dfs(int start, int v) {
        for (int j = 0; j < n; j++) {
            if (graph[v][j] == 1 && !visited[j]) { // v에서 j로 갈 수 있고 방문하지 않았다면
                visited[j] = true;
                graph[start][j] = 1; // start에서 j로 가는 경로 존재
                dfs(start, j); // j를 새로운 시작점으로 DFS 수행
            }
        }
    }

}
