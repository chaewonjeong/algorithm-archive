package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class G3_4179_불 {
    public static void main(String[] args) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); // 행
        int C = sc.nextInt(); // 열
        sc.nextLine();

        // 아이디어....
        // bfs를 한차례 다르게 적용하는거야 우선 불부터 움직여놓고 같은사이클에 지훈이가 이동가능한지 보는거지
        // visited 배열은 공용으로 쓰되 bfs를 따로 돌린다....
        // 근데 큐에 넣는 순서로 순서가 보장되는가...?? -> yes
        // 불부터 넣으면 항상 불부터 순회하고 지훈이가 다시 팝이 되는거 아니야?
        // 아니면 불큐랑 지훈큐를 따로 둬야하나.. ??
        // 한번의 반복일때 불큐에서 한번 팝 지훈큐에서 한번 팝..
        // 일단 순서가 보장되니깐 하나의 큐에 넣어도 상관없을거 같음 한번 해보자
        // 근데 이렇게하면 불의 이동동선과 지훈의 이동동선을 구분할 수 없는데....

        // 결론
        // 큐뿐만 아니라 bfs를 따로 돌리기 -> 해당 칸에 불이 도달하는 시간을 저장하고 지훈 bfs를 돌릴때 검증하기

        char[][] maps = new char[R][C];

        int[][] fireVisited = new int[R][C];
        int[][] jihoonVisited = new int[R][C];

        Queue<int[]> fireQueue = new ArrayDeque<>();
        Queue<int[]> jihoonQueue = new ArrayDeque<>();

        for(int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < C; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(maps[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j}); // 불부터 넣어줘
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(maps[i][j] == 'J') {
                    jihoonQueue.add(new int[]{i, j}); // 지훈이 위치 넣어줘 그다음에 돌리면 될꺼 같은데.. ?
                }

            }
        }

        while(!fireQueue.isEmpty()) {
            int[] cur = fireQueue.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                        && maps[newRow][newCol] == '.' && fireVisited[newRow][newCol] == 0) {
                    fireVisited[newRow][newCol] = fireVisited[row][col] + 1;
                    fireQueue.add(new int[]{newRow, newCol});
                }
            }
        }

        while(!jihoonQueue.isEmpty()) {
            int[] cur = jihoonQueue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
                        && maps[newRow][newCol] == '.' && jihoonVisited[newRow][newCol] == 0){

                }
            }

        }

        System.out.println("IMPOSSIBLE");

    }
}
