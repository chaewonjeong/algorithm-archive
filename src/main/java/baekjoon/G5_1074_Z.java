package baekjoon;

import java.util.Scanner;

public class G5_1074_Z {

    static int fun(int n, int r, int c){
        if (n == 0) {
            return 0;
        }
        int half = (int)Math.pow(2,n-1);

        if(r < half && c < half){
            return fun(n-1, r, c);
        } else if (r < half && c >= half){
            return half * half + fun(n - 1, r, c - half);
        } else if(r >= half && c < half){
            return 2 * half * half + fun(n - 1, r - half, c);
        } else {
            return 3 * half * half + fun(n - 1, r - half, c - half);
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(fun(n, r, c));

    }
}
