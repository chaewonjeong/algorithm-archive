package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_4963_섬의개수 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        // w, h <= 50;
        // 1 : 땅, 0 : 바다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[][] maps;
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break; // 종료

            maps = new int[h][w];
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(maps[i][j] == 0 || visited[i][j]) continue;

                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];

                        for(int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if(newRow >= 0 && newRow < h && newCol >= 0 && newCol < w
                                    && maps[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                                queue.add(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
