package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S1_2178_미로탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] maps = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        // 각각의 수들이 붙어서 입력으로 주어진다고 했음
        // readLine으로 읽어서 charAt으로 넣자..;
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < m; j++) {
                maps[i][j] = str.charAt(j) - '0';
            }
        }

        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            if(row == n - 1 && col == m - 1) {
                System.out.println(visited[row][col]);
                return;
            }

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                && visited[newRow][newCol] == 0 && maps[newRow][newCol] == 1) {
                    visited[newRow][newCol] = visited[row][col] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return;

    }
}
