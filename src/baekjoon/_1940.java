package baekjoon;

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class _1940 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 투 포인터
        int i = 0;
        int j = N-1;

        while (i<j) {
            if (arr[i]+arr[j]<M) i++;
            else if (arr[i]+arr[j]>M) j--;
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }
}
