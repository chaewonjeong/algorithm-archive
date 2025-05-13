package example;


import java.util.*;


public class ComparatorEx1 {
    public Integer[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList();

        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            if(!stack.isEmpty() && stack.peek() == i){
                continue;
            } else {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.reverse(list);

        return list.stream().toArray(Integer[]::new);
    }
}
