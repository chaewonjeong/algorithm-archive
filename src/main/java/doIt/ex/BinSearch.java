package doIt.ex;

public class BinSearch {
    static int binSearch(int[] arr, int n, int target) {
        int pl = 0;
        int pr = n-1;

        do {
            int pc = (pl+pr)/2; // 배열 인덱스의 center 값

            if(arr[pc] == target) {
                return pc;
            } else if(arr[pc] < target) {
                pl = pc+1;
            } else
                pr = pc-1;
        } while(pl <= pr);
        return -1;
    }


}
