package POTD;

import java.util.ArrayList;
import java.util.Collections;

public class WaterThePlants {
    static class Pair implements Comparable<Pair>{
        int min; 
        int max; 
        Pair(int min, int max){
            this.min = min; 
            this.max = max; 
        }
        @Override
        public int compareTo(Pair pair){
            return Integer.compare(this.min, pair.min); 
        }
    }
    public static void main(String[] args) {
        int[] gallery = {2, 3, 4, -1, 0, 0, 0, 0, 0};
        int n = gallery.length;
        // System.out.println(n);
        int ans = min_sprinklers(gallery, n);
        System.out.println(ans);
    }
    private static int min_sprinklers(int[] gallery, int n){
        ArrayList<Pair> list = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            if(gallery[i] < 0){
                continue; 
            }
            int left = Math.max(0, i - gallery[i]);
            int right = Math.min(n-1, i + gallery[i]); 
            list.add(new Pair(left, right)); 
        }
        Collections.sort(list);
        int tap = 0; 
        int target = 0; 
        int i = 0; 
        while (target < n) {
            int maxRightIndex = -1; 
            while (i < list.size()) {
                if(list.get(i).min <= target) {
                    maxRightIndex = Math.max(maxRightIndex, list.get(i).max); 
                    i++; 
                }else{
                    break; 
                }
            }
            if(maxRightIndex < target){
                return -1; 
            }
            tap++; 
            target = maxRightIndex + 1; 
        }
        return tap; 
    }
/* 
    public static int min_sprinklers(int gallery[], int n) {
        int[] numberOfSprinklers = { Integer.MAX_VALUE };
        for (int i = 0; i < n; i++) {
            if (gallery[i] < 0) {
                continue;
            }
            int temp = i;
            int sprinkler = sprinkle(temp, numberOfSprinklers, gallery, n);
            if (sprinkler == -1) {
                continue;
            }
            numberOfSprinklers[0] = Math.min(numberOfSprinklers[0], sprinkler);
        }
        return (numberOfSprinklers[0] == Integer.MAX_VALUE) ? -1 : numberOfSprinklers[0];
    }
*/
/*
 * private static int sprinkle(int temp, int[] numberOfSprinklers, int[] gallery, int n) {
        boolean[] wet = new boolean[n];
        int count = 0;
        Arrays.fill(wet, false);
        while (temp < n) {
            int range = gallery[temp];
            if (range < 0) {
                temp++;
                continue;
            }
            int backward = temp - range; // backward index
            int forward = temp + range; // forward index
            // fill backwards
            if (backward < 0) {
                Arrays.fill(wet, 0, temp + 1, true);
            } else {
                Arrays.fill(wet, backward, temp + 1, true);
            }
            if (forward < n) {
                Arrays.fill(wet, temp, forward + 1, true); // fill forward
            } else {
                Arrays.fill(wet, temp, n, true);
            }
            count++;
            temp = forward + 1;
        }
        for (Boolean set : wet) {
            if (set == false) {
                return -1;
            }
        }
        return count;
    }
 */
}
