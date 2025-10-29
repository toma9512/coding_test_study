import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
    }
}




// class Solution {
//     public int solution(int k, int[] tangerine) {
//         // 데이터 준비
//         int[] arr = new int[10000001];
//
//         // 숫자별로 갯수 세기
//         for (int i=0; i<tangerine.length; i++) {
//             arr[tangerine[i]]++;
//         }
//
//         // 정렬
//         Arrays.sort(arr);
//
//         // 최소 갯수 구하기
//         int num = 0;
//         int count = 0;
//         for (int i=arr.length-1; i>=0; i--) {
//             num += arr[i];
//             count++;
//             if (num>=k) break;
//         }
//
//         // 리턴
//         return count;
//     }
// }

class Solution {
    public int solution(int k, int[] tangerine) {
        // 데이터 준비
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for (Integer key : list) {
            k -= map.get(key);
            answer++;
            if (k<=0) break;
        }

        // 리턴
        return answer;
    }
}