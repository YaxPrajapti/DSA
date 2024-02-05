package BinarySearch;

public class DaysToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3; 
        int k = 1; 
        int minDays = minDays(bloomDay, m, k); 
        System.out.println(minDays);
    }
    public static int minDays(int bloomDay[], int m, int k){
        if((long)m*k > bloomDay.length){
            return -1; 
        }
        int mini = Integer.MAX_VALUE; 
        int maxi = Integer.MIN_VALUE; 
        for(int i : bloomDay){
            mini = Math.min(mini, i); 
            maxi = Math.max(maxi, i); 
        }
        int l = mini; 
        int h = maxi; 
        while(l <= h){
            int mid = (int)(l + h)/2; 
            boolean possible = possible(bloomDay, m, k, mid); 
            if(possible){
                h = mid - 1; 
            }else{
                l = mid + 1; 
            }
        }
        return l; 
    }
    public static boolean possible(int[] bloomDay, int m, int k, int mid){
        int n = bloomDay.length; 
        int bouquets = 0; 
        int count = 0; 
        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= mid){
                count++; 
            }else{
                bouquets += (count/k); 
                count=0; 
            }
        }
        bouquets += count/k; 
        return bouquets>=m; 
    }
    // public static int minDays(int[] bloomDay, int m, int k){
    //     int n = bloomDay.length;
    //     if((long)m*k > n){
    //         return -1;  
    //     }
    //     int maxi = Integer.MIN_VALUE; 
    //     int mini = Integer.MAX_VALUE;
    //     for(int i : bloomDay){
    //         maxi = Math.max(maxi, i); 
    //         mini = Math.min(mini, i); 
    //     }
    //     int l = mini;
    //     int h = maxi; 
    //     int minDays = maxi; 
    //     while(l <= h){
    //         int[] flowers = new int[n]; 
    //         int bouque = 0; 
    //         int mid = (int)(l+h)/2;
    //         for(int i = 0; i < n; i++){
    //             if(bloomDay[i] <= mid){
    //                 flowers[i] = 1; 
    //             }
    //         }
    //         int windowSize = 0; 
    //         int index = 0; 
    //         while(index < flowers.length){
    //             if(flowers[index] == 1){
    //                 windowSize+=1; 
    //             } else{
    //                 windowSize=0; 
    //             }
    //             if(windowSize == k){
    //                 bouque+=1; 
    //                 index++; 
    //                 windowSize=0; 
    //                 continue;
    //             }
    //             index++;
    //         }   
    //         if(bouque >= m){
    //             h = mid-1; 
    //             minDays = Math.min(minDays, mid);
    //         }
    //         else{
    //             l = mid + 1; 
    //         }
    //     }
    //     return minDays;  
    // }
    
}
