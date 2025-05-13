package doIt.ex;

import java.util.Scanner;

public class PrintPyramid {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;
        do {
            System.out.print("피라미드의 단수를 입력하시오 : ");
            n = stdIn.nextInt();
        } while (n <= 0);

        int k = (n-1)*2+1;

        for(int j = 1; j <= k; j+=2) {
            System.out.print(" ".repeat((k-j)/2));
            System.out.println("*".repeat(j));
        }

    }
}
