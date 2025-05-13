package example.arrays;

import java.util.Arrays;

public class ArraysEx {
    public static void main(String[] args) {

        // 배열 복사
        int[] a = {1,2,3,4,5};
        int[] arr2 = Arrays.copyOf(a, a.length);
        int[] arr3 = Arrays.copyOf(a, 3);
        // toString() -> 배열의 모든 요소를 문자열로 편하게 출력할 수 있게 해준다. 1차원 배열에만 사용가능
        // arr.toString() -> 아니다
        // stream().toString() 이런거 없다....
        // 모든 기본형과 참조형에 대해 정의되어 있음
        System.out.println(Arrays.toString(arr2));
    }
}
