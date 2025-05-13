package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2630_색종이만들기 {
    // 전체종이가 같은 색으로 칠해져 있지 않으면
    // 4등분
    // base-condition : 모두 같은 색 or 한개

    static int N;
    static int blue = 0; // 1
    static int white = 0; // 0

    static boolean checkColor(int r, int c, int n, int[][] paper){
        int key = paper[r][c];
        for(int i = r; i < r + n; i++){
            for(int j = c; j < c + n; j++){
                if (key != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void dfs(int r, int c, int n, int[][] paper){
        if(n == 1){
            if(paper[r][c] == 1){
                blue++;
            } else {
                white++;
            }
            return;
        }

        if(checkColor(r, c, n, paper)){
            if(paper[r][c] == 1){
                blue++;
            } else {
                white++;
            }
            return;
        }

        dfs(r, c, n/2, paper);
        dfs(r, c + n/2, n/2, paper);
        dfs(r + n/2, c, n/2, paper);
        dfs(r + n/2, c + n/2, n/2, paper);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // N 은 2,4,8,16,32,64,128 중 하나

        int[][] paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        dfs(0, 0, N, paper);


        System.out.println(white);
        System.out.println(blue);
    }


}
