package programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class Lv1_실패율 {
    private static int[] solution(int N, int[] stages) {
        // 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어의 수
        // N = 5
        // stages = [2,1,2,6,2,4,3,3]
        // result = [3,4,2,1,5]
        int userNum = stages.length;

        int[] leaveStage = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            leaveStage[stages[i]]++;
        }

        HashMap<Integer, Double> fail = new HashMap<>();
        for (int i = 1; i < leaveStage.length-1; i++) {
            if (leaveStage[i] == 0) {
                fail.put(i,0.);
            } else {
                double fp = (double) leaveStage[i] / userNum;
                userNum -= leaveStage[i];
                fail.put(i, fp);
            }
        }

        return fail.entrySet().stream().sorted((o1,o2)->Double.compare(o2.getValue(),o1.getValue())).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {

        int [] answer = solution(5, new int[]{2,1,2,6,2,4,3,3});

        for(int i : answer){
            System.out.println(i);
        }
    }
}
