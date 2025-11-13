package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _1149 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;

        // 입력
        int N = scanner.nextInt();
        scanner.nextLine();
        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(scanner.nextLine());
            for (int j=0; j<3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = rgb[0];

        // 각 루트별 최솟값 저장
        for (int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        // 출력
        int answer = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(answer);
    }
}
