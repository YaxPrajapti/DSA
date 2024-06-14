package Stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindowOptimised(nums, k);
        System.out.println(Arrays.toString(ans));

    }
    /*
    step 1: When a new element comes, make space for that element because the deque will be of size equal to k only. Remove elements from the front.
    step 2: now pop all the elements (from the back) smaller than the current element. because we are using the deque to store the maximum of the window only. So there is no meaning to keep the smaller elements.
    step 3: Push the current element to the deque.
    step 4: If(i >= k -1), after this we will need to pop the deque and that will be the answer for the current window.
     */
    public static int[] maxSlidingWindowOptimised(int[] nums, int k){
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            //step - 1;
            while (!deque.isEmpty() && deque.getFirst() <= i - k){
                deque.removeFirst();
            }
            //step-2
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            //step 3
            deque.addLast(i);
            //step 4
            if(i >= k-1){
                list.add(nums[deque.getFirst()]);
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer: list){
            ans[i] = integer;
            i++;
        }
        return ans;
    }
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (i + k <= nums.length){
            int maxi = Integer.MIN_VALUE;
            int j = i;
            int temp = k;
            while (k != 0 && j < nums.length){
                maxi = Math.max(maxi, nums[j]);
                j++;
                k--;
            }
            list.add(maxi);
            k = temp;
            i++;
        }
        int[] ans = new int[list.size()];
        for(int j = 0; j < list.size(); j++){
            ans[j] = list.get(j);
        }
        return ans;
    }
}
