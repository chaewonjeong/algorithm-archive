package baekjoon;

import java.util.Scanner;

public class G5_11729_하노이탑이동순서 {
    static StringBuilder answer = new StringBuilder();
    public static void hanoi(int a, int b, int n) {

        if (n == 1) {
            answer.append(a + " " + b + "\n");
            //System.out.println(a + " " + b);
            return;
        }
        hanoi(a, 6-a-b, n - 1); // n-1 개의 원판을 기둥 a에서 b가 아닌 기둥으로 옮긴다.
        //System.out.println(a + " " + b); // n 번째 원판을 기둥 a에서 기둥 b로 옮긴다.
        answer.append(a + " " + b + "\n");
        hanoi(6-a-b, b, n-1); // 나머지 n-1 개의 원판을 a와 b가 아닌 기둥에서 b로 옮긴다.
    }
    public static void main(String[] args) {
        // 1 -> 3번 장대로 옮길것
        // 입력은 원판의 갯수

        // 재귀는 정의 잘 읽기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(1,3, n);
        System.out.println((1 << n) - 1);
        System.out.println(answer);
    }
}
