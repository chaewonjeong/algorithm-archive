package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class G5_7576_토마토 {
    // 토마토가 모두 익은 최소 날짜 출력
    // 모든 토마토가 익지 못하는 상황이면 -1
    // 1은 익은 토마토
    // 0 은 익지 않은 토마토
    // -1 은 비어있는 칸이다.

    // 모든 1에서 동시에 출발해야함 -> 시작점이 여러개인 BFS는 모든 시작점을 큐에 넣고 시작하면 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // col
        int n = sc.nextInt(); // row
        int answer = 0;

        int[][] maps = new int[n][m];
        int[][] dist = new int[n][m]; // 일단 다 0으로 초기화

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maps[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i][j] == 1){ // 익은 토마토 모두 큐에 넣기
                    queue.add(new int[]{i, j});
                } else if(maps[i][j] == 0){
                    dist[i][j] = -1; // 익지 않은 토마토가 있는곳은 -1 로 초기화
                }
            }
        }

        // bfs
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir : dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                    && maps[newRow][newCol] == 0 && dist[newRow][newCol] == -1){
                    queue.add(new int[]{newRow, newCol});
                    dist[newRow][newCol] = dist[row][col] + 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer = Math.max(answer, dist[i][j]);
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}
