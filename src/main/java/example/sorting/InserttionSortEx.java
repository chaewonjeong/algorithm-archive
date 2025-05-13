package example.sorting;

public class InserttionSortEx {
    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1]; // 한칸씩 미는 과정
            }
            arr[j] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};

        insertionSort(arr, arr.length);
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
