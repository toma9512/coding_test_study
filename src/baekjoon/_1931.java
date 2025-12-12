package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {temp, Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        }));

        // System.out.println(Arrays.deepToString(arr));

        int end = 0;
        int count = 0;

        for (int i=0; i<n; i++) {
            if (end <= arr[i][0]) {
                count++;
                end = arr[i][1];
            }
        }

        System.out.println(count);
    }
}
