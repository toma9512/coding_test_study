package Lv_2;

/*
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */

import java.util.*;

public class Ex056 {
    // 데이터 준비
    Set<Integer> set = new HashSet<>(); // 소수 담을 set
    boolean[] check; // 방문 확인용
    boolean[] arr = new boolean[10000001]; // 소수 확인용


    public int solution(String numbers) {
        // 데이터 준비
        String[] strArr = numbers.split("");
        check = new boolean[numbers.length()];

        // 소수 인덱스를 false로 두기
        double root = Math.pow(10000001,0.5);
        arr[0] = true;
        arr[1] = true;
        for (int i=2; i<root; i++) {
            if (!arr[i]) {
                for (int k=2; k<10000001/i; k++) {
                    arr[i*k] = true;
                }
            }
        }

        dfs(strArr, 1, ""); // 재귀

        // 리턴
        return set.size();
    }

    void dfs(String[] strArr, int len, String word) {
        if (strArr.length < len) return; // 종료 지점

        for (int i=0; i<strArr.length; i++) {
            if (check[i]) continue; // 방문 했으면 패스
            String temp = word; // 초기화

            check[i] = true; // 방문 체크

            temp += strArr[i];
            int num = Integer.parseInt(temp);
            if (!arr[num]) set.add(num);
            dfs (strArr, len+1, temp);

            check[i] = false; // 방문 해제
        }
    }
}
