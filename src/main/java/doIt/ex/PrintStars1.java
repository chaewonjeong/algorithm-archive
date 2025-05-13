package doIt.ex;

import java.util.Scanner;

public class PrintStars1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // *를 n개 출력하되 w개 마다 줄바꿈
        int n, w;
        do {
            System.out.print("n을 입력하세요 : ");
            n = scanner.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w를 입력하세요 : ");
            w = scanner.nextInt();
        } while (w <= 0 || w > n);

        for (int i = 0; i < n; i++) {
            System.out.print("*");
            if(i % w == w-1)
                System.out.println();
        }
//        if (n % w != 0)
//            System.out.println();
    }
}
