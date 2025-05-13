package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class Lv2_방문길이 {

    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && 11 > nx && 0 <= ny && 11 > ny;
    }

    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    private static int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>();

        for(int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny)) {
                continue;
            }
            answer.add(x + "," + y + " - " + nx + "," + ny);
            answer.add(nx + "," + ny + " - " + x + "," + y);
            x = nx;
            y = ny;
        }

        return answer.size()/2;
    }

    public static void main(String[] args) {
        int count = solution("ULURRDLLU");
        System.out.println(count); // 7
    }
}
