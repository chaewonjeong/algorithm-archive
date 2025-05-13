package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_14500_테트로미노 {

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int[][] map;
    static int max = 0;
    static int n, m;

    static void dfs(int i, int j, int depth, int result) {
        if (depth == 4) {
            max = Math.max(max, result);
            return;
        }


        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];

            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                if(!visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    dfs(newI, newJ, depth +1, result + map[newI][newJ]);
                    visited[newI][newJ] = false;
                }
            }
        }
    }

    static void sol(int i, int j){
        ArrayList<Integer> list = new ArrayList<>();
        int cur = map[i][j];
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                list.add(map[newI][newJ]);
            }
        }

        if(list.size() < 3) return;

        if(list.size() == 3) {
            for(int n : list){
                cur += n;
            }
        } else {
            int min = list.stream().min(Integer::compareTo).get();
            for(int n : list){
                cur += n;
            }
            cur -= min;
        }

        max = Math.max(max, cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                sol(i, j);
            }
        }

        System.out.println(max);

        
    }
}
