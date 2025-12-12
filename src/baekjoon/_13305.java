package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine()); // 거리
        StringTokenizer st2 = new StringTokenizer(br.readLine()); // 리터당 가격
        long price = 0;
        long temp = Integer.MAX_VALUE;

        for (int i=0; i<n-1; i++) {
            long distance = Long.parseLong(st1.nextToken());
            long liter = Long.parseLong(st2.nextToken());

            if (temp > liter) {
                temp = liter;
            }

            price += distance * temp;
        }

        System.out.println(price);
    }
}
