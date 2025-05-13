package baekjoon;
import java.util.*;

public class G4_2800_괄호제거 {

    static int[] ch;
    static ArrayList<int[]> list = new ArrayList<>();
    static Set<String> resultSet = new TreeSet<>();

    public static void DFS(int L, int n, String str) {
        if (L == n + 1) {
            boolean allZero = true;
            for (int num : ch) {
                if (num == 1) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) return;

            StringBuilder sb = new StringBuilder(str);
            List<Integer> removeIndexes = new ArrayList<>();

            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    int[] x = list.get(i);
                    removeIndexes.add(x[0]);
                    removeIndexes.add(x[1]);
                }
            }

            removeIndexes.sort(Comparator.reverseOrder());
            for (int idx : removeIndexes) {
                sb.deleteCharAt(idx);
            }

            resultSet.add(sb.toString());
        } else {
            ch[L] = 1;
            DFS(L + 1, n, str);
            ch[L] = 0;
            DFS(L + 1, n, str);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    int n = stack.pop();
                    list.add(new int[]{n, i});
                }
            }
        }

        ch = new int[list.size()];
        DFS(0, ch.length - 1, str);

        for (String res : resultSet) {
            System.out.println(res);
        }
    }
}
