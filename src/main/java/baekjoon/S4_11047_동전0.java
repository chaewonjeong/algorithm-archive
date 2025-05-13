package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class S4_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(br.readLine());
            set.add(v);
        }
        int count = 0;

        while(k > 0){
            int coin = set.floor(k);
            count++;
            k -= coin;
        }

        System.out.println(count);

    }
}
