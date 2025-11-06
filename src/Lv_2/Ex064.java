package Lv_2;

/*
문제 설명
호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

제한사항
1 ≤ book_time의 길이 ≤ 1,000
book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
[대실 시작 시각, 대실 종료 시각] 형태입니다.
시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
예약 시각이 자정을 넘어가는 경우는 없습니다.
시작 시각은 항상 종료 시각보다 빠릅니다.
 */

import java.util.*;

public class Ex064 {
    public int solution(String[][] book_time) {
        // 데이터 준비
        int[] inTime = new int[book_time.length];
        int[] outTime = new int[book_time.length];
        int inIdx = 0, outIdx = 0;
        int answer = 0, currentRoom = 0;

        // 입실, 퇴실 시간 나눠 담기
        for (int i=0; i<book_time.length; i++) {
            int[] arr = getTime(book_time[i]);
            inTime[i] = arr[0];
            outTime[i] = arr[1]+10; // 청소시간 포함
        }

        // 오름차순 정렬
        Arrays.sort(inTime);
        Arrays.sort(outTime);

        // 입실, 퇴실 기준으로 현재 필요한 방 갯수 구하기
        while (inIdx < book_time.length) {
            if (inTime[inIdx] < outTime[outIdx]) {
                inIdx++;
                currentRoom++;
                answer = Math.max(currentRoom, answer);
            } else {
                currentRoom--;
                outIdx++;
            }
        }

        // 리턴
        return answer;
    }

    int[] getTime(String[] str) { // 시간 변환 메소드
        int[] result = new int[2];
        for (int i=0; i<2; i++) {
            String[] arr = str[i].split(":");
            int hour = Integer.parseInt(arr[0]);
            int minute = Integer.parseInt(arr[1]);
            result[i] = hour*60+minute;
        }
        return result;
    }
}
