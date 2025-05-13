package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_5014_스타트링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        int[] level = new int[f+1];

        queue.add(s);
        level[s] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == g){
                System.out.println(level[now]);
                return;
            }
            int nextUp = now + u;
            int nextDown = now - d;

            if(nextUp <= f && nextUp >= 0 && nextUp != now && level[nextUp] == 0) {
                queue.add(nextUp);
                level[nextUp] = level[now] + 1;
            }

            if (nextDown > 0 && nextDown <= f && nextDown != now && level[nextDown] == 0) {
                queue.add(nextDown);
                level[nextDown] = level[now] + 1;
            }
        }

        System.out.println("use the stairs");

    }
}
