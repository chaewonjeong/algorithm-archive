package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2166_다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinate[i][0] = x;
            coordinate[i][1] = y;
        }

        coordinate[n][0] = coordinate[0][0];
        coordinate[n][1] = coordinate[0][1];

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long tmp = (long) coordinate[i][0] * coordinate[i+1][1] - (long) coordinate[i + 1][0] * coordinate[i][1];
            sum += tmp;
        }

        double answer = Math.abs(sum) / 2.0;
        System.out.printf("%.1f\n", answer);
    }
}
