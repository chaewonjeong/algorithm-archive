package example.recursion;

public class 이진수출력 {
    public static void DFS(int n) {
        if(n == 0) return;
        DFS(n/2);
        System.out.print(n%2);
    }

    public static void main(String[] args) {

        DFS(33);

    }
}
