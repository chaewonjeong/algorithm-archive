package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S5_2628_종이자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();


        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(c == 0){
                y.add(p);
            } else if(c == 1){
                x.add(p);
            }
        }


        int[] sortedX = x.stream().sorted().mapToInt(Integer::valueOf).toArray();
        int[] sortedY = y.stream().sorted().mapToInt(Integer::valueOf).toArray();

        int maxX = sortedX[0] - 0;
        for(int i = 0; i < sortedX.length - 1; i++) {
            maxX = Math.max(maxX, sortedX[i+1]-sortedX[i]);
        }
        maxX = Math.max(maxX, n - sortedX[sortedX.length-1]);

        int maxY = sortedY[0] - 0;
        for(int i = 0; i < sortedY.length - 1; i++) {
            maxY = Math.max(maxY, sortedY[i+1]-sortedY[i]);
        }
        maxY = Math.max(maxY, m - sortedY[sortedY.length-1]);


        System.out.println(maxX*maxY);

    }
}
