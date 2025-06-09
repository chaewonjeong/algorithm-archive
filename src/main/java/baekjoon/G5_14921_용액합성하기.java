package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14921_용액합성하기 {
    // 0에 가장 가까운 특성값 B를 찾아야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int base = arr[i];

            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (Math.abs(base + arr[mid]) <= min) {
                    min = Math.abs(base + arr[mid]);
                    result = base + arr[mid];
                }

                if (base + arr[mid] >= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(result);
    }
}
