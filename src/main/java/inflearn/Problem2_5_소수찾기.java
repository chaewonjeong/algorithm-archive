package inflearn;
import java.util.Scanner;
/**
 * 5. 소수(에라토스테네스 체)
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 * 출력5. 소수(에라토스테네스 체)
 * 설명
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 */
public class Problem2_5_소수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        int[] arr = new int[num+1];

        for(int i = 0; i <= num; i++){
            arr[i] = i;
        }

        arr[1] = 0;

        for (int i = 2; i*i <= num; i++) {
            if(arr[i] == 0){
                continue;
            }
            for(int j = i+i; j <= num; j+=i){
                arr[j] = 0;
            }
        }

        for(int i = 1; i <= num; i++){
            if(arr[i] != 0){count++;}
        }
        System.out.println(count);
    }


}
