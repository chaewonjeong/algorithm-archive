package programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Lv2_뉴스클러스터링 {

    public static ArrayList<String> createStringSet(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < chars.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i]).append(chars[i + 1]);

            if (!sb.toString().matches("[a-zA-Z]{2}")) continue;

            result.add(sb.toString().toLowerCase());
        }
        return result;
    }

    public static HashMap<String, Integer> createHashMap(ArrayList<String> str) {
        HashMap<String, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < str.size(); i++) {
            if(!stringMap.containsKey(str.get(i))) {
                stringMap.put(str.get(i), 0);
            }
            stringMap.put(str.get(i), stringMap.get(str.get(i)) + 1);
        }
        return stringMap;
    }

    public static float calculateJaccard(ArrayList<String> stringSet1, ArrayList<String> stringSet2) {
        if(stringSet1.size() == 0 && stringSet2.size() == 0) return 1;

        HashMap<String, Integer> stringMap1 = createHashMap(stringSet1);
        HashMap<String, Integer> stringMap2 = createHashMap(stringSet2);

        int intersection = calcIntersectionSize(stringMap1, stringMap2);
        int union = calcUnionSize(stringMap1, stringMap2);
        //if(union == 0) return 1;

        return ((float) intersection / (float) union);

    }

    public static int calcIntersectionSize(HashMap<String, Integer> stringMap1,
                                           HashMap<String, Integer> stringMap2){
        int size = 0;

        for(String str : stringMap1.keySet()) {
            if(stringMap2.containsKey(str)) {
                int min = Math.min(stringMap1.get(str), stringMap2.get(str));
                size += min;
            }
        }
        return size;
    }

    public static int calcUnionSize(HashMap<String, Integer> stringMap1,
                                    HashMap<String, Integer> stringMap2) {
        HashSet<String> unionSet = new HashSet<>();
        int size = 0;

        for(String str : stringMap1.keySet()) {
            unionSet.add(str);
            if(stringMap2.containsKey(str)) {
                int max = Math.max(stringMap1.get(str), stringMap2.get(str));
                size += max;
            } else {
                size += stringMap1.get(str);
            }
        }

        for(String str : stringMap2.keySet()) {
            if(unionSet.contains(str)) continue;
            size += stringMap2.get(str);
        }
        return size;
//        HashSet<String> allKeys = new HashSet<>();
//        allKeys.addAll(stringMap1.keySet());
//        allKeys.addAll(stringMap2.keySet());
//
//        int size = 0;
//        for (String key : allKeys) {
//            int count1 = stringMap1.getOrDefault(key, 0);
//            int count2 = stringMap2.getOrDefault(key, 0);
//            size += Math.max(count1, count2);
//        }
//
//        return size;
    }

    public int solution(String str1, String str2) {
        int answer = (int)Math.floor(calculateJaccard(createStringSet(str1), createStringSet(str2)) * 65536);
        return answer;
    }

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        ArrayList<String> test1 = createStringSet(str1);
        ArrayList<String> test2 = createStringSet(str2);

        System.out.println((int)Math.floor(calculateJaccard(createStringSet(str1), createStringSet(str2)) * 65536));
    }
}
