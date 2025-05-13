package inflearn;

import java.util.Scanner;

public class Problem1_9_숫자만추출 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder sb = new StringBuilder();

        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        int answer = Integer.parseInt(sb.toString());
        System.out.println(answer);
    }
}
