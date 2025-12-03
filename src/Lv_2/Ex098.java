package Lv_2;

/*
문제 설명
x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
※ 각 원 위의 점도 포함하여 셉니다.

제한 사항
1 ≤ r1 < r2 ≤ 1,000,000
 */

public class Ex098 {
    public long solution(int r1, int r2) {
        long answer = 0;
        long square1 = (long) r1 * r1;
        long square2 = (long) r2 * r2;

        for (int i=0; i<r2; i++) {
            long temp1 = Math.max(square1 - (long) i * i, 1);
            long temp2 = square2 - (long) i * i;

            answer += (long) Math.pow(temp2, 0.5) - (long) Math.pow(temp1-1, 0.5);
        }

        return answer*4;
    }
}
