package inflearn;

import java.util.Scanner;

public class Problem1_2_대소문자변환 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        for (Character x : str.toCharArray()) {
            if(Character.isUpperCase(x)) {
                x = Character.toLowerCase(x);
            } else {
                x = Character.toUpperCase(x);
            }
            System.out.print(x);
        }
    }
}
