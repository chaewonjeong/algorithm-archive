package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            int[] kavin = new int[n + 1];
            Arrays.fill(kavin, -1);
            kavin[0] = 0;
            queue.add(i);
            kavin[i] = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for(int next : adjList[cur]) {
                    if (kavin[next] == -1) {
                        queue.add(next);
                        kavin[next] = kavin[cur] + 1;
                    }
                }
            }

            answer[i] = Arrays.stream(kavin).sum();
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            if(answer[i] < min) {
                min = answer[i];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
