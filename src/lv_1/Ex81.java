package lv_1;

/*
문제 설명
지민이는 다양한 크기의 정사각형 모양 돗자리를 가지고 공원에 소풍을 나왔습니다. 공원에는 이미 돗자리를 깔고 여가를 즐기는 사람들이 많아 지민이가 깔 수 있는 가장 큰 돗자리가 어떤 건지 확인하려 합니다. 예를 들어 지민이가 가지고 있는 돗자리의 한 변 길이가 5, 3, 2 세 종류이고, 사람들이 다음과 같이 앉아 있다면 지민이가 깔 수 있는 가장 큰 돗자리는 3x3 크기입니다.
지민이가 가진 돗자리들의 한 변의 길이들이 담긴 정수 리스트 mats, 현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트 park가 주어질 때 지민이가 깔 수 있는 가장 큰 돗자리의 한 변 길이를 return 하도록 solution 함수를 완성해 주세요. 아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.

제한사항
1 ≤ mats의 길이 ≤ 10
1 ≤ mats의 원소 ≤ 20
mats는 중복된 원소를 가지지 않습니다.
1 ≤ park의 길이 ≤ 50
1 ≤ park[i]의 길이 ≤ 50
park[i][j]의 원소는 문자열입니다.
park[i][j]에 돗자리를 깐 사람이 없다면 "-1", 사람이 있다면 알파벳 한 글자로 된 값을 갖습니다.
 */

import java.util.*;

public class Ex81 {
    public int solution(int[] mats, String[][] park) {
        // 내림차순 정렬
        Arrays.sort(mats);
        for (int i=0; i<mats.length/2; i++) {
            int temp = mats[i];
            mats[i] = mats[mats.length-1-i];
            mats[mats.length-1-i] = temp;
        }

        // 최대 매트 크기 찾기
        for (int mat : mats) {
            for (int i=0; i<park.length-mat+1; i++) {
                for (int j=0; j<park[i].length-mat+1; j++) {
                    boolean check = true;
                    if (park[i][j].equals("-1")) {
                        for (int k=0; k<mat; k++) {
                            for (int l=0; l<mat; l++) {
                                if (!park[i+k][j+l].equals("-1")) {
                                    check = false;
                                    break;
                                }
                            }
                            if (!check) break;
                        }
                    } else check = false;
                    if (check) return mat;
                }
            }
        }

        // 리턴
        return -1;
    }
}
