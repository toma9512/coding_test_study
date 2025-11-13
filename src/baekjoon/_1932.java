package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            int[] temp = new int[i];
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<i; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            list.add(temp);
        }

        List<int[]> dp = new ArrayList<>();
        dp.add(list.get(0));
        for (int i=1; i<N; i++) { // i=2
            int[] oldDp = dp.get(i-1); // 10 15
            int[] temp = list.get(i); // 8 1 0

            int[] arr = new int[i+1];
            arr[0] = temp[0] + oldDp[0]; // 18
            if (i != 1) {
                for (int j=1; j<i; j++) {
                    arr[j] = temp[j] + Math.max(oldDp[j], oldDp[j-1]);
                }
            }
            arr[i] = temp[i] + oldDp[i-1];
            dp.add(arr);
        }

        int answer = 0;
        for (int num : dp.get(N-1)) {
            answer = Math.max(num, answer);
        }

        System.out.println(answer);
    }
}
