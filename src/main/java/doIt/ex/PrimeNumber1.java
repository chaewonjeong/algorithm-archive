package doIt.ex;

public class PrimeNumber1 {
    public static void main(String[] args) {
        int count = 0;
        int[] prime = new int[500];
        int ptr = 0;
        prime[ptr++] = 2;

        // 2를 제외한 모든 소수는 홀수
        for (int n = 3; n <= 1000; n+=2){
            int i;
            for (i = 1; i < ptr; i++){
                count++;
                if (n%prime[i] == 0){
                    break;
                }
            }
            if (ptr == i){
                prime[ptr++] = n;
            }
        }
        for(int i =0; i < ptr; i++){
            System.out.print(prime[i] + " ");
        }
    }
}
