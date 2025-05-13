package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_4949_균형잡힌세상 {
    // 스택활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']','[');

        while (true) {
            char[] str = br.readLine().toCharArray();
            if(str[0] == '.') break;

            Stack<Character> stack = new Stack<>();
            boolean isRight = true;

            for(int i = 0; i < str.length; i++) {
                char cur = str[i];
                if(cur == '(' || cur == '['){
                    stack.push(str[i]);
                } else if(cur == ')' || cur == ']'){
                    if(stack.isEmpty()){
                        isRight = false;
                        break;
                    } else {
                        char c = stack.pop();
                        if(map.get(cur) != c){
                            isRight = false;
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()){
                isRight = false;
            }

            if (isRight){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}
