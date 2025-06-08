package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
코딩 실력이 좋으면 팀워크가 떨어지고
팀워크가 좋으면 코딩 실력이 떨어진다.

코딩 실력 : -10_000 ~ 10_000
코딩 실력의 합이 0이 되는 팀을 만들고자함

세 팀원의 코딩 실력의 합이 0이 되는 팀을 얼마나 만들 수 있는지 계산
 */
public class G4_3141_합이0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n - 1; j++) {
                int sum = students[i] + students[j];
                int left = j + 1;
                int right = n - 1;
                int lb = lowerBound(left, right, -sum, students);
                int ub = upperBound(left, right, -sum, students);


                if (ub >= lb) {
                    count += ub - lb + 1;
                }
            }
        }

        System.out.println(count);
    }

    static int lowerBound(int left, int right, int target, int[] arr) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(int left, int right, int target, int[] arr) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
