package Lv_2;

/*
문제 설명
양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.
x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
예를 들어,
f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
수	비트	다른 비트의 개수
2	000...0010
3	000...0011	1
f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
수	비트	다른 비트의 개수
7	000...0111
8	000...1000	4
9	000...1001	3
10	000...1010	3
11	000...1011	2
정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 100,000
0 ≤ numbers의 모든 수 ≤ 1015

 */

public class Ex052 {
    public long[] solution(long[] numbers) {
        // 데이터 준비
        long[] answer = new long[numbers.length];

        // 찾기
        for (int n=0; n<numbers.length; n++) {
            if (numbers[n]%2 == 0) { // 짝수일 때
                answer[n] = numbers[n]+1;
                continue;
            }

            // 홀수일 때
            String target = Long.toString(numbers[n], 2); // 이진법
            long temp = numbers[n]+1; // 증가시킬 수
            String bit = Long.toString(temp, 2); // 이진법
            if (target.length()!=bit.length()) { // 길이 변화가 있을 때
                bit = "10"+target.substring(1);
                answer[n] = Long.parseLong(bit, 2);
            } else {
                int index = target.lastIndexOf("0");
                String word = target.substring(0,index) +
                        "10" + target.substring(index+2);
                answer[n] = Long.parseLong(word, 2);
            }
        }

        // 리턴
        return answer;
    }
}
