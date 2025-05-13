package programmers;

import java.util.ArrayList;


public class Lv1_두개뽑아서더하기 {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                int sum = numbers[i]+numbers[j];
                if(!result.contains(sum)){
                    result.add(sum);
                }
            }
        }
        result.sort(Integer::compareTo);
        return result;
    }

}
