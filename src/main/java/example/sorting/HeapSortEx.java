package example.sorting;

import java.util.Arrays;

public class HeapSortEx {

//    public static void heapSort(int[] arr) {
//
//        // 입력 배열을 힙구조로 만들어줌 현재 노드(c) 부모 노드 (root = (c-1)/2)
//        for(int i = 1; i < arr.length; i++) {
//            int c = i;
//            do {
//                int root = (c-1) / 2;
//                if(arr[root] < arr[c]){
//                    int temp = arr[c];
//                    arr[c] = arr[root];
//                    arr[root] = temp;
//                }
//                c = root;
//            } while ( c != 0);
//        }
//
//        // 리프 노드와 루트 노드를 바꿔줌
//        // 크기를 줄여가며..
//        for(int i = arr.length - 1; i > 0; i--) {
//            int temp = arr[0]; // 루트 노드
//            arr[0] = arr[i];
//            arr[i] = temp;
//            int root = 0;
//            int c = 1;
//
//            // 다시 힙구조를 만들어줌
//            do {
//                c = 2 * root + 1; // 루트의 자식 노드중 왼쪽 값
//                if(c < i-1 && arr[c] < arr[c+1]){
//                    c++; // 자식 노드 중 더 큰 값 찾기, 만약 오른쪽 자식이 더 크다면 오른쪽 자식 선택
//                }
//
//                if(c<i &&arr[root] < arr[c]){
//                     temp = arr[c];
//                     arr[c] = arr[root];
//                     arr[root] = temp;
//                }
//                root = c;
//            } while(c < i);
//        }
//    }

    public static void heapSort(int[] arr){
        // heapify
        for(int i = 1; i < arr.length; i++){
            int c = i;
            do{
                int root = (c - 1) / 2;
                if(arr[root] < arr[c]) {
                    int temp = arr[c];
                    arr[c] = arr[root];
                    arr[root] = temp;
                }
                c = root;
            } while(c != 0);
        }

        for(int i = arr.length - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 첫 노드와 마지막 노드 사이의 교환이 일어났으므로 힙구조가 붕괴되었다. 다시한번 heapify;
            int root = 0;
            int c = 1;

            do {
                c = 2 * root + 1;
                if(c < i-1 && arr[c] < arr[c+1]){
                    c++;
                }

                if(c < i && arr[c] > arr[root]){
                    temp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = temp;
                }
                root = c;
            } while(c < i);



        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 2, 6, 8, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
