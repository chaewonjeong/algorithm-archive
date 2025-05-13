package baekjoon;

import java.util.Scanner;

public class S1_11403_경로찾기 {

    static void dfs(int[][] adjMatrix, int[][] answer, boolean[] visited, int start, int current) {
        if (start != current) {
            answer[start][current] = 1;
        }
        visited[current] = true;

        for (int i = 0; i < adjMatrix.length; i++) {
            if(adjMatrix[current][i] == 1 && start == i){
                answer[start][i] = 1;
            }
            if (adjMatrix[current][i] == 1 && !visited[i]) {
                dfs(adjMatrix, answer, visited, start, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        int n = sc.nextInt(); // 정점의 갯수

        int[][] adjMatrix = new int[n][n];
        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }
        // i -> j 의 경로가 존재하는지 확인
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(adjMatrix, answer, visited, i, i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }


    }
}
