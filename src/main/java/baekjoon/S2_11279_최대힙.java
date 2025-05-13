package baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S2_11279_최대힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0 ; i < n ; i++) {
            int c = sc.nextInt();
            if(c != 0) {
                pq.add(c);
            } else if(pq.size() == 0 && c == 0) {
                System.out.println(0);
            } else {
                System.out.println(pq.poll());
            }
        }
    }
}
