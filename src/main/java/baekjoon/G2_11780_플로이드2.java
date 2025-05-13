package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_11780_플로이드2 {
    static StringBuilder answer1 = new StringBuilder();
    static StringBuilder answer2 = new StringBuilder();
    static int[][] dist;
    static int[][] next;

    static void printPath(int start, int end, int count, StringBuilder sb){
        sb.append(start).append(" ");
        if(start == end){
            if(count == 1){
                answer2.append(0).append("\n");
            }else {
                answer2.append(count).append(" ").append(sb).append("\n");

            }
            return;
        }

        printPath(next[start][end], end, count + 1, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 100000*(n-1) + 1;

        dist = new int[n+1][n+1];
        next = new int[n+1][n+1];


        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j){
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // dist배열 초기화
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(dist[a][b] > c){
                dist[a][b] = c;
                next[a][b] = b;
            }
        }



        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] == INF){
                    answer1.append(0).append(" ");
                }else {
                    answer1.append(dist[i][j]).append(" ");
                }
            }
            answer1.append("\n");
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                printPath(i,j,1,new StringBuilder());
            }
        }

        System.out.print(answer1.toString());
        System.out.println(answer2.toString());
    }


}
