package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2468_안전영역 {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];


        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int len = Integer.parseInt(st.nextToken());
                min = Math.min(min, len);
                max = Math.max(max, len);
                map[i][j] = len;
            }
        }

        for (int k = min; k <= max; k++) {
            int[][] visited = extracted(n, map, k);
            maxCount = Math.max(maxCount,getCount(n, visited));
        }
        System.out.println(maxCount);
    }

    private static int getCount(int n, int[][] visited) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Queue<int[]> queue = new ArrayDeque<>();
                if(visited[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    count++;

                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];

                        for(int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0) {
                                queue.add(new int[]{newRow, newCol});
                                visited[newRow][newCol] = 1;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int[][] extracted(int n, int[][] map, int k) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] <= k){
                    visited[i][j] = 1;
                }
            }
        }
        return visited;
    }

    static void bfs(int[][] map, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
    }
}
