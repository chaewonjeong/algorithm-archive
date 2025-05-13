package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2805_나무자르기 {
    static int n;
    static int m;
    static int[] trees;

    static boolean solve(int h){
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(trees[i] < h) continue;
            sum += trees[i] - h;
        }
        return sum >= m;
    }

    public static void main(String[] args) throws IOException {
        // 최적화 : 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력한다.
        // 결정 :  설정 높이가 H 일때, 가져가는 나무가 M 이상인가 아닌가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(solve(mid)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);

    }
}
