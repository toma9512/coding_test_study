package Lv_2;

/*
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */

public class Ex058 {
    public String solution(String number, int k) {
        // 데이터 준비
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        int idx = 0; // 최댓값 다음 인덱스 위치를 저장할 변수

        for (int i=0; i<arr.length-k; i++) {
            char max = 0;

            for (int j=idx; j<=i+k; j++) { // 이전의 최댓값 다음부터
                if (max<arr[j]) {
                    max = arr[j];
                    idx = j+1;
                }
                if (max=='9') break;
            }

            sb.append(""+max);
        }

        // 리턴
        return sb.toString();
    }
}
