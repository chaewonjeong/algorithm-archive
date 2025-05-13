package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1780_종이의개수 {
    /*
    1. 종이가 모두 같은 수라면 그대로 사용
    2. 아닌경우 같은 크기의 종이 9개(3 x 3) ㅣ로 자르고, (1) 반복

    N 은 3의 제곱형태로 주어진다.

    - base condition : 종이가 1개이거나 종이내의 모든 숫자가 같을때

    계속해서 행과 열이 3등분이 되니 9개의 종이로 나눠진다.

     */
    static int[] answer = new int[3]; // -1, 0, 1 의 개수를 담을 배열

    static boolean checkPaper(int[][] paper, int n){
        int key = paper[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(paper[i][j] != key){
                    return false;
                }
            }
        }
        return true;
    }
    static int[][] slicePaper(int[][] paper, int size, int startRow, int startCol){
        int[][] slicedPaper = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                slicedPaper[i][j] = paper[i+startRow][j+startCol];
            }
        }
        return slicedPaper;
    }

    static void fun(int[][] paper, int n){
        if(n == 1){
            if(paper[0][0] == -1){ answer[0] += 1; return;}
            else if(paper[0][0] == 0){ answer[1] += 1; return;}
            else if(paper[0][0] == 1){ answer[2] += 1; return;}
        }
        if(checkPaper(paper, n)){
            if(paper[0][0] == -1){ answer[0] += 1; return;}
            else if(paper[0][0] == 0){ answer[1] += 1; return;}
            else if(paper[0][0] == 1){ answer[2] += 1; return;}
        }
        int newN = n / 3;
        for(int i = 0; i < n; i += newN){
            for(int j = 0; j < n; j+= newN){
                fun(slicePaper(paper, newN, i, j), newN);
            }
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        fun(paper, n);

        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }

    }
}
