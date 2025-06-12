package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_6593_상범빌딩 {

    static int[][] dirs = {
            {0, -1, 0}, // 상 (북) - 위쪽 행
            {0, 1, 0},  // 하 (남) - 아래쪽 행
            {0, 0, -1}, // 좌 (서) - 왼쪽 열
            {0, 0, 1},  // 우 (동) - 오른쪽 열
            {-1, 0, 0}, // 위 - 층 감소 (더 높은 층)
            {1, 0, 0}   // 아래 - 층 증가 (더 낮은 층)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char[][][] building = new char[L][R][C];
            int[][][] visited = new int[L][R][C];


            int[] start = new int[3];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = line.charAt(c);
                        if(building[l][r][c] == 'S'){
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        } else if (building[l][r][c] == '#') {
                            visited[l][r][c] = 1;
                        }
                    }
                }
                br.readLine(); // 층 사이 빈 줄
            }

            int escape = -1;
            //****************************************
            // bfs

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{start[0], start[1], start[2]});
            //visited[start[0]][start[1]][start[2]] = 1;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int level = cur[0];
                int row = cur[1];
                int col = cur[2];

                if(building[level][row][col] == 'E'){
                    escape = visited[level][row][col];
                    break;
                }

                for (int[] dir : dirs) {
                    int newLevel = level + dir[0];
                    int newRow = row + dir[1];
                    int newCol = col + dir[2];

                    if(newLevel >= 0 && newLevel < L && newRow >= 0 && newRow < R && newCol >= 0 && newCol < C){
                        if(visited[newLevel][newRow][newCol] == 0
                                && (building[newLevel][newRow][newCol] == '.' || building[newLevel][newRow][newCol] == 'E')){
                            queue.add(new int[]{newLevel, newRow, newCol});
                            visited[newLevel][newRow][newCol] = visited[level][row][col] + 1;
                        }
                    }
                }

            }
            if (escape == -1) {
                sb.append("Trapped!").append('\n');
            } else {
                sb.append("Escaped in " + escape + " minute(s).").append('\n');
            }


            //****************************************



        }

        System.out.println(sb.toString());

    }
}
