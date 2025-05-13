package programmers.kakao;

public class Lv3_추석트래픽 {
    static int solution(String[] lines){
        //todo
        // 기준이 되는 시간의 시작점 -> 로그의 시작과 끝?
        int logSize = lines.length;
        int[] startTime = new int[logSize];
        int[] endTime = new int[logSize];

        for(int i = 0; i < logSize; i++){
            String[] str = lines[i].split(" ");
            System.out.println(str[1]);

        }

        int max = 0;

        return max;
    }

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        System.out.println(solution(lines));
    }
}
