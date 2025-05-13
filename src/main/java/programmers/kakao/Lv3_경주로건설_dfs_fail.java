package programmers.kakao;

public class Lv3_경주로건설_dfs_fail {
    // 경주로 건설에 필요한 최소비용을 계산
    // 0,0 -> n-1,n-1 로 이동
    // 코너를 적게 만들어야 최소비용
    // 방문배열을 해당 지점까지의 최소비용으로 갱신
    // 완전 탐색후 n-1, n-1의 값을 반환?
    // 직선도로 = 100, 코너 = 500
    // 칸 이동시 무조건 100 만약 진전 이동방향과 다를 경우 + 500
    // 방문배열에 해당지점으로 어떻게 왔는지정보 + 그렇게 왔을때의 비용을 표시하는데 그중 최소비용을 작성

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] board = {
            {0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0,0},
            {0,0,0,1,0,0,0,1},
            {0,0,1,0,0,0,1,0},
            {0,1,0,0,0,1,0,0},
            {1,0,0,0,0,0,0,0}};

//    static int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
    static boolean[][] visited;
    static int[][][] price;
    static int size;
    static int minPrice = Integer.MAX_VALUE;

    static void dfs(int[][] board, int r, int c) {
        int[] priceAndDir = price[r][c];
        if(r == size -1 && c == size -1) {
            minPrice = Math.min(minPrice, priceAndDir[0]);
            return;
        }

        for(int[] dir : dirs) {
            int nextRow = r + dir[0];
            int nextCol = c + dir[1];

            if(nextRow >= 0 && nextRow < size && nextCol >= 0 && nextCol < size
                    && !visited[nextRow][nextCol]
                    && board[nextRow][nextCol] == 0) {
                int nextPrice = priceAndDir[0];
                if (r == 0 && c == 0) { // 처음 진입
                    nextPrice += 100;
                } else if (priceAndDir[1] != dir[0] || priceAndDir[2] != dir[1]) {
                    nextPrice += 600;
                } else {
                    nextPrice += 100;
                }

                if(price[nextRow][nextCol][0] < nextPrice) {
                    continue;
                }

                price[nextRow][nextCol][0] = nextPrice;
                price[nextRow][nextCol][1] = dir[0];
                price[nextRow][nextCol][2] = dir[1];
                visited[nextRow][nextCol] = true;
                dfs(board, nextRow, nextCol);
                visited[nextRow][nextCol] = false;
            }
        }
    }

    public static int solution(int[][] board) {
        size = board.length;
        visited = new boolean[size][size];
        price = new int[size][size][3]; // 해당칸을 어떻게 왔는지 + 그렇게 왔을때의 비용
        // visited[next][next][] -> visited[cur][cur][] 의 정보를 확인하고 방향이 같다면 + 100, 아니라면 + 600
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                price[i][j][0] = Integer.MAX_VALUE;
                price[i][j][1] = -1;
                price[i][j][2] = -1;
            }
        }
        price[0][0][0] = 0;

        dfs(board, 0, 0);
        return minPrice;
    }

    public static void main(String[] args) {
        solution(board);
        System.out.println(minPrice);
    }
}
