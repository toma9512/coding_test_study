package Lv_2;

/*
문제 설명
1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다. 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
미로를 나타낸 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.

제한사항
5 ≤ maps의 길이 ≤ 100
5 ≤ maps[i]의 길이 ≤ 100
maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
S : 시작 지점
E : 출구
L : 레버
O : 통로
X : 벽
시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
 */

import java.util.*;

// 이전 bfs를 참고해서 코드 작성함
public class Ex065 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        // 데이터 준비
        int[] ds = new int[2];
        int[] dl = new int[2];
        int[] de = new int[2];
        String[][] map = new String[maps.length][maps[0].length()];
        int[][] visited = new int[maps.length][maps[0].length()];

        // 시작 지점 찾기
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    ds = new int[] {i, j};
                } else if (maps[i].charAt(j) == 'L') {
                    dl = new int[] {i, j};
                } else if (maps[i].charAt(j) == 'E') {
                    de = new int[] {i, j};
                }
            }
        }

        // 2차원 배열로 변형
        for (int i=0; i<maps.length; i++) {
            map[i] = maps[i].split("");
        }

        bfs(map, visited, dl);

        // L에서 S,E까지 이동거리
        int s = visited[ds[0]][ds[1]];
        int e = visited[de[0]][de[1]];

        // 리턴
        return s==0 || e==0 ? -1 : s+e;
    }

    void bfs(String[][] map, int[][] visited, int[] dl) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(dl); // L에서 시작

        while (!queue.isEmpty()) {
            // 시작할 위치 저장
            int[] current = queue.poll();
            int nx = current[0];
            int ny = current[1];

            // 상하좌우 반복
            for (int i=0; i<4; i++) {
                int x = nx + dx[i];
                int y = ny + dy[i];

                // 유효성 검사
                if (x<0 || y<0 || x>=map.length || y>=map[0].length) continue;

                // 방문한적 없고, 벽에 가로막히지 않았을 때
                if (visited[x][y] == 0 && !map[x][y].equals("X")) {
                    // 가능한 위치 queue에 저장
                    queue.add(new int[] {x, y});
                    // 이동거리 표시
                    visited[x][y] = visited[nx][ny] + 1;
                }
            }
        }
    }
}

// dfs는 시간초과
// public class Ex065 {
//     int e = Integer.MAX_VALUE;
//     int l = Integer.MAX_VALUE;
//     int[] dx = {-1, 1, 0, 0};
//     int[] dy = {0, 0, -1, 1};
//
//     public int solution(String[] maps) {
//         // 데이터 준비
//         int x = 0, lx = 0;
//         int y = 0, ly = 0;
//         String[][] map = new String[maps.length][maps[0].length()];
//         String[][] copyMap = new String[maps.length][maps[0].length()];
//
//         // 시작 지점 찾기
//         for (int i=0; i<maps.length; i++) {
//             for (int j=0; j<maps[i].length(); j++) {
//                 if (maps[i].charAt(j) == 'S') {
//                     x = i;
//                     y = j;
//                 } else if (maps[i].charAt(j) == 'L') {
//                     lx = i;
//                     ly = j;
//                 }
//             }
//         }
//
//         // 2차원 배열로 변형
//         for (int i=0; i<maps.length; i++) {
//             map[i] = maps[i].split("");
//             copyMap[i] = maps[i].split("");
//         }
//
//         dfsL(map, x, y, 0);
//         dfsE(copyMap, lx, ly, 0);
//
//         // 리턴
//         return (l==Integer.MAX_VALUE || e==Integer.MAX_VALUE) ? -1 : l+e;
//     }
//
//     // L 찾기
//     void dfsL(String[][] map, int x, int y, int count) {
//         // 유효성 검사
//         if (x<0 || x>=map.length || y<0 || y>=map[0].length ||
//                 map[x][y].equals("X")) return;
//
//
//         // 종료 지점
//         if (map[x][y].equals("L")) {
//             l = Math.min(count, l);
//             return;
//         }
//
//         map[x][y] = "X"; // 방문 체크
//
//         // 상하좌우 이동
//         dfsL(map, x+dx[0], y+dy[0], count+1);
//         dfsL(map, x+dx[1], y+dy[1], count+1);
//         dfsL(map, x+dx[2], y+dy[2], count+1);
//         dfsL(map, x+dx[3], y+dy[3], count+1);
//
//         map[x][y] = "O"; // 방문 해제
//     }
//
//     // E 찾기
//     void dfsE(String[][] map, int x, int y, int count) {
//         // 유효성 검사
//         if (x<0 || x>=map.length || y<0 || y>=map[0].length ||
//                 map[x][y].equals("X")) return;
//
//
//         // 종료 지점
//         if (map[x][y].equals("E")) {
//             e = Math.min(count, e);
//             return;
//         }
//
//         map[x][y] = "X"; // 방문 체크
//
//         // 상하좌우 이동
//         dfsE(map, x+dx[0], y+dy[0], count+1);
//         dfsE(map, x+dx[1], y+dy[1], count+1);
//         dfsE(map, x+dx[2], y+dy[2], count+1);
//         dfsE(map, x+dx[3], y+dy[3], count+1);
//
//         map[x][y] = "O"; // 방문 해제
//     }
// }
