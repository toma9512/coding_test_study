package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;

            if (i < K-1) {
                continue;
            }

            max = Math.max(max, sum);
            sum -= arr[i - (K - 1)];
        }

        System.out.println(max);
    }
}
