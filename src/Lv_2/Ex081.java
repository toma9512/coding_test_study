package Lv_2;

/*
문제 설명
1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
예를 들어
1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 있다면 가장 큰 정사각형은
1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

제한사항
표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.
 */

public class Ex081 {
    public int solution(int[][] board) {
        int answer = 0;

        // 왼쪽, 위, 왼쪽 위 중에서 가장 작은값을 구하고 1만큼 더해주기
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i==0 || j==0) continue;

                    board[i][j] =
                            Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
                }
            }
        }

        // 최댓값 저장
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }

        // 리턴
        return answer*answer;
    }
}
