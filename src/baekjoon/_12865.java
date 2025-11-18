package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        int[][] arr = new int[N][2]; // 무게, 가치

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 무게 오름차순
        Arrays.sort(arr, ((o1, o2) -> o1[0] - o2[0]));

        System.out.println(Arrays.deepToString(arr));
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - arr[i-1][0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - arr[i-1][0]] + arr[i-1][1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[N][K]);
    }
}
