package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long count = 0;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] div = new int[M];
        div[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = (arr[i-1] + Integer.parseInt(st.nextToken())) % M;
            div[arr[i]]++;
        }

        for (int i=0; i<M; i++) {
            long n = div[i];
            if (n < 2) continue;

            count += n * (n - 1) / 2;
        }

        System.out.println(count);
    }
}
