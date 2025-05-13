package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_2660_회장뽑기 {
    // todo
    // -> 플로이드 워셜로 풀어보기
    // 문제 자체가 BFS 순회 하라는 거
    // 레벨 순회 -> 완전 탐색시 레벨이 가장 낮은 사람이 회장이 되는 방식
    // 각 정점에 대해 bfs 돌려
    // 레벨을 저장하는 방식을 잘 기억해둘 것
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        int[] maxLevels = new int[n + 1];
        maxLevels[0] = 1000;

        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1){
                break;
            }
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for(int i = 1; i <= n; i++){
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new ArrayDeque<>();
            int[] level = new int[n+1];

            queue.add(i);
            visited[i] = true;
            level[i] = 0;

            int maxLevel = 0;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next: adjList[cur]){
                    if(!visited[next]){
                        level[next] = level[cur] + 1;
                        maxLevel = Math.max(maxLevel, level[next]);
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            maxLevels[i] = maxLevel;
        }
        int minLevel = Arrays.stream(maxLevels).min().getAsInt();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(maxLevels[i] == minLevel){
                sb.append(i).append(" ");
                count++;
            }
        }

        System.out.println(minLevel + " " + count);
        System.out.println(sb.toString());
    }
}
