package Lv_2;

/*
문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 */

import java.util.*;

public class Ex001 {
    public String solution(String s) {
        // 데이터 준비
        String[] arr = s.split(" ");
        int[] answer = new int[arr.length];

        // 정수로 변환
        for (int i=0; i<arr.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }

        // 정렬
        Arrays.sort(answer);

        // 리턴
        return answer[0]+" "+answer[arr.length-1];
    }
}
