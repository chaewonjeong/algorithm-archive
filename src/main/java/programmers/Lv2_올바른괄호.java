package programmers;

import java.util.Stack;

public class Lv2_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.peek() == c){
                stack.push(c);
            } else if(stack.peek() != c){
                stack.pop();
            }

        }

        return stack.isEmpty();
    }

    boolean solution2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
