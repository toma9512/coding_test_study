package Lv_2;

/*
문제 설명
비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
부분 수열의 합은 k입니다.
합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.

제한사항
5 ≤ sequence의 길이 ≤ 1,000,000
1 ≤ sequence의 원소 ≤ 1,000
sequence는 비내림차순으로 정렬되어 있습니다.
5 ≤ k ≤ 1,000,000,000
k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.
 */

public class Ex060 {
    public int[] solution(int[] sequence, int k) {
        // 데이터 준비
        int i = 0;
        int j = 0;
        int[] answer = new int[2];
        answer[1] = 1000001;
        int sum = sequence[0];

        // 투 포인터
        while (j<sequence.length) {
            if (sum < k) {
                if (j+1 == sequence.length) break;
                j++;
                sum += sequence[j];
            }
            else if (sum > k) sum -= sequence[i++];
            else if (sum == k) {
                if (answer[1]-answer[0]>j-i) {
                    answer[0] = i;
                    answer[1] = j;
                }
                if (j+1 == sequence.length) break;
                j++;
                sum += sequence[j];
                sum -= sequence[i++];
            }
        }

        return answer;
    }
}
