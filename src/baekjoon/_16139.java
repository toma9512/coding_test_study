package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class _16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        char[] word = S.toCharArray();

        int[][] arr = new int[26][S.length() + 1];

        boolean[] check = new boolean[26];

        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int target = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (!check[target]) {
                for (int j=1; j<=S.length(); j++) {
                    int temp = (char) (target + 'a') == word[j-1] ? 1 : 0;
                    arr[target][j] = temp + arr[target][j-1];
                }
                check[target] = true;
            }

            bw.write(arr[target][r+1] - arr[target][l] + "\n");
        }

        bw.close();
    }
}


/*
1. 26xN 배열을 전부 다 채움 -> 요청 들어오면 들어온 요청만 배열 채우기(이미 채웠다면 통과)
2. 매 질문마다 System.out.println()을 사용하는 문제 -> BufferedWriter로 대체하여 한 번에 출력하도록 함
 */