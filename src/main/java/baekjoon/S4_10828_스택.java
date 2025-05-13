package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_10828_스택 {
    static class Stack{
        int top;
        int size;
        int[] array;

        public Stack(){
            this.array = new int[100001];
            this.top = -1;
            this.size = 0;
        }

        public void push(int x){
            array[++top] = x;
            size++;
        }
        public int pop(){
            if(top == -1) return -1;
            size--;
            return array[top--];
        }
        public int top(){
            if(top == -1) return -1;
            return array[top];
        }
        public int size(){
            return size;
        }
        public int empty(){
            if(top == -1){
                return 1;
            } else return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.empty());
            } else if (command.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}
