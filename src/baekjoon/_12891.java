package baekjoon;

import java.io.*;
import java.util.*;

public class _12891 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String word = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] acgt = new int[4];
        for (int i=0; i<4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;

        // 문자열 잘라서 확인하기
        int[] temp = new int[4];
        char[] chArr = word.toCharArray();
        for (int i=0; i<chArr.length; i++) {
            if (i>=P) {
                switch (chArr[i-P]) {
                    case 'A' :
                        temp[0]--;
                        break;
                    case 'C' :
                        temp[1]--;
                        break;
                    case 'G' :
                        temp[2]--;
                        break;
                    case 'T' :
                        temp[3]--;
                        break;
                }
            }
            switch (chArr[i]) {
                case 'A' :
                    temp[0]++;
                    break;
                case 'C' :
                    temp[1]++;
                    break;
                case 'G' :
                    temp[2]++;
                    break;
                case 'T' :
                    temp[3]++;
                    break;
            }

            if (i<P-1) continue;

            // 확인
            boolean check = true;
            for (int j=0; j<4; j++) {
                if (acgt[j]>temp[j]) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }
        // 출력
        System.out.println(result);
    }
}
