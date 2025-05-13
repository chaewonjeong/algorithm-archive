package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_6064_카잉달력 {

    static int lcm(int a, int b) {
        BigInteger ba = new BigInteger(String.valueOf(a));
        BigInteger bb = new BigInteger(String.valueOf(b));
        int gcd = ba.gcd(bb).intValue();
        return a / gcd * b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean isValid = false;

            // 구해야할 year 를 M으로 나눈 나머지 -> x
            // 구해야할 year 를 N으로 나눈 나머지 -> y
            // <M:N> -> 마지막 해 -> M과 N의 LCM
            int limit = lcm(M, N);

            ArrayList<Integer> yearList = new ArrayList<>();

            for(int i = x; i <= limit; i += M) {
                yearList.add(i);
            }

            for(long i : yearList) {
                int mod = i % N == 0 ?  N : (int) (i % N);
                if ( mod == y){
                    answer.append(i).append('\n');
                    isValid = true;
                    break;
                }
            }
            if(!isValid) answer.append(-1).append('\n');
        }
        System.out.println(answer);
    }
}
