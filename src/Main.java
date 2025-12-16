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

        int[][] arr1 = new int[3][];

        arr1[0] = new int[] {1,2, 3};
        arr1[2] = new int[] {1};

        System.out.println(Arrays.deepToString(arr1));

        List<Integer> list1 = new ArrayList<>();

        int[] arr3 = list1.stream().mapToInt(Integer::intValue).toArray();
    }
}



