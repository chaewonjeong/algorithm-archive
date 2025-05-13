package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class S4_1018_체스판다시칠하기 {
    // 변을 공유하면 다른색이어야함

    // 인접한 사각형을 확인하고 바꿔야하면 바꾸고 그 횟수를 기록하자

    // 왼쪽상단이 B으로 시작할때 바뀌는 판을 만들고 변경이 일어난 곳을 숫자 1로 기록해

    // 왼쪽상단이 W으로 시작할때 바뀌는 판을 만들고 변경이 일어난 곳을 숫자 1로 기록해

    // 8 * 8 크기로 판을 탐색해서 변경이 일어난 곳의 합을 구해서 최솟값을 반환

    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void changedBoard(char[][] board, int[][] changedBoard){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char currentChar = board[i][j];

                for(int[] dir: dirs){
                    int newR = i + dir[0];
                    int newC = j + dir[1];

                    if(newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length){
                        if(board[newR][newC] == currentChar){
                            if(currentChar == 'B'){ board[newR][newC] = 'W'; }
                            else { board[newR][newC] = 'B'; }
                            changedBoard[newR][newC] = 1;
                        }
                    }
                }
            }
        }
    }

    static int checkBoard(int[][] board){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= board.length - 8; i++){
            for(int j = 0; j <= board[0].length - 8; j++){
                int sum = 0;

                for(int k = i; k < i + 8; k++){
                    for(int l = j; l < j + 8; l++){
                        sum += board[k][l];
                    }
                }
                if(sum < min){
                    min = sum;
                }
            }
        }
        return min;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }



        int[][] startBlack = new int[n][m];
        char[][] cloneBoardBlack = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cloneBoardBlack[i][j] = board[i][j];
            }
        }

        if(cloneBoardBlack[0][0] == 'W'){
            cloneBoardBlack[0][0] = 'B';
            startBlack[0][0] = 1;
            changedBoard(cloneBoardBlack, startBlack);
        } else{
            changedBoard(cloneBoardBlack, startBlack);
        }


        int[][] startWhite = new int[n][m];
        char[][] cloneBoardWhite = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cloneBoardWhite[i][j] = board[i][j];
            }
        }

        if (cloneBoardWhite[0][0] == 'B') {
            cloneBoardWhite[0][0] = 'W';
            startWhite[0][0] = 1;
            changedBoard(cloneBoardWhite, startWhite);
        } else {
            changedBoard(cloneBoardWhite, startWhite);
        }

        System.out.println(Math.min(checkBoard(startBlack),checkBoard(startWhite)));


    }
}
