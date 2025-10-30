package Lv_2;

/*
문제 설명
다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
(), [], {} 는 모두 올바른 괄호 문자열입니다.
만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
s의 길이는 1 이상 1,000 이하입니다.
 */

import java.util.*;

public class Ex020 {
    public int solution(String s) {
        // 데이터 준비
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        // 괄호 회전시키기
        for (int i=0; i<s.length(); i++) {
            // 데이터 초기화
            sb.setLength(0);

            // 회전시키기
            sb.append(s.substring(1));
            sb.append(""+s.charAt(0));
            s = sb.toString();

            // 올바른지 확인
            char[] arr = s.toCharArray();
            List<String> list = new ArrayList<>();
            boolean check = true;
            for (char ch : arr) {
                int n = list.size();
                if (ch=='{' || ch=='(' || ch=='[') {
                    list.add(""+ch);
                } else if (n==0) {
                    check = false;
                    break;
                } else if (ch == ')' &&
                        list.get(n-1).equals("(")) {
                    list.remove(n-1);
                } else if (ch == ']' &&
                        list.get(n-1).equals("[")) {
                    list.remove(n-1);
                } else if (ch == '}' &&
                        list.get(n-1).equals("{")) {
                    list.remove(n-1);
                } else {
                    check = false;
                    break;
                }
            }
            if (list.size()==0 && check) answer++;
        }

        // 리턴
        return answer;
    }
}
