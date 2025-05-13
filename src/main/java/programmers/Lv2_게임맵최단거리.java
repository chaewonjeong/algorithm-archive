package programmers;
import java.util.ArrayDeque;
import java.util.Queue;

public class Lv2_게임맵최단거리 {

        static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        static int[][] visited;

        public int solution(int[][] maps) {

            int n = maps.length; //행
            int m = maps[0].length; //열

            visited = new int[n][m];
            Queue<int[]> queue = new ArrayDeque<>();

            queue.add(new int[]{0, 0});
            visited[0][0] = 1; // 시작점 거리 1

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if (row == n - 1 && col == m - 1) {
                    return visited[row][col]; // 도착시 최소 거리 -> 레벨 탐색이므로
                }
                for (int[] dir : dir) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && maps[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                        visited[newRow][newCol] = visited[row][col] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }

            return -1;
        }


}
