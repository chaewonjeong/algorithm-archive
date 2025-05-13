package programmers.kakao;

import java.util.*;
import java.util.stream.Collectors;

public class Lv3_베스트앨범 {

    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     */

    // 장르 별로 가장 많이 재생된 노래를 두개씩 모아
    // 노래의 고유번호 -> index
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<String[]> songs = new ArrayList<>();
        // 고유번호 - 장르 - 재생횟수
        for (int i = 0; i < plays.length; i++) {
            songs.add(new String[]{String.valueOf(i), genres[i], String.valueOf(plays[i])});
        }


        List<Integer> answer = songs.stream().collect(
                Collectors.groupingBy(o -> o[1], Collectors.toList()))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(song -> Integer.parseInt(song[2])).sum();
                    int sum2 = e2.getValue().stream().mapToInt(song -> Integer.parseInt(song[2])).sum();
                    return Integer.compare(sum1, sum2);
                })
                .flatMap(entry -> entry.getValue().stream()
                .sorted((a,b) -> {
                    int comp = Integer.compare(Integer.parseInt(b[2]), Integer.parseInt(a[2]));
                    if(comp == 0) {
                        return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
                    }
                    return comp;
                })
                .limit(2))
                .map(song -> Integer.parseInt(song[0])).collect(Collectors.toList());
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}

