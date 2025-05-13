package baekjoon;
import java.math.BigInteger;
import java.util.Scanner;

public class S5_1676_팩토리얼0의개수 {
    // BigInteger 정리하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String result = factorial.toString();
        int count = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        System.out.println(factorial);
    }
}
