package programmers.kakao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lv3_베스트앨범_best {

    static class Song {
        int id;
        String genre;
        int play;

        public Song(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();
        // 고유번호 - 장르 - 재생횟수
        for (int i = 0; i < plays.length; i++) {
            songs.add(new Song(i,genres[i],plays[i]));
        }

        Map<String, List<Song>> genreMap = songs.stream().collect(Collectors.groupingBy(song -> song.genre));

        List<Map.Entry<String, List<Song>>> sortedGenres = genreMap.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(s -> s.play).sum();
                    int sum2 = e2.getValue().stream().mapToInt(s -> s.play).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toList());
        List<Integer> answer = new ArrayList<>();

        for(Map.Entry<String, List<Song>> entry : sortedGenres) {
            List<Song> topSongs = entry.getValue().stream()
                    .sorted(Comparator.comparing((Song s) -> s.play).reversed()
                            .thenComparing(s -> s.id)).limit(2).collect(Collectors.toList());

            for (Song song : topSongs) {
                answer.add(song.id);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
