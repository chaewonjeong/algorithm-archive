package programmers;

import java.util.Stack;

public class Lv2_괄호회전하기 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                if(c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // 문자열을 회전시키는 로직
            String rotated = s.substring(i) + s.substring(0, i);

            // 유효한 문자열인지 검사
            if (isValid(rotated)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }
}
