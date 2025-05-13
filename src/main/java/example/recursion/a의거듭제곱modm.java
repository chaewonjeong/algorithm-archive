package example.recursion;

public class a의거듭제곱modm {
    static int solution(int a, int b, int m){
        long val = 1;
        for(int i = 0; i < b; i++){
            val = (val * a) % m;
        }
        return (int)val;
    }
    public static void main(String[] args) {
        System.out.println(solution(123, 3, 12));
    }
}
