package Lv_2;

/*
문제 설명
정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 1,000 이하입니다.
 */

public class Ex059 {
    public int[] solution(int n) {
        // 데이터 준비
        int[][] arr = new int[n][n];
        int[] answer = new int[n*(n+1)/2];
        int dir = 0; // 0은 아래, 1는 오른쪽, 2은 왼쪽 대각선 위로
        int x = 0, y = 0;
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};

        // 순서대로 채우기
        for (int i=1; i<=n*(n+1)/2; i++) {
            arr[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 유효성 검사
            if (nx<0 || nx>=n || ny<0 || ny>=n ||
                    arr[nx][ny] != 0) {
                dir++;
                if (dir == 3) dir = 0;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        // 리턴할 값에 담기
        int index = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 0) {
                    answer[index++] = arr[i][j];
                }
            }
        }

        // 리턴
        return answer;
    }
}
