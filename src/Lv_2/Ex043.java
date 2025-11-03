package Lv_2;

/*
문제 설명
땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다. 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
예를 들면,
| 1 | 2 | 3 | 5 |
| 5 | 6 | 7 | 8 |
| 4 | 3 | 2 | 1 |
로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.
마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요. 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.

제한사항
행의 개수 N : 100,000 이하의 자연수
열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
점수 : 100 이하의 자연수
 */

import java.util.*;

public class Ex043 {
    int solution(int[][] land) {
        // 데이터 준비
        int[] answer = new int[4];
        for (int i=0; i<4; i++) {
            answer[i] = land[0][i];
        }

        // 각각의 경로에서 최댓값 찾기
        for (int i=1; i<land.length; i++) {
            int[] temp = new int[4];
            temp[0] =
                    Math.max(answer[1],Math.max(answer[2],answer[3])) + land[i][0];
            temp[1] =
                    Math.max(answer[0],Math.max(answer[2],answer[3])) + land[i][1];
            temp[2] =
                    Math.max(answer[0],Math.max(answer[1],answer[3])) + land[i][2];
            temp[3] =
                    Math.max(answer[0],Math.max(answer[1],answer[2])) + land[i][3];
            answer = Arrays.copyOf(temp, 4);
        }

        // 최댓값 구하기
        int max = 0;
        for (int num : answer) {
            max = Math.max(num, max);
        }

        // 리턴
        return max;
    }
}
