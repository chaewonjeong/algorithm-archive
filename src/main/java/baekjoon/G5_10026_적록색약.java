package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class G5_10026_적록색약 {
    // 적록색약인 사람과 아닌사람이 그림을 봤을 때 보이는 구역
    // 적록색약인 사람 -> R 과 G를 같이 탐색하면 됨

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int sol(char[][] map, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        char color = map[row][col];

                        for(int[] dir : dirs){
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            if(newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length) {
                                char newColor = map[newRow][newCol];
                                if(!visited[newRow][newCol] && newColor == color) {
                                    queue.add(new int[]{newRow, newCol});
                                    visited[newRow][newCol] = true;
                                }
                            }
                        }
                    }
                    count++;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int ans1 = sol(map,new boolean[n][n]);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'R' || map[i][j] == 'G') {
                    map[i][j] = 'X';
                }
            }
        }

        int ans2 = sol(map,new boolean[n][n]);

        System.out.println(ans1 + " " + ans2);
    }
}
