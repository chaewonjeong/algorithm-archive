package baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S1_1697_숨바꼭질 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈 위치
        int k = sc.nextInt(); // 동생 위치

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[]{n,0});
        visited[n] = true;

        while(!queue.isEmpty()){
            int arr[] = queue.poll();
            int x = arr[0];
            int level = arr[1];
            if(x == k){
                System.out.println(level);
                return;
            }
            int[] next = {x * 2, x + 1, x - 1};

            for(int nxt : next){
                if(visited[nxt] || nxt < 0 || nxt > 100001) continue;
                visited[nxt] = true;
                queue.add(new int[]{nxt,level+1});

            }


        }
    }
}
