package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_17135_캐슬디펜스_fail {
    //todo
    static int n;
    static int m;
    static int d;
    static int[][] initMap;

    static int[][] dirs = new int[][]{{1, 0}, {0, -1}, {0, 1}};


    static int[][] nextTurn(int[][] map){
        int[][] newMap = new int[n + 1][m];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    if (i + 1 < n) {
                        newMap[i + 1][j] = 1; // 적들은 한칸씩 아래
                    }
                }
                if (map[i][j] == -1) {
                    newMap[i][j] = -1; // 궁수들은 제자리 유지
                }
            }
        }

        return newMap;
    }

    // 궁수 배치하기 -> 조합
    static void placeArcher(int depth, int now, ArrayList<Integer> result) {
        if(depth == 3){
            initMap(result);
            return;
        }
        for (int i = now; i < m; i++) {
            result.add(i);
            placeArcher(depth + 1, i+1, result);
            result.remove(result.size() - 1);

        }

    }

    static void initMap(ArrayList<Integer> archer){
        int[][] map = new int[n+1][m];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                map[i][j] = initMap[i][j];
            }
        }

        for (int i = 0; i < archer.size(); i++) {
            map[n][archer.get(i)] = -1;
        }

        startGame(map, 0);
    }

    static void startGame(int[][] map, int kill){
        boolean finished = true;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    finished = false;
                }
            }
        }
        if(finished){
            System.out.println(kill);
            return;
        }

        int count = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[n+1][m];
        Arrays.fill(visited, -1);

        for(int i = 0; i < m; i++){
            if(map[n][i] == -1){
                queue.add(new int[]{n, i});
                visited[n][i] = 0;
            }
        }

        while(!queue.isEmpty()){
            if(count == 3) break;
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if(visited[row][col] == d) continue;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == -1){
                    if(map[newRow][newCol] == 1){
                        count++;
                        map[newRow][newCol] = 0;
                    } else {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = visited[row][col] + 1;
                    }
                }
            }
        }

        startGame(nextTurn(map), kill + count);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        initMap = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                initMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        placeArcher(0, 0, new ArrayList<>());
    }
}
