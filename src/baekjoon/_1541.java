package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] arr = scanner.nextLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        int temp = 0;
        List<Integer> list = new ArrayList<>();

        for (char c : arr) {
            if (c <= '9' && c >= '0') {
                sb.append(c);
            } else {
                temp += Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (c == '-') {
                    list.add(temp);
                    temp = 0;
                }
            }
        }
        list.add(temp + Integer.parseInt(sb.toString()));

        int result = list.getFirst();

        for (int i=1; i<list.size(); i++) {
            result -= list.get(i);
        }

        System.out.println(result);
    }
}
