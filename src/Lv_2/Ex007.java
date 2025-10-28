package Lv_2;

/*
문제 설명
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

제한 사항
n은 1,000,000 이하의 자연수 입니다.
 */

public class Ex007 {
    public int solution(int n) {
        // 데이터 준비
        int answer = n+1;
        int count = 0;
        String nBinary = Integer.toString(n,2);
        for (int i=0; i<nBinary.length(); i++) {
            if (nBinary.charAt(i)=='1') count++;
        }

        // 찾기
        while (true) {
            // 데이터 초기화
            String tempBinary = Integer.toString(answer, 2);
            int temp = 0;

            // 1의 개수 세기
            for (int i=0; i<tempBinary.length(); i++) {
                if (tempBinary.charAt(i)=='1') temp++;
            }

            // 확인
            if (temp == count) break;
            answer++;
        }

        // 리턴
        return answer;
    }
}
