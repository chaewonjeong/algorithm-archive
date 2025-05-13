package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650_N과M2 {
    static int n;
    static int m;

    static int[] visited;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int i, int count){


        if (count == m) {
            for(int j = 1; j < visited.length; j++){
                if(visited[j] == 1){
                    answer.append(j + " ");
                }
            }
            answer.append("\n");
            return;
        }
        if(i > n) return;

        visited[i] = 1;
        dfs(i+1, count+1);

        visited[i] = 0;
        dfs(i+1, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
        dfs(1,0);

        System.out.println(answer.toString());
    }
}
