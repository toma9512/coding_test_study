import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        pq.add(3);
        pq.add(1);
        pq.add(4);
        System.out.println(pq);
    }
}



