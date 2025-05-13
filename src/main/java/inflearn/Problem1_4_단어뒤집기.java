package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1_4_단어뒤집기 {
    // StringBuilder 사용해보기
    public static ArrayList<String> solution(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<>();

        for (String x : strings) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    // 메서드 없이 직접 구현
    // String은 객체로써 그 내부의 값을 인덱스로 접근하여 변경 불가능
    // 따라서 String을 char 배열로 변환 후 직접 구현
    public static ArrayList<String> solution2(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : strings) {
            char[] chars = x.toCharArray();
            for(int i = 0; i < chars.length/2; i++) {
                char tmp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = tmp;
            }
            answer.add(String.valueOf(chars));
        }

        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = sc.nextInt();
        } while (n < 3 || n > 20);

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        for (String word : solution2(n, words)) {
            System.out.println(word);
        }
    }
}
