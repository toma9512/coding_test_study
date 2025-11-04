package Lv_2;

/*
문제 설명
0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다. 당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.
당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤, 각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때, 배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

제한사항
arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태를 하고 있습니다. 즉, arr의 행의 개수는 1, 2, 4, 8, ..., 1024 중 하나입니다.
arr의 각 행의 길이는 arr의 행의 개수와 같습니다. 즉, arr은 정사각형 배열입니다.
arr의 각 행에 있는 모든 값은 0 또는 1 입니다.
 */

// 재귀 함수 사용
public class Ex055 {
    // 데이터 준비
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        // 재귀
        dfs(arr, 0, 0, arr.length);

        // 리턴
        return answer;
    }

    void dfs(int[][] arr, int x, int y, int size) {
        if (isSame(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        int half = size/2;
        dfs(arr, x, y, half); // 왼쪽 위
        dfs(arr, x+half, y, half); // 왼쪽 아래
        dfs(arr, x, y+half, half); // 오른쪽 위
        dfs(arr, x+half, y+half, half); // 오른쪽 아래
    }

    // 정사각형에 같은 원소가 있는지 확인
    boolean isSame(int[][] arr, int x, int y, int size) {
        int num = arr[x][y];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (num != arr[x+i][y+j]) return false;
            }
        }
        return true;
    }
}

// 재귀 없이
// public class Ex055 {
//     public int[] solution(int[][] arr) {
//         // 데이터 준비
//         int n = arr.length;
//         int[] answer = new int[2];
//
//         if (n==1) {
//             if (arr[0][0] == 1) answer[1]++;
//             else answer[0]++;
//             return answer;
//         }
//
//         for (int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 if (arr[i][j]==0) answer[0]++;
//                 else answer[1]++;
//             }
//         }
//
//         while (n!=1) {
//             for (int i=0; i<arr.length/n; i++) {
//                 for (int j=0; j<arr.length/n; j++) {
//                     boolean check = true;
//                     int a = arr[i*n][j*n];
//                     if (a==-1) continue; // -1 이면 확인 안함
//
//                     for (int k=0; k<n; k++) {
//                         for (int l=0; l<n; l++) {
//                             if (arr[i*n+k][j*n+l]!=a) {
//                                 check = false;
//                                 break;
//                             }
//                         }
//                         if (!check) break;
//                     }
//
//                     if (check) {
//                         answer[a] -= n*n-1;
//
//                         // 합쳐진 곳은 -1로 바꾸기
//                         for (int k=0; k<n; k++) {
//                             for (int l=0; l<n; l++) {
//                                 arr[i*n+k][j*n+l] = -1;
//                             }
//                         }
//                     }
//                 }
//             }
//             n /= 2;
//         }
//
//         // 리턴
//         return answer;
//     }
// }
