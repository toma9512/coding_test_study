package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;
        // 10 20 10 15 20 40 30 40 -> 5

        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        scanner.nextLine();
        st = new StringTokenizer(scanner.nextLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        int answer = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(answer);
    }
}
