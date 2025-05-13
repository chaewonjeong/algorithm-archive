package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_11404_플로이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        int INF = 100000*n + 1;
        int[][] matrix = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(i == j){
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(matrix[a][b] > c){
                matrix[a][b] = c;
            }
        }

        for(int k = 1; k <= n; k++){
            for(int s = 1; s <= n; s++){
                for(int t = 1; t <= n; t++){
                    if(matrix[s][t] > matrix[s][k] + matrix[k][t]){
                        matrix[s][t] = matrix[s][k] + matrix[k][t];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i][j] == INF){
                    sb.append(0).append(" ");
                } else {
                    sb.append(matrix[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
