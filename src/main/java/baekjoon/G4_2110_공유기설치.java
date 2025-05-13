package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2110_공유기설치 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] housePosition;
    static int n;
    static int c;

    // 거리 d 이상으로
    // 결정함수를 설계하는 방식이 틀림
    static boolean solve(int d){
        for (int i = 1; i <= n; i++) {
            int hp = housePosition[i];
            int neighbor = hp + d;
            if (map.containsKey(neighbor)) {
                if(n - map.get(neighbor) >= c - 2){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 집의 개수
        c = Integer.parseInt(st.nextToken()); // 공유기 개수 C
        housePosition = new int[n+1];



        // 수직선 상의 집의 좌표
        // 좌표 , index 로 저장
        for (int i = 1; i <= n; i++) {
            int pos = Integer.parseInt(br.readLine());
            housePosition[i] = pos;
            map.put(pos, i);
        }
        Arrays.sort(housePosition);

        int left = 0;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (solve(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }
}
