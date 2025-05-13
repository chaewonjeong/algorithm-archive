package example.hash;

import java.util.Arrays;

public class OpenAddressing {
    static int M = 40;
    static int base = 3;

    static final int EMPTY = -1;
    static final int OCCUPY = 0;
    static final int DUMMY = 1;

    static int[] status = new int[M];
    static String[] key = new String[M];
    static int[] value = new int[M];

    static int hash(String s){
        long hash = 0;
        for(int i = 0; i < s.length(); i++){
            int c2i = mapping(s.charAt(i));
            hash = hash * base + c2i;
        }
        return (int) hash % M;
    }

    static int mapping(char c) {
        if(Character.isLowerCase(c)){
            return c - 'a' + 1;
        } else if (Character.isUpperCase(c)){
            return c - 'A' + 27;
        } else if (Character.isDigit(c)){
            return c - '0' + 53;
        } else {
            return 0;
        }
    }

    static int find(String s){
        int index = hash(s);
        while(status[index] != EMPTY){
            if(status[index] == OCCUPY && key[index].equals(s)){
                return index;
            }
            index = (index + 1) % M;
        }
        return -1;
    }

    static void insert (String k, int val){
        int index = find(k);
        if(index != -1){
            value[index] = val;
            return;
        }
        index = hash(k);
        while(status[index] == OCCUPY){
            index = (index + 1) % M;
        }
        key[index] = k;
        value[index] = val;
        status[index] = OCCUPY;
    }

    static void erase (String k){
        int index = find(k);
        if(index != -1){
            status[index] = DUMMY;
        }
    }


    static void printHash(String key) {
        int h = hash(key);
        System.out.println("Hash of \"" + key + "\": " + h);
    }


    public static void main(String[] args) {

        Arrays.fill(status, EMPTY);
        System.out.println("===== OpenAddressing Hash Table Test =====");

        // 기본 삽입
        insert("apple", 100);
        insert("banana", 200);
        insert("cherry", 300);

        // 해시값 출력
        printHash("apple");
        printHash("banana");
        printHash("cherry");

        // 삭제 후 재삽입
        erase("banana");
        insert("banana", 250);

        // 충돌 유도 테스트
        String[] similar = {"apple", "ppale", "aelpp", "paple"};
        for (String s : similar) {
            printHash(s);
            insert(s, s.length()); // 값은 문자열 길이로 구분
            System.out.println("Inserted \"" + s + "\" at index: " + find(s));
        }

        System.out.println("===== Test Complete =====");
    }



}
