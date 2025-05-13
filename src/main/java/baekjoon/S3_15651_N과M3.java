package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15651_N과M3 {
    static int N;
    static int M;
    static int[] selected;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int n){
        if(n == M){
            for(int num : selected){
                answer.append(num).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            selected[n] = i;
            dfs(n + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        dfs(0);
        System.out.println(answer.toString());

    }
}
