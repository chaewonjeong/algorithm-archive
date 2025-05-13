package ctp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P43_1부터N까지숫자합이10이되는조합구하기 {
    // 정수 N을 입력받아 1부터 N까지의 숫자 중에서 합이 10이 되는 조합을 리스트로 반환하는 solution() 함수를 작성하세요
    /*
    - 백트래킹 활용
    - 숫자 조합은 오름차순 정렬
    - 같은 숫자는 한번만 선택할 수 있습니다.
    - N은 1이상 10 이하인 정수입니다.
     */

    // 백트래킹 -> 유망함수 : 합이 10이 되면 백, 합이 10이 넘으면 백,
    static ArrayList<int[]> list = new ArrayList<>();
    static int N;

    static void dfs(int i, int sum, int[] state){
        // 유망 함수
        if(i > N || sum > 10){
            return;
        }

        // base-condition
        state[i] = 1;
        if(sum + i == 10){
            list.add(state.clone());
        } else {
            dfs(i + 1, sum + i, state);
        }

        // 백트래킹
        state[i] = 0;
        dfs(i+1, sum, state);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] state = new int[N+1];
        dfs(1, 0, state);

        List<int[]> answer = new ArrayList<>();

        for(int[] l : list){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                if(l[i] == 1){
                    ans.add(i);
                }
            }
            answer.add(ans.stream().mapToInt(i -> i).toArray());
        }

        for(int[] l : answer){
            System.out.println(Arrays.toString(l));
        }
    }
}
