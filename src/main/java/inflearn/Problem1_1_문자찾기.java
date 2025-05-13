package inflearn;

import java.util.Scanner;

public class Problem1_1_문자찾기 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        int answer = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == c) {
//                answer++;
//            }
//        }

        for(char x : str.toCharArray()) {
            if(x == c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
