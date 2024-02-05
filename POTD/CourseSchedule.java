package POTD;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule {
    public static void main(String[] args) {
        int n = 2;
        int m = 1;
        int[][] preq = {{1, 0}};
        List<List<Integer>> prerequisites = Arrays.
                //Convert the 2d array into a stream.
                        stream(preq).
                //Map each 1d array (internalArray) in 2d array to a List.
                        map(
                        //Stream all the elements of each 1d array and put them into a list of Integer.
                        internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList()
                        )
                        //Put all the lists from the previous step into one big list.
                ).collect(Collectors.toList());
        int[] order = findOrder(n, m, prerequisites);
        for(Integer job : order){
            System.out.print(job + " ");
        }

    }

    public static int[] findOrder(int n, int m, List<List<Integer>> prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] ans = new int[n];
        for (int i = 0; i < m; i++) {
            int key = prerequisites.get(i).get(0);
            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                list.add(prerequisites.get(i).get(1));
                map.replace(key, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites.get(i).get(1));
                map.put(key, list);
            }
        }
        Set<Integer> completed = new HashSet<>();
        for(int i = 0; i < n; i++){

        }
        return ans;
    }

}
