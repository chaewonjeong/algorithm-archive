package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_15688_수정렬하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int[] freq = new int[2_000_001];

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            num += 1_000_000;
            freq[num]++;
        }

        for(int i = 0 ; i <= 2_000_000; i++) {
            while(freq[i] > 0) {
                answer.append(i - 1_000_000).append("\n");
                freq[i]--;
            }
        }

        System.out.println(answer);
    }
}
