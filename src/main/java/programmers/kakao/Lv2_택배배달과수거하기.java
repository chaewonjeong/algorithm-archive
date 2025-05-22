package programmers.kakao;

public class Lv2_택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups){
        long answer = 0;

        int deliverRemain = 0;
        int pickupRemain = 0;

        for (int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];
            pickupRemain += pickups[i];

            while (deliverRemain > 0 || pickupRemain > 0) {
                deliverRemain -= cap;
                pickupRemain -= cap;
                answer += (i + 1) * 2L;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        System.out.println(solution(cap, n, deliveries, pickups));

    }
}
