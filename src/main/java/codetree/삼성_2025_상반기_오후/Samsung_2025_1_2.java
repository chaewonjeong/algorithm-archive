package codetree.삼성_2025_상반기_오후;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Samsung_2025_1_2 {

    static void insertMicrobe(int[][] board, int microbe, HashMap<Integer, HashSet<String>> microbes, HashMap<Integer,Integer> microbesSize,int r1, int c1, int r2, int c2) {
        int count = 0;

        for(int i = r1; i < r2; i++) {
            for(int j = c1; j < c2; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = microbe;
                    microbes.computeIfAbsent(microbe, k -> new HashSet<>()).add(i + "," + j);
                } else {
                    int preMicrobe = board[i][j];

                    //if(!microbes.containsKey(preMicrobe))continue;

                    microbes.get(preMicrobe).remove(i + "," + j);
                    int updatedSize = microbesSize.get(preMicrobe) - 1;

                    if (updatedSize == 0) {
                        microbes.remove(preMicrobe);
                        microbesSize.remove(preMicrobe);
                    } else {
                        microbesSize.put(preMicrobe, updatedSize);
                    }


                    microbes.computeIfAbsent(microbe, k -> new HashSet<>()).add(i + "," + j);
                    board[i][j] = microbe;
                }
                count++;
            }
        }

        microbesSize.put(microbe, count);
    }

    static void checkMicrobeArea(int[][] board, HashMap<Integer, HashSet<String>> microbes, HashMap<Integer,Integer> microbesSize) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        HashMap<Integer, int[]> microbesStartPoint = new HashMap<>();
        int[][] visited = new int[board.length][board.length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || visited[i][j] == 1) continue;

                int currentMicrobe = board[i][j];

                if(microbesStartPoint.containsKey(currentMicrobe)) {
                    deleteMicrobe(board, currentMicrobe, i, j);
                    deleteMicrobe(board, currentMicrobe, microbesStartPoint.get(currentMicrobe)[0], microbesStartPoint.get(currentMicrobe)[1]);
                    // 먹혀버린 미생물은 삭제
                    microbesStartPoint.remove(currentMicrobe);
                    microbes.remove(currentMicrobe);
                    microbesSize.remove(currentMicrobe);
                    continue;
                }

                Queue<int[]> queue = new ArrayDeque<>();
                microbesStartPoint.put(currentMicrobe, new int[]{i,j});

                queue.add(new int[]{i,j});
                visited[i][j] = 1;

                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int row = cur[0];
                    int col = cur[1];

                    for(int[] dir : dirs) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length
                                && visited[newRow][newCol] == 0 && board[newRow][newCol] == currentMicrobe) {
                            visited[newRow][newCol] = 1;
                            queue.add(new int[]{newRow,newCol});
                        }
                    }
                }
            }
        }
    }

    // 이동
    static int[][] microbeMove(int[][] board, HashMap<Integer, HashSet<String>> microbes, HashMap<Integer, Integer> microbesSize) {
        int[][] newBoard = new int[board.length][board.length];

        ArrayList<Map.Entry<Integer,Integer>> sorted = microbesSize.entrySet().stream()
                .sorted(
                        Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).reversed()
                                .thenComparingInt(Map.Entry::getKey)
                )
                .collect(Collectors.toCollection(ArrayList::new));


        for (Map.Entry<Integer, Integer> entry : sorted) {
            // 크기가 큰 순서
            int microbe = entry.getKey();
            boolean isValid = false;

            ArrayList<String> microbeLocationInfo = microbes.get(microbe).stream().sorted(Comparator.comparing((String r) -> Integer.parseInt(r.split(",")[0]))
                    .thenComparing((String c) -> Integer.parseInt(c.split(",")[1]))).collect(Collectors.toCollection(ArrayList::new));

            int[] firstPosition = new int[] {Integer.parseInt(microbeLocationInfo.get(0).split(",")[0]), Integer.parseInt(microbeLocationInfo.get(0).split(",")[1])};

            for(int i = 0; i < board.length && !isValid; i++) {
                for(int j = 0; j < board.length; j++) {
                    if(newBoard[i][j] == 0) {
                        int[][] tempBoard = cloneBoard(newBoard);
                        int diffRow = firstPosition[0] - i;
                        int diffCol = firstPosition[1] - j;
                        boolean isMoved = true;

                        ArrayList<int[]> changedPositions = microbeLocationInfo.stream().map(s-> {
                            int r = Integer.parseInt(s.split(",")[0]);
                            int c = Integer.parseInt(s.split(",")[1]);
                            return new int[]{r - diffRow, c - diffCol};
                        }).collect(Collectors.toCollection(ArrayList::new));

                        for(int[] changedPosition : changedPositions) {
                            int newRow = changedPosition[0];
                            int newCol = changedPosition[1];

                            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length){
                                if(newBoard[newRow][newCol] == 0) {
                                    tempBoard[newRow][newCol] = microbe;
                                } else {
                                    isMoved = false;
                                    break;
                                }
                            }
                        }
                        if(isMoved) {
                            newBoard = tempBoard;
                            // 새 좌표 정보 수정
                            HashSet<String> newLocation = new HashSet<>();
                            for(int[] changedPosition : changedPositions) {
                                int newRow = changedPosition[0];
                                int newCol = changedPosition[1];
                                newLocation.add(newRow + "," + newCol);
                            }
                            microbes.put(microbe, newLocation);

                            isValid = true;
                            break;
                        }
                    }
                }
            }
            // 어디로도 옮길 수 없으면
            if(!isValid){
                microbes.remove(microbe);
                microbesSize.remove(microbe);
            }

        }
        return newBoard;
    }


    static int[][] cloneBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board.length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    static void deleteMicrobe(int[][] board, int microbe, int startR, int startC) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{startR,startC});
        board[startR][startC] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board.length
                        && board[newRow][newCol] == microbe) {
                    board[newRow][newCol] = 0;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 배양용기 크기
        // N 이 최대 15
        int Q = Integer.parseInt(st.nextToken()); // 실험횟수
        // Q 가 최대 50

        // case 별로  bfs 완탐해도 시간초과는 없을 듯

        int[][] board = new int[N + 1][N + 1];
        HashMap<Integer, HashSet<String>> microbes = new HashMap<>();
        HashMap<Integer, Integer> microbesSize = new HashMap<>();

        // 미생물은 사각형으로 (r1, c1) (r2, c2)로 주어짐
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            // 1. 투입
            // << 투입되는 미생물을 저장할 자료구조 >>
            // 미생물 무리의 크기, 미생물 무리의 고유번호(투입 순서, q),
            // 현재 배양요기의 상태를 표기할 board 2차원 3차원 4차원...??

            int microbe = q + 1;
            insertMicrobe(board, microbe, microbes, microbesSize, r1, c1, r2, c2);



            // 겹치는 영역은 나중에 투입 된 녀석으로 대체
            // 겹치는 영역 판별은 어떻게??
            // 겹칠라면 우측하단 (ra2, ca2) 의 각 값들이 무조건 (rb1, cb1)보다 크다
            // 그 크기는 ?? -> (ra2 - rb1 + 1) * (ca2 - cb1 + 1)


            // 영역이 나뉘면 나뉜 지역 삭제 -> 모든 영역 bfs -> 중복 영역일시 해당 영역은 삭제 -> 중복영역 판별은 어떻게?? (해시맵등을 쓰고 val 값에다 bfs 시작위치를 작성)
            // 시작 위치를 받아서 삭제하는 함수 구현
            checkMicrobeArea(board, microbes, microbesSize);



            // 2. 배양용기 이동
            // 크기가 가장 큰 무리를 이동 -> 미생물 무리의 정보를 저장할 자료구조가 필요.. 영역을 String으로 다 저장할까... < Q - "0,0" , "0,1" , ...> : HashMap<Integer, ArrayList<String>> - > get(q).size()
            // 새로 이동할 board를 완탐하면서 미생물 무리의 val 값을 탐색하면서 boar에 넣을 수 있는지 확인 만약 끝까지 갔는데도 못했다면 삭제
            // 보드를 완탐하는 기준은 r과 y가 작은 순
            // 그런 위치가 2개 이상일때는 어떻게하지..? cur의 r,c를 두고 무조건 끝까지 가봐야하나...
            board = microbeMove(board, microbes, microbesSize);




            // 3. 결과 기록
            // 인접한 무리쌍끼리의 곱
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for(Map.Entry<Integer, HashSet<String>> entry : microbes.entrySet()) {
            HashSet<String> set = entry.getValue();
            System.out.print(entry.getKey() + " : " );
            for(String mi : set) {
                System.out.print(mi + " ");
            }
            System.out.println();
        }

        for(Map.Entry<Integer, Integer> entry : microbesSize.entrySet()) {
            int size = entry.getValue();
            System.out.print(entry.getKey() + " : " + size + "\n" );
        }


    }




}
