package inflearn;

import java.util.Scanner;

public class Problem1_10_가장짧은문자거리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] strs = str.split(" ");

        String s = strs[0];
        String t = strs[1];

        int[] answer = new int[s.length()];

        for(int i = 1; i < strs.length; i++){
            int j = i;
            int k = i;
            int leftDistance = 0;
            int rightDistance = 0;
            if(s.charAt(i) == t.charAt(0)){
                answer[i] = 0;
                continue;
            }
            while(j >= 0 && s.charAt(j) != t.charAt(0)){
                j--;
                leftDistance++;
            }

            while(k <= s.length() - 1 && s.charAt(k) != t.charAt(0)){
                k++;
                rightDistance++;
            }

        }
    }
}
