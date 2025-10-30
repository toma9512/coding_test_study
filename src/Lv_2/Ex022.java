package Lv_2;

/*
문제 설명
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다.
 */

public class Ex022 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 데이터 준비
        int n = arr1.length;
        int m = arr1[0].length;
        int l = arr2[0].length;
        int[][] answer = new int[n][l];

        // 곱 구하기
        for (int i=0; i<n; i++) {
            for (int j=0; j<l; j++) {
                for (int k=0; k<m; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        // 리턴
        return answer;
    }
}
