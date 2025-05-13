package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_2583_영역구하기 {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    static void draw(int a, int b, int c, int d) {
        for (int i = b; i < d; i++) {
            for(int j = a; j < c; j++) {
                visited[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            draw(a, b, c, d);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                if (!visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        count++;
                        int row = cur[0];
                        int col = cur[1];

                        for(int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                                if(!visited[newRow][newCol]) {
                                    queue.add(new int[]{newRow, newCol});
                                    visited[newRow][newCol] = true;
                                }
                            }
                        }
                    }
                    answer.add(count);
                }

            }
        }

        System.out.println(answer.size());
        // collection 을 정렬하는 방법 기억좀 하자!!!;;
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int num : answer) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);

    }
}
