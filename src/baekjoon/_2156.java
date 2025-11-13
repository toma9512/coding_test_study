package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        int[] wine = new int[n+1];
        int[][] dp = new int[n+1][4]; // 둘다, 이전만, 전전만, 안마심
        // 1 0 1 0
        // 1 1 0 0

        for (int i=1; i<=n; i++) {
            wine[i] = scanner.nextInt();
            scanner.nextLine();
        }
        dp[1][0] = wine[1];
        dp[1][1] = wine[1];

        for (int i=1; i<n; i++) {
            dp[i+1][0] = wine[i+1] + dp[i][1];
            dp[i+1][1] = wine[i+1] + Math.max(dp[i][2], dp[i][3]);
            dp[i+1][2] = Math.max(dp[i][0], dp[i][1]);
            dp[i+1][3] = Math.max(dp[i][2], dp[i][3]);
        }

        int result = 0;
        for (int i=0; i<4; i++) result = Math.max(dp[n][i],result);
        System.out.println(result);
    }
}
