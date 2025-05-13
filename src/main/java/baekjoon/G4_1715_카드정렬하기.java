package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class G4_1715_카드정렬하기 {
    // 두 묶음의 숫자 카드는 정렬된 상태...
    // 작은쪽에서....
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n ; i++) {
            int k = Integer.parseInt(br.readLine());
            pq.add(k);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while(pq.size() > 1){
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += pq.poll();
            }
            pq.offer(sum);
            answer+=sum;
        }
        System.out.println(answer);
    }
}
