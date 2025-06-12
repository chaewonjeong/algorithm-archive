package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_13549_숨바꼭질3 {
    // 수직선상
    // 수빈위치 : N
    // 동생위치 : K
    // 순간이동시 : 현재위치 * 2 (걸리는 시간 2초)
    // 그냥 이동시 : N + 1, N - 1 (걸리는 시간 1초)
    // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후일까?
    static int[] work = {1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] board = new int[100_001];
        int[] visited = new int[100_001];

        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curTime = visited[cur];

            int teleport = cur * 2;
            int workNext = cur + 1;
            int workBack = cur - 1;

            if(teleport >= 0 && teleport < board.length){
                if (visited[teleport] > curTime) {
                    visited[teleport] = curTime;
                    queue.add(teleport);
                }
            }

            if(workNext >= 0 && workNext < board.length){
                if (visited[workNext] > curTime + 1) {
                    visited[workNext] = curTime + 1;
                    queue.add(workNext);
                }
            }

            if(workBack >= 0 && workBack < board.length){
                if (visited[workBack] > curTime + 1) {
                    visited[workBack] = curTime + 1;
                    queue.add(workBack);
                }
            }

        }

        System.out.println(visited[k]);


    }
}
