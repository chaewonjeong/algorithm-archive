package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S1_1926_그림 {
    // 도화지에 그려진 그림의 개수와 그 그림들 중 가장 큰 그림을 출력할 것
    public static void main(String[] args) {
        Queue<int[]> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int countPictures = 0;
        int max = 0;

        int n = sc.nextInt(); // 그림의 세로 크기
        int m = sc.nextInt(); // 그림의 가로 크기

        int[][] maps = new int[n][m];
        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(maps[i][j] == 1 && visited[i][j] == 0) {
                    int count = 1; // 첫 칸도 한칸으로 세야함
                    visited[i][j] = 1;

                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int row = current[0];
                        int col = current[1];

                        for(int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                            && visited[newRow][newCol] == 0 && maps[newRow][newCol] == 1) {
                                visited[newRow][newCol] = 1;
                                queue.add(new int[]{newRow, newCol});
                                count++;
                            }
                        }
                    }
                    countPictures++;
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(countPictures);
        System.out.println(max);
    }
}
