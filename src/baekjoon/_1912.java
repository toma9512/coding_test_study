package baekjoon;

import java.util.*;

public class _1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;
        int N = Integer.parseInt(scanner.nextLine());
        st = new StringTokenizer(scanner.nextLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp -> 새로 시작 or 누적 합
        dp[0] = arr[0];
        int answer = dp[0];
        for (int i=1; i<N; i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
