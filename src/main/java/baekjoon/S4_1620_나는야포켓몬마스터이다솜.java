package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] list = new String[n+1];
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            list[i] = name;
            map.put(name,i);
        }

        for(int i = 0; i < m; i++){
            String q = br.readLine();
            if(map.containsKey(q)){
                answer.append(map.get(q)+"\n");
            } else {
                answer.append(list[Integer.parseInt(q)]+"\n");
            }
        }
        System.out.println(answer);
    }
}
