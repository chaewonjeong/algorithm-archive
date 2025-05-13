package baekjoon;

import java.util.*;

public class S5_10814_나이순정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            list.add(new String[]{strs[0], strs[1]});
        }

        list.sort(Comparator.comparingInt(arr -> Integer.parseInt(arr[0])));
        // list의 sort는 stable sort
        for (String[] entry : list) {
            System.out.println(entry[0] + " " + entry[1]);
        }
    }
}

