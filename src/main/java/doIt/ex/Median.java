package doIt.ex;

public class Median {
    static int med3(int a, int b, int c) {
        if (a >= b && a <= c) {
            return a;
        } else if (b >= c && b <= a) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {

    }
}
