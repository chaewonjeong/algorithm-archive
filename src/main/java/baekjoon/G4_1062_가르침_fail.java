package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class G4_1062_가르침_fail {
    static int max = Integer.MIN_VALUE;
    static String[] words;

    static void combination(List<Character> wordList, int k, int start, StringBuilder result){
        if(result.length() == k){
            int count = 0;
            for(String word : words){
                boolean flag = true; // 모든 문자가 antic으로만 이루어졌을때 빈 문자열이 오면??
                for(char c : word.toCharArray()){
                    if(!result.toString().contains(String.valueOf(c))){
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
            max = Math.max(max, count);
            return;
        }

        for(int i = start; i < wordList.size(); i++){
            result.append(wordList.get(i));
            combination(wordList, k, i + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(k < 5){
            System.out.println(0);
            return;
        }

        words = new String[n];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            word = word.replaceAll("[antic]","");
            for(char c:word.toCharArray()){
                set.add(c);
            }
            words[i] = word;
        }

        if (set.isEmpty()) {
            System.out.println(n); // 모든 단어가 antic으로만 구성된 경우
            return;
        }


        List<Character> list = new ArrayList<>(set);

        // list 에서 k 개를 뽑는 조합을 구해서 단어마다 해당 단어가 포함되는지 확인하는 방식으로 count
        combination(list,k-5,0, new StringBuilder());
        System.out.println(max);


    }
}
