import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"aa", "12", "C"},
                {"aa", "1", "C"},
                {"ab", "2", "c"}
        };

        Arrays.sort(arr, (o1, o2) -> {
            String word1 = o1[0].toLowerCase();
            String word2 = o2[0].toLowerCase();
            if (word1.equals(word2)) {
                int num1 = Integer.parseInt(o1[1]);
                int num2 = Integer.parseInt(o2[1]);
                return num1 > num2 ? 1 : -1;
            }
            return word1.compareTo(word2);
        });

        System.out.println(Arrays.deepToString(arr));
        System.out.println("".compareTo("2"));
    }
}



