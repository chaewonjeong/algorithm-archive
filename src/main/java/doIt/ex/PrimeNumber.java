package doIt.ex;

public class PrimeNumber {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        // 2를 제외한 소수는 모두 홀수
        for (int n = 3; n <= 100; n++) {
            int i;
            for (i = 1; i < ptr; i++) {
                counter++;
                
            }
        }
    }
}
