package ctp;

import java.util.HashSet;

public class P18_두개의수로특정값만들기 {
    public boolean solution(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr){
            if(set.contains(target - i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
