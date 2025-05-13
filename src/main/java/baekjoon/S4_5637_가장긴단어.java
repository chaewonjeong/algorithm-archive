package baekjoon;

import java.util.Scanner;

public class S4_5637_가장긴단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        String answer = "";

        while (!flag) {
            String s = sc.nextLine().trim().toLowerCase();
            String[] words = s.split("[^a-z-]");


            for(String word : words) {
                if (word.equals("e-n-d"))
                    flag = true;
                if(word.length() > max) {
                    max = word.length();
                    answer = word;
                }
            }

        }
        System.out.print(answer);
    }
}
