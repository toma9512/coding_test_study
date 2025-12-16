package Lv_2;

/*
문제 설명
Ax + By + C = 0으로 표현할 수 있는 n개의 직선이 주어질 때, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
직선 A, B, C에 대한 정보가 담긴 배열 line이 매개변수로 주어집니다. 이때 모든 별을 포함하는 최소 사각형을 return 하도록 solution 함수를 완성해주세요.

제한사항
line의 세로(행) 길이는 2 이상 1,000 이하인 자연수입니다.
line의 가로(열) 길이는 3입니다.
line의 각 원소는 [A, B, C] 형태입니다.
A, B, C는 -100,000 이상 100,000 이하인 정수입니다.
무수히 많은 교점이 생기는 직선 쌍은 주어지지 않습니다.
A = 0이면서 B = 0인 경우는 주어지지 않습니다.
정답은 1,000 * 1,000 크기 이내에서 표현됩니다.
별이 한 개 이상 그려지는 입력만 주어집니다.
 */

import java.util.*;

public class Ex106 {
    Set<String> set;
    int nx = Integer.MAX_VALUE, ny = Integer.MAX_VALUE;
    int mx = -Integer.MAX_VALUE, my = -Integer.MAX_VALUE;
    String[] answer;

    public String[] solution(int[][] line) {
        set = new HashSet<>();

        dfs(line, 0, new ArrayList<>());

        int colLen = mx - nx + 1;
        int rowLen = my - ny + 1;

        String[][] temp = new String[rowLen][colLen];
        for (int i=0; i<rowLen; i++) {
            Arrays.fill(temp[i], ".");
        }


        for (String s : set) {
            String[] arr = s.split(",");
            int y = -Integer.parseInt(arr[0]) + my;
            int x = Integer.parseInt(arr[1]) - nx;
            temp[y][x] = "*";
        }

        answer = new String[rowLen];
        for (int i=0; i<rowLen; i++) {
            answer[i] = String.join("", temp[i]);
        }

        return answer;
    }

    void dfs(int[][] line, int index, List<int[]> list) {
        if (list.size()==2) {
            long a = list.get(0)[0], b = list.get(0)[1], c = list.get(0)[2];
            long d = list.get(1)[0], e = list.get(1)[1], f = list.get(1)[2];
            if (a*e - b*d == 0 || b*d - a*e == 0) return;
            boolean check1 = (c*e - b*f) % (a*e - b*d) == 0;
            boolean check2 = (c*d - a*f) % (b*d - a*e) == 0;

            if (check1 && check2) {
                int x = (int) ((-c*e + b*f) / (a*e - b*d));
                int y = (int) ((-c*d + a*f) / (b*d - a*e));
                set.add(y + "," + x);
                nx = Math.min(x, nx);
                ny = Math.min(y, ny);
                mx = Math.max(x, mx);
                my = Math.max(y, my);
            }

            return;
        }

        for (int i=index; i<line.length; i++) {
            List<int[]> copy = new ArrayList<>(list);
            copy.add(line[i]);

            dfs(line, i+1, copy);
        }
    }
}
