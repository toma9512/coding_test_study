package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dpRev = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        Arrays.fill(dpRev, 1);

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for (int i=n-2; i>=0; i--) {
            for (int j=n-1; j>i; j--) {
                if (arr[i] > arr[j]) {
                    dpRev[i] = Math.max(dpRev[i], dpRev[j]+1);
                }
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            answer = Math.max(dp[i]+dpRev[i]-1, answer);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dpRev));
        System.out.println(answer);
    }
}
