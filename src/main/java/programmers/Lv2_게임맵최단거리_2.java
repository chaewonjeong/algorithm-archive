package programmers;

public class Lv2_게임맵최단거리_2 {
    static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int n, m;
    static int minLength = Integer.MAX_VALUE;

    static void dfs(int x, int y, int count, int[][] maps, boolean[][] visited){
        if (x == n - 1 && y == m - 1){
            minLength = Math.min(minLength, count);
            return;
        }

        visited[x][y] = true;

        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, count + 1, maps, visited);
            }
        }
        visited[x][y] = false;
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        dfs(0, 0, 1, maps, visited);

        if(minLength == Integer.MAX_VALUE){
            return -1;
        } else {
            return minLength;
        }
    }
}
