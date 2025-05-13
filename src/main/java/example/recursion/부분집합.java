package example.recursion;

public class 부분집합 {
    static int n;
    static int[] ch; // 방문 정보를 기록하는 배열 여기서는 각 자연수가 부분집합에 포함되었는지(1) 안돼었는지(0)로 구분

    public static void DFS(int L) {
        if(L == n+1){ // 4에 도달하면 방문 정보를 리턴
            for(int i = 1; i < ch.length; i++){
                if(ch[i] == 1){
                    System.out.print(i + " ");
                }
            }
            System.out.println();

        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {
        // 1부터 n까지의 자연수로 만들 수 있는 공집합을 제외한 부분집합 구하기
        n = 3;
        ch = new int[n+1];
        // L : 시작 노드 즉 1
        DFS(1);
    }

}
