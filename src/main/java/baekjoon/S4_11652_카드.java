package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class S4_11652_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<BigInteger, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            BigInteger num = new BigInteger(br.readLine());
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
    // thenComparing 을 쓰고 싶다면 Comparator 객체를 명시적으로 만들어야함
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<BigInteger,Integer>::getValue, Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(1)
                .forEach(System.out::println);

    }
}
