package codetree.삼성_2025_상반기_오후;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Samsung_2025_2 {

    static class House {
        int idx;
        int x;
        int interval;
        House next = null;
        House prev = null;

        public House(int x, int interval) {
            this.x = x;
            this.interval = interval;
        }
    }


    public static void main(String[] args) throws IOException {
        // 명령 cmd
        /*
        100 : 마을 건설
        200 : 개미집 건설
        300 : 개미집 철거
        400 : 개미집 정찰
         */

        // time limit : 3초
        // memory limit : 272 MB
        // 기대 출력 -> 정찰명령(400) -> 보고받는 시간 출력

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        int Q = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();


        HashMap<Integer, House> houseMap = new HashMap<>();
        House queen = new House(0 , 0);
        houseMap.put(0, queen);
        int idx = 1;

        for (int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 100) { // 마을 건설
                int N = Integer.parseInt(st.nextToken());
                for (int i = 0; i < N; i++) {

                    int x = Integer.parseInt(st.nextToken()); // 좌표
                    House prevHouse = houseMap.get(idx - 1);

                    House newHouse = new House(x, x - prevHouse.x);
                    newHouse.idx = idx;
                    prevHouse.next = newHouse;
                    newHouse.prev = prevHouse;
                    houseMap.put(idx++, newHouse);
                }

            } else if (cmd == 200) { //개미집 건설
                int x = Integer.parseInt(st.nextToken()); // 건설 위치 x
                House prevHouse = houseMap.get(idx - 1);

                House newHouse = new House(x, x - prevHouse.x);
                newHouse.idx = idx;
                prevHouse.next = newHouse;
                newHouse.prev = prevHouse;

                houseMap.put(idx++, newHouse);

            } else if (cmd == 300) { // 개미집 철거
                int q = Integer.parseInt(st.nextToken());
                House deletedHouse = houseMap.get(q);

                if(deletedHouse.next == null){ // 마지막 집이면
                    deletedHouse.prev.next = null;
                    idx--;
                } else {
                    deletedHouse.prev.next = deletedHouse.next;
                    deletedHouse.next.prev = deletedHouse.prev;
                    deletedHouse.next.interval = deletedHouse.next.interval + deletedHouse.interval;
                }
                houseMap.remove(q);


            } else if (cmd == 400) {
                int r = Integer.parseInt(st.nextToken()) - 1;
                // 개미집 정찰 -> 1 ~ 100 번



            }
        }
        // 1. 마을 건설
        // 여왕 -> 0
        // 개미집 : 1부터 N
        // 오름차순으로 주어짐


        // 2. 개미집 건설
        // 개미집 위치는 p -> 이전 건설된 위치보다 더 큰 (먼 좌표)
        // k 번째 건설 명령
        // 해당 개미집 번호는 N + k


        // 3. 개미집 철거
        // 철거 대상 : q -> q번 개미집 철거해라
        // ( q 번이 없는 경우 없으)


        // 4. 개미집 정찰 (핵심)
        // 정찰을 나갈 개미의 수 r
        // 선택 -> 일개미들을ㄹ 추발 위치를 선택
        // 각 개미들을 매초 x 값이 1 증가하는 방향으로 이동
        // 개미가 지나는 집 (처음 선택 집 포함)은 안전한 개미집, 여왕 개미집은 항상 안전한 개미집
        // 각 개미들은 처음 만나는 개미집이 안전한 개미집인 경우에는 이동 중지
        // 개미들은 처음 개미집 선택 시, 정찰에 걸리는 시간이 최소가 되도록 적절히 선택

        // 생각 나는 자료구조 -> 배열, 연결리스트 정도 아니면 개미집들과 거리를 맵으로...
        // r 개의 포인터(개미) 들이 전체 리스트를 순회하는데 걸리는 시간이 최소가 되는 위치를 잡아야함
        // 추가적으로 리스트내의 값들에 빈번한 수정이 발생함

        // 1. parameterSearch? 각 개미집들 사이의 거리를 이동시간으로 두고 : 아닌거같음.. 개미의 수를 구하는 것도 아니고 결과적으로 개미의 위치를 알아야하기 때문에..
        // 2. 그리디? -> 개미집을 선택하는 그리디한 방법이 있나?
        // 생각나는 그리디 풀이 -> 각 개미집 사이의 거리를 구간이라 했을때 그 구간의 길이가 가장 큰 곳부터 제외(개미 배치) 시키는 방식

        // 전체 시간 = 구간 A + 구간 B + 구간 C
        // 가장 긴 구간을 먼저 제외시키는 것이 결과적으로 제일 최선의 선택인가??
        // 구간 B가 최대라고 하고 만약 구간 B를 제외 시키지 않고 구간 C나 A를 제외 시켜서는
        // 절대 전체 시간이 B를 제외시킨것보다 짧아 질 수 없음


        // 3. 개미집 간의 간격/정찰개미 수/... 최소시간을 저장할 dp 테이블을 만들 수 있나


        // 정찰시 무조건 1번에는 개미가 있어야함 (개미는 x 가 증가하는 방향으로 나아감)
        // 0번부터 마지막 까지 정찰하는시간 을 최대치라고 하면 1번의 치만큼의 시간이 빠짐 ( 가장 먼 개미집위치 x = 50, 1번 위치 = 2 : 1마리가 정찰시 걸리는 시간의 최대값은 1 번부터 출발하는 경우 -> 48 이자 유일)
        // 2 마리라면? -> 이전 까지의 거리가 가장 큰 곳에 놔두는게 이득인가 ? 그리디한 선택인지 확인해보자





    }
}
