package Lv_2;

/*
문제 설명

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
 */

import java.util.*;

public class Ex042 {
    public int[] solution(int[] prices) {
        // 데이터 준비
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();

        // 확인
        for (int i=0; i<prices.length; i++) {
            if (stack.isEmpty()) {
                stack.add(new int[] {prices[i],i});
                continue;
            }

            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                int[] arr = stack.pop();
                answer[arr[1]] = i-arr[1];
            }
            stack.add(new int[] {prices[i],i});
        }
        for (int[] arr : stack) {
            answer[arr[1]] = answer.length-1-arr[1];
        }

        // 리턴
        return answer;
    }
}
