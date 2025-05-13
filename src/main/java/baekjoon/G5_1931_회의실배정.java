package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class G5_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

//        ArrayList<int[]> sorted = list.stream()
//                .sorted(Comparator.comparing((int []i) -> i[1])
//                        .thenComparing((int []i) -> i[0]))
//                .collect(Collectors.toCollection(ArrayList::new));

        list.sort(Comparator.comparingInt((int[] a) -> a[1]).thenComparing(a -> a[0]));


        int count = 1;
        int tmp = list.get(0)[1];

        for(int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] >= tmp) {
                tmp = list.get(i)[1];
                count++;
            }
        }

        System.out.println(count);
    }
}
