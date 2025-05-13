package ctp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 깊이 우선 탐색으로 모든 그래프의 노드를 순회하는 함수 solution()을 작성하세요. 시작 노드는 start로 주어집니다. graph는 [출발 노드, 도착 노드]
 * 쌍들이 들어 있는 리스트입니다. 반환값은 그래프의 시작 노드부터 모든 노드를 깊이 우선 탐색으로 진행한 순서대로 노드가 저장된 리스트입니다.
 * DFS 로 탐색했을때의 순서를 출력하세요
 * 노드의 최대 개수는 100개를 넘지 않습니다.
 * 시작 노드부터 시작해서 모든 노드를 방문할 수 있는 경로가 항사 있습니다.
 * 그래프의 노드는 문자열입니다.
 */
public class P35_DFS {
    // 인접리스트를 저장할 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;


    static int[] solution(int[][] graph, int start, int n){

        // 인접 리스트로 그래프 구현하기
        adjList = new ArrayList[n+1]; //노드의 개수만큼 초기화

        for(int i = 0; i < adjList.length; i++){
            adjList[i] = new ArrayList<>(); // ArrayList생성자로 초기화 해줘야 함!
        }

        for(int[] edge:graph){
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n+1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static void dfs(int node){
        visited[node] = true;
        answer.add(node);

        for(int next : adjList[node]){
            if(!visited[next]){
                dfs(next); // 방문하지 않았다면 계속 탐색
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph_1 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] graph_2 = new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};

        System.out.println(Arrays.toString(solution(graph_1,1,5)));
        System.out.println(Arrays.toString(solution(graph_2,1,6)));


    }
}
