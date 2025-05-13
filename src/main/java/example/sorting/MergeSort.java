package example.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

    static void mergeSort(int[] arr) {
        if(arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr,0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int [] array, int [] left, int [] right){
        int i = 0, j = 0, k = 0; // 각각의 포인터 i : left, j: right, k:array
        // 한개라도 배열의 끝에 닫기 전까지 반복
        while(i < left.length && j < right.length){
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 위 while 문이 다 돌았는데 포인터가 아직 배열의 끝에 닫지 않았다면?? 해당 배열의 남은 값들은 모두 현재벼열보다 크다는것
        // 남은 값들을 정답에 넣어주면 된다...
        while(i < left.length){
            array[k++] = left[i++];
        }

        while(j < right.length){
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
