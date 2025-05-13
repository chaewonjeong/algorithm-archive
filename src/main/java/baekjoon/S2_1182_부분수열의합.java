package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1182_부분수열의합 {
    // N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오

    static int N;
    static int S;
    static int count = 0;
    static int[] numbers;

    static void dfs(int sum, int index) {
        if(index == N) {
            if(sum == S)
                count++;
            return;
        }

        dfs(sum+numbers[index], index+1);
        dfs(sum, index+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수 갯수
        S = Integer.parseInt(st.nextToken()); // 합이 S

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if(S == 0) count--;
        System.out.println(count);
    }
}
