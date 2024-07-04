package test.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2869 {
    public static void main(String[] args) throws IOException {
        /*
         * 하루에 올라갈 수 있는 미터 : A - B
         * 하루가 끝난 시간 기준으로 A를 먼저 더 해보고 조건판단
         * 만약, A == V 같다면 하루만에 완등 가능
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int dayDist = a - b;
        int goalDist = v - b; // 도달한 순간에는 b를 빼면안되기 때문에 v-b를 목적지로 선정

        if(goalDist % dayDist != 0){
            // 나머지가 있는 경우 하루를 더 추가해야함
            System.out.println(goalDist/dayDist + 1);
        } else {
            System.out.println(goalDist/dayDist);
        }
    }
}