package programmers.kakao;

public class Lv2_택배배달과수거하기_fail {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups){
        int startIndex = n - 1;
        long answer = 0;

        int count = 0;

        while (count < n) {
            while(deliveries[startIndex] == 0 && pickups[startIndex] == 0) {
                startIndex--;
                count++;
            }
            //System.out.println(startIndex);
            if(startIndex == 0) break;
            answer += startIndex + 1;


            int deliveryIndex = startIndex;
            int pickupIndex = startIndex;

            int deliverySum = 0;
            while (cap - deliverySum > 0 && deliveryIndex > 0) {
                if(deliveries[deliveryIndex] <= cap - deliverySum) {
                    deliverySum += deliveries[deliveryIndex];
                    deliveries[deliveryIndex] = 0;
                    deliveryIndex--;
                } else {
                    deliveries[deliveryIndex] -= cap - deliverySum;
                    deliverySum = cap;
                }
            }

            int pickupSum = 0;
            while (cap - pickupSum > 0 && pickupIndex > 0) {
                if(pickups[pickupIndex] <= cap - pickupSum) {
                    pickupSum += pickups[pickupIndex];
                    pickups[pickupIndex] = 0;
                    pickupIndex--;
                } else {
                    pickups[pickupIndex] -= cap - pickupSum;
                    pickupSum = cap;
                }
            }
        }
        return answer * 2;
    }

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pikups = {0, 3, 0, 4, 0};

        System.out.println(solution(cap, n, deliveries, pikups));

    }
}
