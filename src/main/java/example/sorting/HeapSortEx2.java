package example.sorting;

import java.util.Arrays;

public class HeapSortEx2 {
    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 왼쪽 자식이 루트보다 크면 largest 갱신
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        // largest가 기존 값에서 바뀜 -> 루트 노드의 값이 최대가 아니 값교환
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr){
        int n = arr.length;
        // 최대 힙 구축
        // 자식이 없는 리프 노드는 heapify 연산 x 따라서 n/2 -1 부터 시작
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 최대 힙에서 요소를 제거하면서 배열 정렬
        for(int i = n - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 최상위 노드 부터 하위 노드 방향으로 heapify 실행
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 7, 2, 6, 8, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
