package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lv1_가장많이받은선물 {

    static int countGive(int name, int[][] giftMatrix) {
        int sum = 0;
        for(int i = 0; i < giftMatrix.length; i++) {
            sum += giftMatrix[name][i];
        }
        return sum;
    }

    static int countGet(int name, int[][] giftMatrix) {
        int sum = 0;
        for(int i = 0; i < giftMatrix.length; i++) {
            sum += giftMatrix[i][name];
        }
        return sum;
    }

    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> peopleMap = new HashMap<>();

        for(int i = 0; i < friends.length; i++) {
            peopleMap.put(friends[i], i);
        }

        int[][] giftsMatrix = new int[friends.length][friends.length];

        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                giftsMatrix[i][j] = 0;
            }
        }

        for(String gift :gifts){
           StringTokenizer st = new StringTokenizer(gift);
           int from = peopleMap.get(st.nextToken());
           int to = peopleMap.get(st.nextToken());

           giftsMatrix[from][to] = giftsMatrix[from][to] + 1;
        }

        // 준 선물 | 받은 선물 | 선물지수
        int[][] giftCountTable = new int[friends.length][3];

        for(int i = 0; i < friends.length; i++) {
            giftCountTable[i][0] = countGive(i, giftsMatrix);
            giftCountTable[i][1] = countGet(i, giftsMatrix);
            giftCountTable[i][2] = giftCountTable[i][0] - giftCountTable[i][1];
        }

        // 정답 배열 -> 다음달 사람별로 받을 선물 수 -> 인덱스로 구별
        int[] giftCountList = new int[friends.length];

        // 더 많이 준사람이 받는다
        for(int i = 0; i < friends.length; i++) {
            for(int j = i; j < friends.length; j++) {
                if(i == j) continue;

                if(giftsMatrix[i][j] > giftsMatrix[j][i]) {
                    giftCountList[i] += 1;
                } else if (giftsMatrix[i][j] < giftsMatrix[j][i]) {
                    giftCountList[j] += 1;
                } else {
                    int pointI = giftCountTable[i][2];
                    int pointJ = giftCountTable[j][2];

                    if(pointI == pointJ) continue;
                    giftCountList[pointI > pointJ ? i : j] += 1;
                }
            }
        }

        return Arrays.stream(giftCountList).max().orElse(0);

    }
}
