package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1_모의고사 {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[][] persons = {p1,p2,p3};

        int[] scores = new int[3]; // 다 0으로 초기화

        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < persons.length; j++) {
                if(answers[i] == persons[j][i % persons[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
