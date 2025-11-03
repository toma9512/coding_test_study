import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,5,1,7,9,6,4,8,3};

        for (int i=0; i<arr.length-1; i++) {
            boolean check = true;
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    check = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (check) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}

