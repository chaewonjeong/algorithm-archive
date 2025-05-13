package programmers.kakao;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
// 문제의 조건 사항에 따라 분리된 각 그래프들을 모두 순회하면서 그래프를 판별했다.
// 더 나은 풀이는 도넛, 막대, 8자 그래프의 판별을 더 좁은 범위에서 할 수 없는지 찾아보자..
// 이문제의 경우 각 그래프의 특징을 in,outdegree의 수를 세는걸로 간단하게 판별 가능하다...
// 개선 버전도 코딩해보자..

public class Lv2_도넛과막대그래프 {
    //static int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
    //static int[][] edges = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int numNodes;
    static int[] indegree;
    static int[] outdegree;
    static int extraNode;

    static int[] checkGraphShape(int extraNode){
        int[] answer = new int[4];
        answer[0] = extraNode;

        ArrayList<Integer> baseNodes = adjList[extraNode];
        for(int innerNode : baseNodes){
            int countVertex = 0;
            int countEdge = 0;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(innerNode);
            countVertex++;
            visited[innerNode] = true;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next: adjList[cur]){
                    if(!visited[next]){
                        visited[next] = true;
                        countEdge++;
                        countVertex++;
                        queue.add(next);
                    } else {
                        countEdge++;
                    }
                }
            }
            //System.out.println(countVertex + " " + countEdge);
            int n = 1;
            while (true) {
                if(n == countVertex && n == countEdge){
                    answer[1]++;
                    break;
                }
                if (n == countVertex && n - 1 == countEdge){
                    answer[2]++;
                    break;
                }
                if (2*n + 1 == countVertex && 2*n + 2 == countEdge){
                    answer[3]++;
                    break;
                }
                n++;
            }
        }

        return answer;
    }


    // 그래프를 순회하면서 그래프의 모양을 판별해라
    public static int[] solution(int[][] edges) {
        numNodes = 0;
        for(int i = 0; i < edges.length; i++) {
            for(int v : edges[i]) {
                numNodes = Math.max(numNodes, v);
            }
        }

        visited = new boolean[numNodes + 1];
        adjList = new ArrayList[numNodes + 1];

        for(int i = 0; i <= numNodes; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
        }

        indegree = new int[numNodes + 1];
        outdegree = new int[numNodes + 1];

        for (int i = 0; i <= numNodes; i++) {
            for(int v : adjList[i]) {
                outdegree[i]++;
                indegree[v]++;
            }
        }

        extraNode = -1;
        for(int i = 1; i <= numNodes; i++) {
            if(indegree[i] == 0 && outdegree[i] > 1) {
                extraNode = i;
                break;
            }
        }

        return checkGraphShape(extraNode);
    }

    public static void main(String[] args) {
//        for(int i : solution(edges)) {
//            System.out.print(i + " ");
//        }
    }
}
