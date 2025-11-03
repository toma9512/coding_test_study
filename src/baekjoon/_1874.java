package baekjoon;

import java.util.*;
import java.io.*;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            // 입력 받은 num과 같아질 때까지 stack에 추가
            while (stack.isEmpty() || stack.peek() < num) {
                stack.push(count++);
                result.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            } else { // 안될 때
                result.setLength(0);
                result.append("NO");
                break;
            }
        }

        // 출력
        System.out.println(result);
    }
}
