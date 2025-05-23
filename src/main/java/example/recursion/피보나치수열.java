package example.recursion;

public class 피보나치수열 {
    static int[] fibo;
    // n 항의 갯수
    public static int DFS(int n) {
        // 메모이제이션
        if(fibo[n] != 0) return fibo[n];

        if(n == 1) return fibo[n] = 1 ;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1];

        DFS(n);

        for(int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
