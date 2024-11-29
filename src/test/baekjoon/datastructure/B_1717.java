package test.baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1717 {
    /**
     * 0 -> 합집합 연산 1 -> 두 개의 요소가 포함된 집합이 있는지 확인
     * <p>
     * Union-find 알고리즘으로 풀어야하는 문제 초기화된 집합에 부모를 연결하여 합집합이 될 때 동일한 부모 노드를 쳐다보도록 처리 부모는 수가 더 작게 설정해야 트리가 한쪽으로 치우치는 문제를 해결할
     * 수 있음
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(parent, a, b);
            } else {
                if (find(parent, a) == find(parent, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static int find(int[] parent, int x) {
        if (parent[x] != x) {
            // 경로 압축을 위해 반드시 parent[x]에 재귀함수 결과 대입
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    public static void union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        // 트리 구조 유지를 위해 반드시 rootA, rootB를 대입
        if (rootA != rootB) {
            if (rootA < rootB) {
                parent[b] = rootA;
            } else {
                parent[a] = rootB;
            }
        }
    }
}
