package baekjoon;


import java.util.Scanner;

public class S3_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // 1이 소수가 아님을 적어줘야함
        arr[1] = 0;

        for(int i=2; i*i<=n; i++){
            if(arr[i]==0) continue;
            for(int j=i+i; j<=n; j+=i){
                arr[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if(arr[i]!=0){
                System.out.println(arr[i]);
            }
        }

    }
}
