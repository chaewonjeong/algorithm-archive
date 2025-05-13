package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_7562_나이트의이동 {
    static int[][] dirs = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            int[][] visited = new int[l][l];
            for(int j = 0; j < l; j++) {
                Arrays.fill(visited[j], -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited[a][b] = 0;

            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());


            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{a, b});

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                if(row == c && col == d) {
                    System.out.println(visited[row][col]);
                    break;
                }

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newRow < l && newCol >= 0 && newCol < l && visited[newRow][newCol] == -1) {

                        visited[newRow][newCol] = visited[row][col] + 1;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }


        }
    }
}
