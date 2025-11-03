package Lv_2;

/*
문제 설명
자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
x에 n을 더합니다
x에 2를 곱합니다.
x에 3을 곱합니다.
자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

제한사항
1 ≤ x ≤ y ≤ 1,000,000
1 ≤ n < y
 */

import java.util.*;

public class Ex046 {
    public int solution(int x, int y, int n) {
        // 데이터 준비
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        boolean check = false;
        set.add(x);

        if (x==y) return 0;

        // 반복
        while (!set.isEmpty()) {
            Set<Integer> temp = new HashSet<>();
            answer++;
            for (Integer num : set) {
                if (num+n==y || num*2==y || num*3==y) {
                    check = true;
                    break;
                }
                if (check) break;
                if (num+n < y) temp.add(num+n);
                if (num*2 < y) temp.add(num*2);
                if (num*3 < y) temp.add(num*3);
            }
            if (check) break;
            set = temp;
        }

        // 리턴
        return check ? answer : -1;
    }
}
