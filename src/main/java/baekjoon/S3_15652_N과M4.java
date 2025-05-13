package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15652_N과M4 {
    static int n;
    static int m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int count){
        if(count == m){
            if(check()){
                for (int num : selected) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
                return;
            }
            return;
        }

        for(int i = 1; i <= n; i++){
            selected[count] = i;
            dfs(count + 1);
        }

    }

    static boolean check(){
        for(int i =0; i < m - 1; i++){
            if(selected[i] > selected[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        dfs(0);
        System.out.println(sb.toString());
    }
}
