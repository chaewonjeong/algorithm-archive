package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650_N과M2_best {
    static int n;
    static int m;
    static int[] selected;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int start, int count){
        if(count == m){
            for(int num : selected){
                answer.append(num).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i = start; i <= n; i++){
            selected[count] = i;
            dfs(i + 1, count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        dfs(1,0);
        System.out.println(answer.toString());
    }
}
