package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7569_토마토 {
    static int[][] dirs = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};
    // 시작점이 여러개인 bfs -> 모든 시작점을 큐에 넣고 시작
    // 1 : 익은 토마토
    // 0 : 익지 않은 토마토
    // -1 : 토마토 없는 곳
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[n][m][h];
        int[][][] visited = new int[n][m][h];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int height = 0; height < h; height++){
            for(int row = 0; row < n; row++){
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < m; col++){
                    int tomato = Integer.parseInt(st.nextToken());
                    box[row][col][height] = tomato;

                    if(tomato == -1){
                        visited[row][col][height] = -50; // 토마토 없는곳은 -50
                    } else {
                        visited[row][col][height] = -1; // 나머지는 -1로 초기화
                    }
                }
            }
        }

        for(int height = 0; height < h; height++){
            for(int row = 0; row < n; row++){
                for(int col = 0; col < m; col++){
                    if(box[row][col][height] == 1){
                        queue.add(new int[]{row, col, height});
                        visited[row][col][height] = 0;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int height = current[2];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                int newHeight = height + dir[2];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && newHeight >= 0 && newHeight < h){
                    if(box[newRow][newCol][newHeight] == 0 && visited[newRow][newCol][newHeight] == -1){
                        box[newRow][newCol][newHeight] = 1;
                        visited[newRow][newCol][newHeight] = visited[row][col][height] + 1;
                        queue.add(new int[]{newRow, newCol, newHeight});
                    }
                }
            }
        }

        int max = 0;

        for(int height = 0; height < h; height++){
            for(int row = 0; row < n; row++){
                for(int col = 0; col < m; col++){
                    if(visited[row][col][height] == -1){
                        System.out.println(-1);
                        return;
                    } else {
                        max = Math.max(max, visited[row][col][height]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
