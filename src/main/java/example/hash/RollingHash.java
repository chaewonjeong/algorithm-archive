package example.hash;

public class RollingHash {
    private static final int BASE = 31;
    private static final int MOD = 1_000_000_007;

    // 문자의 해시값
    private static int mapping(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a' + 1; // a : 1 ~ z : 26
        } else if (Character.isUpperCase(c)) {
            return c - 'A' + 26;
        } else if (Character.isDigit(c)) {
            return c - '0' + 53;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "asdf";

        s.hashCode();
    }



}
