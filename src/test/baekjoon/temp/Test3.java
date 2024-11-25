package test.baekjoon.temp;

public class Test3 {
    public static void main(String[] args) {
        int[][] nodes = {{0,1,1,1},{1,0,0,0},{1,0,0,0},{0,0,1,0}};
        int cycle = 3;
        boolean[][] graph = new boolean[4][4];

        for(int i = 0; i < nodes.length; i++) {
            for(int j = 0; j < nodes.length; j++) {
                graph[i][j] = nodes[i][j] == 1;
            }
        }

        findCycle(graph, cycle);
    }

    public static void findCycle (boolean[][] graph, int cycle) {
        int count = 0;

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph.length; j++) {
            }
        }

        System.out.println(cycle == count ? 1 : 0);
    }

}
