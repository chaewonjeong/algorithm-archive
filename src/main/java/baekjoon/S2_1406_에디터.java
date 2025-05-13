package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        char[] data = new char[600_005];
        int[] pre = new int[600_005];
        int[] nxt = new int[600_005];
        int unused = 1;
        int head = 0;
        data[0] = '0';

        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);

        String str = br.readLine();

        for(char c : str.toCharArray()) {
            data[unused] = c;
            pre[unused] = head;
            nxt[head] = unused;
            head = unused;
            unused++;
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if(cmd == 'L'){
                if(pre[head] != -1){
                    head = pre[head];
                }
            } else if (cmd == 'D'){
                if(nxt[head] != -1){
                    head = nxt[head];
                }
            } else if(cmd == 'B'){ // 자기 자신을 지우라는 말
                if (head != 0) {
                    nxt[pre[head]] = nxt[head];
                    if(nxt[head] != -1){
                        pre[nxt[head]] = pre[head];
                    }
                    head = pre[head];
                }
            } else if(cmd == 'P'){
                char c = st.nextToken().charAt(0);
                data[unused] = c;

                pre[unused] = head;
                if(nxt[head] != -1){
                    pre[nxt[head]] = unused;
                    nxt[unused] = nxt[head];
                }
                nxt[head] = unused;
                head = unused;
                unused++;
            }
        }

        int cur = nxt[0];
        while (cur != -1) {
            answer.append(data[cur]);
            cur = nxt[cur];
        }

        System.out.println(answer);
    }
}
