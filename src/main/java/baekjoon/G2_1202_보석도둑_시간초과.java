package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_1202_보석도둑_시간초과 {
    // todo
    // 맵의 value 값으로 priorityQueue 를 써서 값을 poll 할때 마다 연산 발생..
    public static void main(String[] args) throws IOException {
        // 가장 가격이 높은 보석부터 확인하며 해당 보석을 담을 수 있는 가방 중 최대 무게가가
        // 가장 작은 가방을 이용해 보석을 담는게 최대 이득이다.
        // 가방에는 최대 한개의 보석만

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = 0;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, PriorityQueue<Integer>> jewel = new TreeMap<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel.computeIfAbsent(v, key -> new PriorityQueue<>(Comparator.reverseOrder())).add(m);
        }

        ArrayList<Integer> bag = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bag.add(c);
        }

        Collections.sort(bag);
        boolean[] used = new boolean[k];

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : jewel.entrySet()) {
            PriorityQueue<Integer> jewelWeightList = entry.getValue();
            // priorityQueue 이용시 for - each 순회하면 같은 값밖에 안나옴..
//            for(int weight : jewelWeightList) {
//                for (int i = 0; i < bag.size(); i++) {
//                    if(weight <= bag.get(i)) {
//                        bag.remove(i);
//                        price += entry.getKey();
//                        break;
//                    }
//                }
//            }
            while(!jewelWeightList.isEmpty()) {
                int w = jewelWeightList.poll();
                for(int i = 0; i < k; i++) {
                    if(w <= bag.get(i) && !used[i]) {
                        used[i] = true;
                        price += entry.getKey();
                        break;
                    }
                }

            }
        }

        System.out.println(price);


    }
}
