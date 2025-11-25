package Lv_2;

/*
문제 설명
A 회사의 물류창고에는 알파벳 대문자로 종류를 구분하는 컨테이너가 세로로 n 줄, 가로로 m줄 총 n x m개 놓여 있습니다. 특정 종류 컨테이너의 출고 요청이 들어올 때마다 지게차로 창고에서 접근이 가능한 해당 종류의 컨테이너를 모두 꺼냅니다. 접근이 가능한 컨테이너란 4면 중 적어도 1면이 창고 외부와 연결된 컨테이너를 말합니다.
최근 이 물류 창고에서 창고 외부와 연결되지 않은 컨테이너도 꺼낼 수 있도록 크레인을 도입했습니다. 크레인을 사용하면 요청된 종류의 모든 컨테이너를 꺼냅니다.
위 그림처럼 세로로 4줄, 가로로 5줄이 놓인 창고를 예로 들어보겠습니다. 이때 "A", "BB", "A" 순서대로 해당 종류의 컨테이너 출고 요청이 들어왔다고 가정하겠습니다. “A”처럼 알파벳 하나로만 출고 요청이 들어올 경우 지게차를 사용해 출고 요청이 들어온 순간 접근 가능한 컨테이너를 꺼냅니다. "BB"처럼 같은 알파벳이 두 번 반복된 경우는 크레인을 사용해 요청된 종류의 모든 컨테이너를 꺼냅니다.
위 그림처럼 컨테이너가 꺼내져 3번의 출고 요청 이후 남은 컨테이너는 11개입니다. 두 번째 요청은 크레인을 활용해 모든 B 컨테이너를 꺼냈음을 유의해 주세요. 세 번째 요청이 들어왔을 때 2행 2열의 A 컨테이너만 접근이 가능하고 2행 3열의 A 컨테이너는 접근이 불가능했음을 유의해 주세요.
처음 물류창고에 놓인 컨테이너의 정보를 담은 1차원 문자열 배열 storage와 출고할 컨테이너의 종류와 출고방법을 요청 순서대로 담은 1차원 문자열 배열 requests가 매개변수로 주어집니다. 이때 모든 요청을 순서대로 완료한 후 남은 컨테이너의 수를 return 하도록 solution 함수를 완성해 주세요.

제한사항
2 ≤ storage의 길이 = n ≤ 50
2 ≤ storage[i]의 길이 = m ≤ 50
storage[i][j]는 위에서 부터 i + 1번째 행 j + 1번째 열에 놓인 컨테이너의 종류를 의미합니다.
storage[i][j]는 알파벳 대문자입니다.
1 ≤ requests의 길이 ≤ 100
1 ≤ requests[i]의 길이 ≤ 2
requests[i]는 한 종류의 알파벳 대문자로 구성된 문자열입니다.
requests[i]의 길이가 1이면 지게차를 이용한 출고 요청을, 2이면 크레인을 이용한 출고 요청을 의미합니다.
 */

import java.util.*;

public class Ex090 {
    int answer = 0;
    int[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length, m = storage[0].length();
        answer = n * m;
        String[][] arr = new String[n][m];
        for (int i=0; i<n; i++) {
            arr[i] = storage[i].split("");
        }

        for (String request : requests) {
            if (request.length() > 1) {
                for (int i=0; i<arr.length; i++) {
                    for (int j=0; j<arr[i].length; j++) {
                        if (arr[i][j].equals(request.substring(1))) {
                            arr[i][j] = ".";
                            answer--;
                        }
                    }
                }
            } else {
                visited = new int[n][m];
                for (int i=0; i<n-1; i++) {
                    int x = i;
                    int y = 0;
                    if (arr[x][y].equals(request)) {
                        answer--;
                        arr[x][y] = ".";
                    } else if (arr[x][y].equals(".")) {
                        bfs(arr, x, y, request);
                    }

                    x = n-1-i;
                    y = m-1;
                    if (arr[x][y].equals(request)) {
                        answer--;
                        arr[x][y] = ".";
                    } else if (arr[x][y].equals(".")) {
                        bfs(arr, x, y, request);
                    }
                }
                for (int i=0; i<arr[0].length-1; i++) {
                    int x = 0;
                    int y = m-1-i;
                    if (arr[x][y].equals(request)) {
                        answer--;
                        arr[x][y] = ".";
                    } else if (arr[x][y].equals(".")) {
                        bfs(arr, x, y, request);
                    }

                    x = n-1;
                    y = i;
                    if (arr[x][y].equals(request)) {
                        answer--;
                        arr[x][y] = ".";
                    } else if (arr[x][y].equals(".")) {
                        bfs(arr, x, y, request);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(visited));
        // System.out.println(Arrays.deepToString(arr));

        return answer;
    }

    void bfs(String[][] arr, int x, int y, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx<=0 || ny<=0 || nx>=arr.length-1 || ny>=arr[0].length-1) continue;

                if (arr[nx][ny].equals(".")) {
                    if (visited[nx][ny] == 0) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = visited[cx][cy] + 1;
                    }
                    continue;
                }

                if (arr[nx][ny].equals(target)) {
                    answer--;
                    arr[nx][ny] = ".";
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
    }
}
