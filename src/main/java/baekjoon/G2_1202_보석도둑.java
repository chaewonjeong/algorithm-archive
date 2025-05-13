package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        // 가장 가격이 높은 보석부터 확인하며 해당 보석을 담을 수 있는 가방 중 최대 무게가가
        // 가장 작은 가방을 이용해 보석을 담는게 최대 이득이다.
        // 가방에는 최대 한개의 보석만

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long price = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Integer>> jewel = new TreeMap<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel.computeIfAbsent(v, key -> new ArrayList<>()).add(m);
        }


        TreeMap<Integer, Integer> bag = new TreeMap<>();

        for(int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bag.put(c, bag.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Integer, ArrayList<Integer>> jew : jewel.entrySet()) {
            int val = jew.getKey(); // 가격
            ArrayList<Integer> wList = jew.getValue();
            wList.sort(Integer::compareTo);

            for (int w : wList) {
                Integer bagWeight = bag.ceilingKey(w);
                if(bagWeight != null) {
                    price += val;
                    if(bag.get(bagWeight) == 1) {
                        bag.remove(bagWeight);
                    } else {
                        bag.put(bagWeight, bag.get(bagWeight) - 1);
                    }
                }

            }
        }

        System.out.println(price);


    }
}
