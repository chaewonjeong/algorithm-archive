package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class G4_1477_휴게소세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 휴게소의 갯수
        int m = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소의 개수
        int l = Integer.parseInt(st.nextToken()); // 고속도로의 총 길이

        ArrayList<Integer> list = new ArrayList<>();

        if (n != 0) {
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            list.add(arr[0] - 0); // 첫 구간
            for (int i = 1; i < n; i++) {
                list.add(arr[i] - arr[i - 1]); // 중간 구간
            }
            list.add(l - arr[n - 1]); // 마지막 구간 꼭 추가해야함


        } else {
            list.add(l);
        }


//        for (int i : list) {
//            System.out.println(i);
//        }

        int left = 1;
        int right = Collections.max(list);
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (solve(list, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);

    }

    static boolean solve(ArrayList<Integer> list, int m, int mid) {
        int count = 0;
        for (int i : list) {
            int term = i;
            if(term <= mid) continue;
            count += (term-1) / mid;
        }
        if(count <= m) return true;
        return false;
    }
}
