import java.util.Arrays;

public class FullBloomFlowers {
    public static void main(String[] args) {
        // int[][] flowers = {{1,6}, {3,7}, {9,12}, {4,13}}; 
        int[][] flowers = {{1,10},{3,3}}; 
        int[] people = {3,3,2};
        // int[] people = {2,3,7,11}; 
        int[] answer = fullBloomFlowers(flowers, people);
        for(int i : answer){
            System.out.print(i + " ");
        }

    }
    public static int[] fullBloomFlowers(int[][] flowers, int[] people){
        int[] answer = new int[people.length]; 
        int[] start = new int[flowers.length]; 
        int[] end = new int[flowers.length]; 

        for(int i = 0; i < flowers.length; i++){
            start[i] = flowers[i][0]; 
            end[i] = flowers[i][1]; 
        }
        Arrays.sort(start);
        Arrays.sort(end);

        /*
         * upper bound: smallest possible index for arr[index] > n; 
         * lower bound: smallest possible index for arr[index] >= n; 
         */
        for(int i = 0; i < people.length; i++){
            int peopleArrivalTime = people[i]; 
            int started = upperBound(start, peopleArrivalTime); 
            int ended = lowerBound(end, peopleArrivalTime); 
            answer[i] = started-ended; 
        }
        return answer; 
    }
    private static int upperBound(int[] arr, int target){
        int l = 0; 
        int h = arr.length-1;
        int ans = arr.length; 
        while(l <= h){
            int mid = (int)(l+h)/2;
            if(target < arr[mid]){
                ans = mid; 
                h = mid-1; 
            }else{
                l = mid + 1; 
            }
        }
        return ans; 
    }
    private static int lowerBound(int[] arr, int target){
        int l = 0; 
        int h = arr.length-1;
        int ans = arr.length; 
        while(l <= h){
            int mid = (int)(l+h)/2;
            if(target <= arr[mid]){
                ans = mid; 
                h = mid-1; 
            }else{
                l = mid + 1; 
            }
        }
        return ans; 
    }
}
