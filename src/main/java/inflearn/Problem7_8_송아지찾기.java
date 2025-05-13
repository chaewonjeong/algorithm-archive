package inflearn;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem7_8_송아지찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dis = {1,-1,5};

        int[] arr = new int[10001];

        int s = sc.nextInt();
        int e = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();

        int level = 0;

        q.add(s);
        arr[s] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int cur = q.poll();
                if(cur == e) {
                    System.out.println(level);
                    return;
                }
                for (int j = 0; j < 3; j++) {
                    int next = cur + dis[j];
                    if(next>=1 && next<=10000 && arr[next]==0) {
                        q.add(next);
                        arr[next] = 1;
                    }
                }
            }
            level++;
        }


    }
}
