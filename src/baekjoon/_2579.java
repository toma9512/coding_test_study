package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];
        int[] stair = new int[N];
        for (int i=0; i<N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = stair[0];

        if (N > 1) {
            dp[1][0] = stair[0] + stair[1];
            dp[1][1] = stair[1];
        }

        if (N>2) {
            for (int i = 2; i < N; i++) {
                dp[i][0] = stair[i] + dp[i - 1][1];
                dp[i][1] = stair[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
            }
        }

        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}
