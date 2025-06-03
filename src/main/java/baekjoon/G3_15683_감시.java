package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G3_15683_감시 {

    /**
     * 1 번 : 한방향
     * 2 번 : 두방향 (서로 반대)
     * 3 번 : 두방향 (서로 직각)
     * 4 번 : 세방향
     * 5 번 : 네방향
     * 지도에서 0은 빈칸
     * 1 ~ 5 : cctv
     * 6 : 벽
     * 감시가능 영역 #
     * cctv는 통과 가능
     * 사각 지대의 최소 크기를 구해라
     * cctv 회전은 항상 90도로 가능
     */
    static int[][][] directions = {
            {}, // 0번 없음
            { {0}, {1}, {2}, {3} },                         // 1번
            { {0, 2}, {1, 3} },                             // 2번
            { {0, 1}, {1, 2}, {2, 3}, {3, 0} },             // 3번
            { {0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1} }, // 4번
            { {0, 1, 2, 3} }                                // 5번
    };


    // index 0 -> 상 / 1 -> 우 / 2 -> 하 / 3 -> 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    // 입력순으로 cctv의 좌표를 저장할 list
    static ArrayList<int[]> cctvList = new ArrayList<>();
    // 좌상단 부터 우하단 방향으로 cctv에 순서를 지정하여 위치정보 저장
    // index : 0 -> cctv 타입 (1 ~ 5) / 1 -> row / 2 -> col

    // 입력되는 cctv 타입별로 가지수가 정해짐
    // 1번 : 4방향
    // 2번 : 2방향
    // 3번 : 4방향
    // 4번 : 4방향
    // 5번 : 1방향
    // ex) 1번 2개 3번 2개 5번 1개라면 cctv의 방향의 총 가짓수는 4 * 4 * 4 * 4 * 1 = 256가지
    // 0 ~ 255 의 정수 하나로 cctv 상태를 표현할 수 있음
    // cctv 배열에 입력된 cctv의 타입 순서가 1 , 1 , 3, 5 , 3 이고
    // 정수 124 면
    // 각 cctv 상태를 나타내면 아래와 같음

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cctv = map[i][j];
                if (cctv != 0 && cctv != 6) {
                    cctvList.add(new int[]{cctv, i, j});
                }
            }
        }

        // 총 가짓수
        int caseCount = 1;
        int min = Integer.MAX_VALUE;

        for (int[] cctv : cctvList) {
            int type = cctv[0];
            caseCount *= directions[type].length;
        }

        for(int i = 0; i < caseCount; i++) {
            int curDirNum = i;
            int[][] curMap = copyMap(map);

            for(int[] cctv : cctvList) {
                int type = cctv[0];
                int row = cctv[1];
                int col = cctv[2];

                int curDirCase = curDirNum % directions[type].length;

                int[] curDirs = directions[type][curDirCase];

                for (int dir : curDirs) {
                    simulation(row, col, dir, curMap);
                }


                curDirNum /= directions[type].length;

            }

            min = Math.min(min, countMap(curMap));
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }

    }

    // 시작지와 방향을 주면 해당 방향으로 감시영역을 표시하기
    static void simulation(int startRow, int startCol, int dir, int[][] map) {
        int nextRow = startRow + dr[dir];
        int nextCol = startCol + dc[dir];

        while(nextRow >= 0 && nextCol >= 0 && nextRow < map.length && nextCol < map[0].length) {
            if(map[nextRow][nextCol] == 6) {
                break;
            }

            if(map[nextRow][nextCol] == 0) {
                map[nextRow][nextCol] = 7;
            }

            nextRow += dr[dir];
            nextCol += dc[dir];
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int countMap(int[][] map) {
        int sum = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

}
