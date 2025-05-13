package example.sorting;

import java.util.Arrays;

public class mergeSortEx {
    public static void mergeSort(int[] array){
        if(array.length <= 1){ // 분할되서 1이 되면 멈춤
            return;
        }
        int mid = array.length/2; // 배열의 중간을 기준으로 나눠야 하니 mid
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        // 합치고 정렬하는 과정
        // 마찬가지로 재귀적으로
        merge(array, left, right);
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
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before Sorting: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("After Sorting: " + Arrays.toString(array));

    }
}
