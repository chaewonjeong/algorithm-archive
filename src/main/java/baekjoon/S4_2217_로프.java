package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class S4_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 물체의 최대 중량 = w
        // w / n = 로프 하나에 걸리는 무게

        Arrays.sort(list, Comparator.reverseOrder());

        int maxWeight = list[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            count++;
            int weight = list[i] * count;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        System.out.println(maxWeight);


    }
}
