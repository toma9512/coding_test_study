package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int min = 0;
            int max = n-1;
            int target = Integer.parseInt(st.nextToken());

            while (true) {
                int k = (min + max) / 2;

                if (arr[k] == target) {
                    System.out.println(1);
                    break;
                } else if (arr[k] < target) {
                    min = k+1;
                } else {
                    max = k-1;
                }

                if (min > max) {
                    System.out.println(0);
                    break;
                }
            }
        }
    }
}
