package programmers.kakao;

import java.util.ArrayList;

public class Lv3_주사위고르기 {
    // 조합을 구하란거지.. ?
    static int[][] dice = {
            {1, 2, 3, 4, 5, 6},
            {3, 3, 3, 3, 4, 4},
            {1, 3, 3, 4, 4, 4},
            {1, 1, 4, 4, 5, 5}
    };

    static ArrayList<ArrayList<Integer>> diceCombination = new ArrayList<>();

    static void selectDice(int dicePerPerson, int n, int cur, ArrayList<Integer> result){
        // 조합을 구해야함
        if(n == dicePerPerson){
            diceCombination.add(new ArrayList<>(result));
            return;
        }

        for (int i = cur; i < dicePerPerson * 2; i++) {
            result.add(i);
            selectDice(dicePerPerson, n + 1, i + 1, result);
            result.remove(result.size() - 1);
        }
    }


    static ArrayList<ArrayList<Integer>> permutation = new ArrayList<>();

    static void setPermutation(int dicePerPerson, int n, ArrayList<Integer> result) {
        if (n == dicePerPerson) {
            permutation.add(new ArrayList<>(result));
            return;
        }

        for(int i = 0; i < 6; i++){
            result.add(i);
            setPermutation(dicePerPerson, n + 1, result);
            result.remove(result.size() - 1);
        }
    }

    public static int[] solution(int[][] dice) {
        int dicePerPerson = dice.length/2;
        // 주어진 주사위로 만들 수 있는 조합
        selectDice(dicePerPerson, 0, 0, new ArrayList<>());
        setPermutation(dicePerPerson, 0, new ArrayList<>());
        ArrayList<ArrayList<Integer>> scoreBoard = new ArrayList<>();
        ArrayList<Integer> winCountList = new ArrayList<>();

        // 조합을 순회하는 방법에 대한 고민을 해보자!!
        for (ArrayList<Integer> comb : diceCombination) {
            ArrayList<Integer> scoreList = new ArrayList<>();
            for(ArrayList<Integer> perm : permutation) {
                int sum = 0;
                for (int t = 0; t < dicePerPerson; t++) {
                    int i = comb.get(t);
                    int j = perm.get(t);
                    sum += dice[i][j];
                }
                scoreList.add(sum);
            }
            scoreList.sort(Integer::compareTo);
            scoreBoard.add(scoreList);

        }

        for (int i = 0; i < scoreBoard.size(); i++) {
            int[] scoreListA = scoreBoard.get(i).stream().mapToInt(Integer::valueOf).toArray();
            int[] scoreListB = scoreBoard.get(scoreBoard.size() - i -1).stream().mapToInt(Integer::valueOf).toArray();

            int winCount = 0;

            for(int scoreA : scoreListA){

                // B에 대해 2분 탐색 - > scoreA가 첨으로 등장하는 위치(인덱스)
                // 조건 -> scoreA가 가장 처음 등장하는 위치 찾기
                int st = 0;
                int en = scoreListB.length - 1;

                while (st <= en) {
                    int mid = (st + en) / 2;
                    if(scoreListB[mid] >= scoreA){
                        en = mid - 1;
                    } else {
                        st = mid + 1;
                    }
                }
                winCount += st;
            }
            winCountList.add(winCount);
            //System.out.println(winCount);
        }
        int max = 0;
        for(int i = 1; i < winCountList.size(); i++){
            if(winCountList.get(i) > winCountList.get(max)){
                max = i;
            }
        }

        ArrayList<Integer> answer = diceCombination.get(max);

        return answer.stream().mapToInt(Integer::valueOf).map(i->i+1).toArray();
    }


    public static void main(String[] args) {
        int[] answer = solution(dice);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
