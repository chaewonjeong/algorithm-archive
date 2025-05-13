package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1780_종이의개수_best {
    static int[] answer = new int[3];

    // 모든 값이 같은지 체크하는 함수
    static boolean checkPaper(int[][] paper, int n, int startRow, int startCol) {
        int key = paper[startRow][startCol];
        // 아래와 같이 배열을 탐색하면 좌표를 불필요하게 슬라이싱 할 필요가 없다
        for(int i = startRow; i < startRow + n; i++) {
            for(int j = startCol; j < startCol + n; j++) {
                if (paper[i][j] != key) {
                    return false;
                }
            }
        }
        return true;
    }

    // 재귀 (분할 정복)
    static void divide(int[][] paper, int n, int startRow, int startCol) {
        if(n==1){
            answer[paper[startRow][startCol]+1]++;
        }
        // base-condition
        if(checkPaper(paper,n,startRow,startCol)) {
            answer[paper[startRow][startCol]+1]++; // 신박하군..
            return;
        }

        int newN = n / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                divide(paper,newN,startRow+i*newN,startCol+j*newN);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(paper, n, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }
    }
}
