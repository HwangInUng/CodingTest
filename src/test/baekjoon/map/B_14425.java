package test.baekjoon.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for( int i = 0; i < n; i++) {
            String word = br.readLine();
            map.put(word, 0);
        }

        for(int i = 0; i < m; i++) {
            String word = br.readLine();
            if(map.containsKey(word)){
                count++;
            }
        }

        System.out.println(count);


    }
}
