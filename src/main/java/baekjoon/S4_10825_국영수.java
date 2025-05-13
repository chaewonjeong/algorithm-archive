package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_10825_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String[]> students= new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] student = new String[4];
            student[0] = st.nextToken();
            student[1] = st.nextToken();
            student[2] = st.nextToken();
            student[3] = st.nextToken();
            students.add(student);
        }

         students.stream().sorted(
                Comparator.comparing((String [] o) -> Integer.parseInt(o[1]),Comparator.reverseOrder())
                        .thenComparing((String [] o) -> Integer.parseInt(o[2]))
                        .thenComparing((String [] o) -> Integer.parseInt(o[3]), Comparator.reverseOrder())
                        .thenComparing((String [] o) -> o[0]))
                .forEach((String[] o) -> answer.append(o[0]).append("\n"));

        System.out.println(answer);

    }
}
