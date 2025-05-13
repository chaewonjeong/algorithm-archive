package example.linkedList;

public class LinkedListExample {
    // 야매 연결 리스트
    static final int MAX = 1_000_003;

    static class YameLinkedList {
        private int [] dat;
        private int [] pre;
        private int [] nxt;
        private int unused;

        public YameLinkedList(int capacity) {
            dat = new int[capacity];
            pre = new int[capacity];
            nxt = new int[capacity];
            unused = 1;

            nxt[0] = -1;

            for(int i = 0 ; i < capacity ; i++) {
                pre[i] = -1;
                nxt[i] = -1;
            }

        }

        public void traverse() {
            int cur = nxt[0];
            while(cur != -1) {
                System.out.println(dat[cur]);
                cur = nxt[cur];
            }
            System.out.println();
        }

        public void insert(int addr, int x) {
            if(unused >= dat.length) {
                System.out.println("연결 리스트가 가득 찼습니다.");
                return;
            }

            dat[unused] = x;
            pre[unused] = addr;
            nxt[unused] = nxt[addr];

            if(nxt[addr] != -1) pre[nxt[addr]] = unused;
            nxt[addr] = unused;
            unused++;
        }

        public void erase(int addr) {
            // 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
            nxt[pre[addr]] = nxt[addr];

            // 삭제할 위치의 다음 원소의 pre를 삭제할 위치의 pre로 변경
            if(nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
        }

    }



    public static void main(String[] args) {
        YameLinkedList list = new YameLinkedList(MAX);
        YameLinkedList list2 = new YameLinkedList(MAX);
    }

}
