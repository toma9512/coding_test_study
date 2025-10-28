import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.solution(23));
    }
}

class Solution {
    public int solution(int n) {
        // 종료 시점
        if (n==0) return 0;
        if (n==1) return 1;

        return (solution(n-1)+solution(n-2))%1234567;
    }
}
