package programmers;

import java.util.ArrayList;

public class Lv2_숫자블록 {
    // 길이 10억
    // 숫자 크기 1000만


    public static int[] solution(long begin, long end) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(long num = begin; num <= end; num++) {
            if (num == 1) {
                answer.add(0);
                continue;
            }

            int result = 1;

            for(long i = 2; i * i <= num; i++) {
                if(num % i == 0) {
                    long quot = num / i;
                    if(quot <= 10_000_000){
                        result = (int) quot;
                        break;
                    } else if (i <= 10_000_000){
                        result = (int) i;
                    }
                }
            }
            answer.add(result);
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // 10 억 ->
        int[] answer = solution(1,100);
        for (int num : answer) {
            System.out.println(num);
        }

    }
}
