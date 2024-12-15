package test.leetcode;

public class FindFirstOccurrence {
    public int strStr(String haystack, String needle) {
        // 문제
        // haystack에서 needle이 존재할 때 첫 번째 인덱스 반환
        // 없다면 -1 반환

        // 고려사항
        // 문자열의 길이는 1 ~ 10,000까지
        // 모두 소문자로 구성되어 있음

        // 문제해결
        // haystack이 needle보다 길이가 작다면 -1
        // haystack과 needle의 길이가 1이거나 같다면 equals로 비교 후 -1 또는 0
        // 0부터 반복을 수행하며, hastack - needle.length 길이까지 수행
        // 현재 인덱스 + needle의 길이만큼 substring으로 확인
        // 첫 번째 인덱스를 반환해야하기 때문에 조건에 해당한다면 즉시 index return

        int haystackSize = haystack.length();
        int needleSize = needle.length();

        if (haystackSize < needleSize)
            return -1;

        if (haystackSize == needleSize) {
            return haystack.equals(needle) ? 0 : -1;
        }

        for (int i = 0; i <= haystackSize - needleSize; i++) {
            String sub = haystack.substring(i, i + needleSize);
            if(sub.equals(needle)) return i;
        }

        return -1;
    }
}
