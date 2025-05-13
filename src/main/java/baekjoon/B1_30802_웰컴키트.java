package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B1_30802_웰컴키트 {
    /*
    티셔츠는 같은 사이즈로 T장씩 묶음으로만 주문 가능

    펜은 P자루씩 묶음으로 주문하거나 한자루씩 주문 가능

    참가자 총 N명
    티셔츠는 남아도 되나 부족해서는 안되고 펜은 정확히 참가자 수만큼 준비되어야함

    티셔츠는 T 장씩 몇묶음 주문 최소 묶음 구하기

    펜은 P 자루씩 몇묶음 + 한자루씩 몇개
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int countT = 0;

        String[] sizes = sc.nextLine().split(" ");

        for(String s : sizes) {
            list.add(Integer.parseInt(s));
        }

        int T = sc.nextInt();
        int P = sc.nextInt();

        for(int l : list){
            if (l == 0) {
                continue;
            }
            if (l <= T) {
                countT++;
            } else {
                countT += l / T;
                if ((l % T) != 0) countT++;
            }
        }
        System.out.println(countT);
        System.out.println(n/P + " " + n%P);
    }
}
