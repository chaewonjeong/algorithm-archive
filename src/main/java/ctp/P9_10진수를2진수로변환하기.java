package ctp;

import java.util.Stack;

public class P9_10진수를2진수로변환하기 {
    private static String solution(int dec) {
        //String answer = "";

        Stack<Integer> stack = new Stack<>();

        while (dec > 0) {
            stack.push(dec%2);
            dec = dec/2;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            //String 클래스의 + 연산은 시간복잡도를 증가시키기 때문에 문자열 수정등에는 StringBuilder 클래스를 이용하자
            //answer += stack.pop();
            sb.append(stack.pop());
        }

        //return answer;
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
