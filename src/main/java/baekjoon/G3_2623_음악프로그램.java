package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_2623_음악프로그램 {
    // 이 문제도 입력에 대해 인접리스트를 잘 다뤄주면 될 듯... ?
    // 사이클 만들어지면 0 출력
    // 사이클 여부는 위상정렬에 모든 정점이 있는지로 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int[] degree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int[] singers = new int[num];

            for(int j = 0; j < num; j++) {
                singers[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0; k < num-1; k++) {
                adjList[singers[k]].add(singers[k+1]);
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int v : adjList[i]) {
                degree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int singer = queue.poll();
            answer.add(singer);

            for(int v : adjList[singer]) {
                degree[v]--;
                if(degree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if(answer.size() != n) {
            System.out.println(0);
        } else{
            for(int v : answer) {
                System.out.println(v);
            }
        }
    }
}
