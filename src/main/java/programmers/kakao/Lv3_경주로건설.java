package programmers.kakao;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lv3_경주로건설 {
    // 경주로 건설에 필요한 최소비용을 계산
    // 0,0 -> n-1,n-1 로 이동
    // 코너를 적게 만들어야 최소비용
    // 방문배열을 해당 지점까지의 최소비용으로 갱신
    // 완전 탐색후 n-1, n-1의 값을 반환?
    // 직선도로 = 100, 코너 = 500
    // 칸 이동시 무조건 100 만약 진전 이동방향과 다를 경우 + 500
    // 방문배열에 해당지점으로 어떻게 왔는지정보 + 그렇게 왔을때의 비용을 표시하는데 그중 최소비용을 작성

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board = {
            {0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,1,0,0,0,1,0},
            {0,1,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0}};

    //static int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
    //static boolean[][][] visited;
    static int[][][] price;
    static int size;
    static final int INF = 0x3f3f3f3f;
    static int minPrice = INF;

    static void bfs(int[][] board, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c, -1});


        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dir = cur[2];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newRow < size && newCol >= 0 && newCol < size
                        && board[newRow][newCol] == 0) {
                    int newPrice;

                    if (dir == -1 || dir == i) {
                        if (dir == -1) {
                            newPrice = price[row][col][i] + 100; // 처음 출발
                        } else {
                            newPrice = price[row][col][dir] + 100; // 같은 방향으로 직선 이동
                        }
                    } else {
                        newPrice = price[row][col][dir] + 600; // 코너(방향 전환)
                    }

                    if (price[newRow][newCol][i] > newPrice) {
                        price[newRow][newCol][i] = newPrice;
                        queue.add(new int[]{newRow, newCol, i});
                    }
                }
            }

        }

    }

    public static int solution(int[][] board) {
        size = board.length;
        price = new int[size][size][4]; // 0:상 / 1:하 / 2:좌 / 3:우

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                price[i][j][0] = INF;
                price[i][j][1] = INF;
                price[i][j][2] = INF;
                price[i][j][3] = INF;
            }
        }

        price[0][0][0] = 0;
        price[0][0][1] = 0;
        price[0][0][2] = 0;
        price[0][0][3] = 0;

        bfs(board, 0, 0);
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, price[size - 1][size - 1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(board));

    }
}
