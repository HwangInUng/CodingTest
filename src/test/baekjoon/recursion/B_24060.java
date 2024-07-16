package test.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_24060 {
    static int answer = -1;
    static int count;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(answer);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle); // 시작부터 중간까지 : 전반부
            mergeSort(arr, middle + 1, end); // 중간 + 1부터 끝까지 : 후반부
            merge(arr, start, middle, end); // 병합
        }
    }

    public static void merge(int[] arr, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int t = 0;
        int[] temp = new int[end - start + 1];

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++]; // 시작
            } else {
                temp[t++] = arr[j++]; // 중간
            }
        }

        while (i <= middle) { // 왼쪽 배열 부분이 남는 경우
            temp[t++] = arr[i++];
        }
        while (j <= end) { // 오른쪽 배열 부분이 남는 경우
            temp[t++] = arr[j++];
        }

        i = start;
        t = 0;

        while (i <= end) { // 결과를 저장
            count++;
            if (count == k) answer = temp[t];
            arr[i++] = temp[t++];
        }
    }
}
