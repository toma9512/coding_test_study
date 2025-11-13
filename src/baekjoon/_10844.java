package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n+1][10];
        int result = 0;

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i=2; i<=n; i++) {
            dp[i][0] = dp[i-1][1];
            for (int j=1; j<9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
            dp[i][9] = dp[i-1][8];
        }


        for (int i=0; i<10; i++) {
            result += dp[n][i];
            result %= 1000000000;
        }

        System.out.println(result);
    }
}
