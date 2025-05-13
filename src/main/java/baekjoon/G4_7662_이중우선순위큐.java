package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test ; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for(int i = 0 ; i < k ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                switch(cmd) {
                    case "I":
                        if(!map.containsKey(n)) {
                            map.put(n, 0);
                        }
                        map.put(n, map.get(n) + 1);
                        break;
                    case "D":
                        if(!map.isEmpty()){
                            if(n == -1){
                                int key = map.firstKey();
                                map.put(key, map.get(key) - 1);
                                if(map.get(key) == 0){
                                    map.remove(key);
                                }
                            } else if (n == 1){
                                int key = map.lastKey();
                                map.put(key, map.get(key) - 1);
                                if(map.get(key) == 0){
                                    map.remove(key);
                                }
                            }
                        }
                        break;
                }
            }

            if(map.isEmpty()){
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }

        }
    }
}
