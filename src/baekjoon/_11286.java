package baekjoon;

import java.util.*;
import java.io.*;

public class _11286 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                plus.add(num);
            } else if (num < 0) {
                minus.add(num);
            } else { // 0일 때 (출력)
                if (!minus.isEmpty() && ((plus.isEmpty())
                        || (plus.peek() + minus.peek() >= 0))) {
                    System.out.println(minus.poll());
                } else if (minus.isEmpty() && plus.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(plus.poll());
                }
            }
        }
    }
}
