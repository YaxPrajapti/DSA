package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class FruitInBasket {
    public static void main(String[] args) {
//        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
//        int[] arr = {1,2,3,2,2};
//        int[] arr = {0, 1, 2, 2};
        int[] arr = {2,1,2};
        int fruits = totalFruit(arr);

        System.out.println("fruits = " + fruits);
    }

    public static int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        int start = 0;
        int end = 0;
        int len = 0;
        int n = tree.length;
        while (end < n) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            while (map.size() > 2) {
                int start_fruit = tree[start];
                map.put(start_fruit, map.get(start_fruit) - 1);
                if (map.get(start_fruit) == 0) {
                    map.remove(start_fruit);
                }
                start++;
            }

            len = Math.max(len, end - start + 1);
            end++;
        }
        return len;
    }
}
