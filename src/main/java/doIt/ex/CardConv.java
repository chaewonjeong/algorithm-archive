package doIt.ex;

import java.util.Arrays;
import java.util.Scanner;

public class CardConv {

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        // 문자를 역순으로 정렬
        for (int i = 0; i < digits / 2; i++) {
            char temp = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = temp;
        }
        return digits;
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        int dno;
        int retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다. ");

        do{
            System.out.print("변환하는 음이아닌 정수 : ");
            no = stdIn.nextInt();
        } while (no < 0);

        do{
            System.out.print("어떤 진수로 변환할까요? (2~36) : ");
            cd = stdIn.nextInt();
        } while (cd < 2 || cd > 36);

        dno = cardConv(no, cd, cno);
        for (int i = 0; i < dno; i++) {
            System.out.print(cno[i]);
        }

    }
}
