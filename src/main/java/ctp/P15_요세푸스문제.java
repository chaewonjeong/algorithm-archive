package ctp;

import java.util.ArrayDeque;

public class P15_요세푸스문제 {
    private int soulution(int N, int K) {

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 1 부터 N 까지의 번호를 deque에 추가
        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while(deque.size() > 1){
            for(int i = 0; i < K-1; i++){
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();
        }
        return deque.pollFirst(); // 마지막 남은 요소 반환

    }
}
