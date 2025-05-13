package ctp;

import java.util.Arrays;

/**
 * 정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요
 * 정수 배열의 길이는 2이상 10^5 이하 입니다.
 *
 * 문제의 핵심의 제약 조건을 확인하는 것
 * 해당 문제의 입력 배열의 길이가 10^5 이하이기 때문에 O(n^2) 알고리즘은 사용 불가능
 * 자바 표준 api의 sort()를 활용한 방법이 알맞다
 */
public class P1_배열정렬하기 {
    private static int[] solution(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] org = {4, 2, 3, 1, 5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(sorted));
    }
}
