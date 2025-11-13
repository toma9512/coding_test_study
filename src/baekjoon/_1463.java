package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;

        if (n>3) {
            for (int i = 4; i <= n; i++) {
                int result = dp[i-1]+1;

                if (i % 3 == 0) {
                    result = Math.min(result, dp[i / 3]+1);
                }

                if (i % 2 == 0) {
                    result = Math.min(result, dp[i / 2]+1);
                }

                dp[i] = result;
            }
        }

        System.out.println(dp[n]);
    }
}
