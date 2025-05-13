package example.hash;

import java.util.Arrays;

public class Chaining {
    static int base = 31;
    static String[] key = new String[1_000_003];
    static int[] head = new int[1_000_003];
    static int[] pre = new int[1_000_003];
    static int[] nxt = new int[1_000_003];
    static int unused = 0;


    static void insert(String str){
        key[unused] = str;
        int hash = hash(str);

        if(head[hash] == -1){
            head[hash] = unused;
            pre[unused] = -1;
            nxt[unused] = -1;
        } else {
            pre[head[hash]] = unused;
            nxt[unused] = head[hash];
            head[hash] = unused;
            pre[unused] = -1;
        }
        unused++;
    }

    static int find(String str){
        int hash = hash(str);
        int cur = head[hash];
        if(cur == -1){
            System.out.println("해당 값이 없습니다");
            return -1;
        }

        while(cur != -1){
            if(key[cur].equals(str)){
                System.out.println(key[cur]);
                return cur;
            }
            cur = nxt[cur];
        }

        System.out.println("해당 값이 없습니다.");
        return -1;
    }

    static void delete(String str){
        int index = find(str);

        if(index == -1){
            System.out.println("해당 값을 찾을 수 없습니다.");
            return;
        }

        if(pre[index] != -1){
            nxt[pre[index]] = nxt[index];
        } else head[hash(str)] = nxt[index];

        if(nxt[index] != -1){
            pre[nxt[index]] = pre[index];
        }
    }

    static int hash(String str){
        long hash = 0;
        // long power = 1;
        for(int i = 0; i < str.length(); i++){
            int c2i = mapping(str.charAt(i));
            // hash += c2i * power
            // power *= base;
            hash = hash * base + c2i; // 진법 계산 식
        }
        return (int) (hash % 1_000_003);
    }

    static int mapping(char c){
        if(Character.isLowerCase(c)){
            return c - 'a' + 1;
        } else if(Character.isUpperCase(c)){
            return c - 'A' + 27;
        } else if (Character.isDigit(c)){
            return c - '0' +  53;
        } else
            return 0;
    }


    public static void main(String[] args) {
        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);
        Arrays.fill(head, -1);


        insert("apple");
        insert("banana");
        insert("cherry");

        find("banana");
        delete("banana");
        find("banana"); // "해당 값이 없습니다" 출력

        insert("banana");
        find("banana");

    }
}
