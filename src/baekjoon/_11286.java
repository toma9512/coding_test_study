package baekjoon;

import java.util.*;
import java.io.*;

public class _11286 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if (num1 == num2) {
                return o1 > o2 ? 1 : -1;
            }
            return num1 - num2;
        });

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pQ.add(num);
            } else { // 0일 때 (출력)
                if (!pQ.isEmpty()) {
                    System.out.println(pQ.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
