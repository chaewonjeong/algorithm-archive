package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_18869_멀티버스2_fail {
    public static void main(String[] args) throws IOException {
        /*
        M 개의 우주
        1 ~ N 까지 번호가 매겨진 행성 N개
        균등한 우주의 쌍이 몇개인지

        균등의 조건
        // i 번째와 j번째의 구성이 동일한 우주

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> universes = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            ArrayList<int[]> universe = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int[] planet = new int[2];
                int size = Integer.parseInt(st.nextToken());
                planet[0] = j;
                planet[1] = size;
                universe.add(planet);
            }
            universes.add(universe);
        }

        for(ArrayList<int[]> universe : universes) {
            Collections.sort(universe, Comparator.comparing((int[] o) -> o[1]));
        }

        int count = 0;
        for(int i = 0; i < universes.size(); i++) {

            for(int j = i + 1; j < universes.size(); j++) {
                ArrayList<int[]> universe1 = universes.get(i);
                ArrayList<int[]> universe2 = universes.get(j);
                boolean flag = true;
                for(int k = 0; k < n; k++) {
                    if(universe1.get(k)[0] != universe2.get(k)[0]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
        }
        System.out.println(count);


    }
}
