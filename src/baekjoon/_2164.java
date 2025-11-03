package baekjoon;

import java.util.*;

public class _2164 {
    public static void main(String[] args) {
        // 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        // 1~N까지 채워넣기
        for (int i=0; i<N; i++) {
            queue.add(i+1);
        }

        // 반복
        while (queue.size()>1) {
            queue.poll();
            queue.add(queue.poll());
        }

        // 출력
        System.out.println(queue.peek());
    }
}
