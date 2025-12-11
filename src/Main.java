import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"a","b"};
        System.out.println(Arrays.asList(arr).contains("c"));
        System.out.println("ABcAB".contains("ABC"));
        System.out.println();
        List<String> mine = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(mine);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}



