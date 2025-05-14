package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_18869_멀티버스2 {
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
        int m = Integer.parseInt(st.nextToken()); // 우주의 갯수
        int n = Integer.parseInt(st.nextToken()); // 각 우주에 있는 행성의 수

        ArrayList<int[]> universes = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int[] planets = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                planets[j] = Integer.parseInt(st.nextToken());
            }
            universes.add(planets);
        }

        ArrayList<int[]> compUniverses = new ArrayList<>();

        for(int[] universe : universes) {
            //좌표 압축
            TreeSet<Integer> set = new TreeSet<>();
            for(int i : universe) {
                set.add(i);
            }
            int[] sorted = set.stream().mapToInt(i -> i).toArray();

            int[] comp = new int[n];

            for (int i = 0; i < n; i++) {
                int target = universe[i];
                int lb = 0;
                int ub = n - 1;

                while (lb <= ub) {
                    int mid = (lb + ub) / 2;

                    if(sorted[mid] >= target){
                        ub = mid - 1;
                    } else {
                        lb = mid + 1;
                    }
                }

                comp[i] = lb;
            }


            compUniverses.add(comp);
        }

        int count = 0;


        for(int i = 0 ; i < compUniverses.size() - 1 ; i++) {
            for(int j = i + 1; j < compUniverses.size(); j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if(compUniverses.get(i)[k] != compUniverses.get(j)[k]){
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
