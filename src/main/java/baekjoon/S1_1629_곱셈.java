package baekjoon;

import java.util.Scanner;

public class S1_1629_곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(solution(a,b,c));
    }

    private static int solution(int a, int b, int c) {
        if(b == 0) return 1;

        int half = solution(a, b/2, c);
        int result = (half * half) % c;
        if(b % 2 == 0) result = (result * a) % c;
        return result;
    }
}
