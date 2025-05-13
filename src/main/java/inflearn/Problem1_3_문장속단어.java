package inflearn;


import java.util.Scanner;

public class Problem1_3_문장속단어 {
    public static String solution(String str) {
        String answer = "";
        String word = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if(word.length() > answer.length()) {
                    answer = word;
                }
                word="";
            } else {
                word += c;
            }
        }

        // nextLine()으로 받은 문자열은 개행문자가 포함되어 있지 않는다.

        // 마지막 단어 처리
        if (word.length() > answer.length()) {
            answer = word;
        }

        return answer;
    }

    public static String solution2(String str) {
        // int의 가장 작은 값으로 초기화
        int max = Integer.MIN_VALUE;
        String answer = "";
        // splic 메서드 사용
        String[] words = str.split(" ");
        for(String w: words){
            if(w.length() > max){
                max = w.length();
                answer = w;
            }
        }
        return answer;
    }
    public static String solution3(String str) {
        // int의 가장 작은 값으로 초기화
        int max = Integer.MIN_VALUE, pos;
        String answer = "";

        while((pos = str.indexOf(" ")) != -1){
            String word = str.substring(0,pos);
            int len = word.length();
            if(len > max){
                max = len;
                answer = word;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > answer.length()){
            answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(solution3(str));
    }
}
