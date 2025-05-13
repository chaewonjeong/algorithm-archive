package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_17135_캐슬디펜스 {

    static int[][] initMap;
    static ArrayList<ArrayList<Integer>> archerIdxList = new ArrayList<>();
    static int n;
    static int m;
    static int d;
    static int maxKill = Integer.MIN_VALUE;
    static int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}};

    static void placeArcher(int depth, int now, ArrayList<Integer> result){
        if(depth == 3){
            archerIdxList.add(new ArrayList<>(result));
            return;
        }

        for (int i = now; i < m; i++) {
            result.add(i);
            placeArcher(depth + 1, i + 1, result);
            result.remove(result.size() - 1);
        }
    }

    static int startGame(ArrayList<Integer> archerIndex){
        int kill = 0;

        int[][] map = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = initMap[i][j];
            }
        }

        init(map, archerIndex);

//        for (int t = 0; t < n; t++) {
//            HashSet<String> targets = new HashSet<>();
//
//            for (int archerCol : archerIndex) {
//                boolean[][] visited = new boolean[n + 1][m];
//                Queue<int[]> queue =new ArrayDeque<>();
//
//                queue.add(new int[]{n, archerCol, 0}); // 궁수 위치를 직접 add
//
//                while (!queue.isEmpty()) {
//                    int[] cur = queue.poll();
//                    int row = cur[0];
//                    int col = cur[1];
//                    int dist = cur[2];
//
//
//
//                    if (map[row][col] == 1) {
//                        targets.add(row + "," + col);
//                        break; // 이 궁수는 이 적을 쏨
//                    }
//                    if (dist >= d) continue;
//
//                    for (int[] dir : dirs) {
//                        int newRow = row + dir[0];
//                        int newCol = col + dir[1];
//
//                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
//                            visited[newRow][newCol] = true;
//                            queue.add(new int[]{newRow, newCol, dist + 1});
//                        }
//                    }
//                }
//            }
//
//            for (String pos : targets) {
//                String[] parts = pos.split(",");
//                int r = Integer.parseInt(parts[0]);
//                int c = Integer.parseInt(parts[1]);
//
//                if (map[r][c] == 1) {
//                    kill++;
//                    map[r][c] = 0;
//                }
//            }
//
//            for (int i = n - 1; i > 0; i--) {
//                map[i] = Arrays.copyOf(map[i - 1], m);
//            }
//            Arrays.fill(map[0], 0); // 맨 윗줄은 비움
//        }


        for (int i = n; i > 0; i--) {
            Set<String> killSet = new HashSet<>();


            for(int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                int[][] visited = new int[i + 1][m];
                Queue<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int row = cur[0];
                    int col = cur[1];


                    for (int[] dir : dirs) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        // newRow의 범위를 i 보다 작게 한정해서 궁수 양옆으로의 탐색 x
                        if (newRow >= 0 && newRow < i && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0 && visited[row][col] < d) {
                            if (map[newRow][newCol] == 1) {
                                // 이곳에서 바로 죽여버려서 여러 궁수들이 하나의 적에대해 중복으로 죽이는 처리를 하지 못함...
                                // 문제 조건 : 여러 궁수가 하나의 적을향해 쏠 수 있음....
                                // 해결 -> 탐지한 적의 좌표를 저장해두고 중복 제거후 kill 처리
//                                kill++;
//                                map[newRow][newCol] = 0;
                                killSet.add(newRow + "," + newCol);
                                continue;
                            }
                            visited[newRow][newCol] = visited[row][col] + 1;
                            queue.add(new int[]{newRow, newCol});

                        }
                    }
                }

                for (String pos : killSet) {
                    String[] parts = pos.split(",");
                    int r = Integer.parseInt(parts[0]);
                    int c = Integer.parseInt(parts[1]);

                    if (map[r][c] == 1) {
                        kill++;
                        map[r][c] = 0;
                    }
                }
                killSet.clear();
            }

            // 적을 내리는 대신에 궁수를 전진
            for (int j = 0; j < m; j++) {

                map[i - 1][j] = map[i][j];
            }
        }

        return kill;
    }

    static void init(int[][] map, ArrayList<Integer> archerIndex){
        for(int idx : archerIndex){
            map[n][idx] = 1;
        }
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
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                initMap[i][j] = tmp;
            }
        }

        placeArcher(0,0, new ArrayList<>());

        for(ArrayList<Integer> list : archerIdxList){
            maxKill= Math.max(maxKill, startGame(list));
        }

        System.out.println(maxKill);

    }
}
