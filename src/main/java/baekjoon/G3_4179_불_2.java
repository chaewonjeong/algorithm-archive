package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class G3_4179_불_2 {
    public static void main(String[] args) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] maps = new char[R][C];
        int[][] fireVisited = new int[R][C];
        int[][] jihoonVisited = new int[R][C];

        for(int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < C; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        // bfs 따로 돌려주자
        // 불부터
        Queue<int[]> fireQueue = new ArrayDeque<>();
        Queue<int[]> jihoonQueue = new ArrayDeque<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(maps[i][j] == 'J') {
                    jihoonQueue.add(new int[]{i, j});
                    jihoonVisited[i][j] = 1;
                }
                if(maps[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireVisited[i][j] = 1;
                }
            }
        }

        while(!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int row = current[0];
            int col = current[1];

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                && maps[newRow][newCol] == '.' && fireVisited[newRow][newCol] == 0) {
                    fireVisited[newRow][newCol] = fireVisited[row][col] + 1;
                    fireQueue.add(new int[]{newRow, newCol});
                }
            }
        }

        while(!jihoonQueue.isEmpty()) {
            int[] current = jihoonQueue.poll();
            int row = current[0];
            int col = current[1];
            if(row == 0 || col == 0 || row == R - 1 || col == C - 1) {
                System.out.println(jihoonVisited[row][col]);
                return;
            }

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                        && maps[newRow][newCol] == '.' && jihoonVisited[newRow][newCol] == 0
                        && (fireVisited[newRow][newCol] == 0 || jihoonVisited[row][col] + 1 < fireVisited[newRow][newCol])) { // 지훈이 도착하기전에 불이 도달하면 안됨
                    jihoonVisited[newRow][newCol] = jihoonVisited[row][col] + 1;
                    jihoonQueue.add(new int[]{newRow, newCol});
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
