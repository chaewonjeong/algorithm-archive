package baekjoon;

import java.util.Scanner;

public class S3_15649_N과M1 {

    static int N;
    static int M;
    static int[] isUsed;
    static int[] arr;

    static void dfs(int k){
        if(k == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++){
            if(isUsed[i] == 0){
                arr[k] = i;
                isUsed[i] = 1;
                dfs(k+1);
                isUsed[i] = 0; //
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isUsed = new int[N+1];
        arr = new int[N+1];
        dfs(0);
    }
}
