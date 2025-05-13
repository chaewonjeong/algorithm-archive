package ctp;

import java.util.*;
import java.util.stream.Collectors;

public class P50_계수정렬구현하기 {
    public static String solution(String str){

        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            if (!map.containsKey(c)) {
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }


        List<Map.Entry<Character,Integer>> result = map.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey()))
                .collect(Collectors.toCollection(ArrayList::new));

        for(Map.Entry<Character,Integer> entry : result){
            char c = entry.getKey();
            Integer count = entry.getValue();
            for(int i = 0 ; i < count ; i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        String str = "hello";
        System.out.println(solution(str));
    }
}
