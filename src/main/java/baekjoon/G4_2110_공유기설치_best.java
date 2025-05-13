package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2110_공유기설치_best {
    // todo

    static int[] housePosition;
    static int n;
    static int c;

    static boolean solve(int d){
        int count = 1;
        int lastInstalled = housePosition[0];

        for (int i = 1; i < n; i++) {
            if (housePosition[i] - lastInstalled >= d) {
                count++;
                lastInstalled = housePosition[i];
            }
        }

        return count >= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        housePosition = new int[n];

        for (int i = 0; i < n; i++) {
            housePosition[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(housePosition);

        int left = 1;
        int right = 1_000_000_000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(mid)) {
                //answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
