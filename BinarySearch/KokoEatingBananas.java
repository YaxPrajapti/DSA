package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20}; 
        int h = 6; 
        int minSpeed = minEatingSpeed(piles, h); 
        System.out.println(minSpeed);
    }
    public static int minEatingSpeed(int[] piles, int h){
        int low = 1; 
        int high = maxspeed(piles); 
        while(low <= high){
            int speed = (int)(low + high)/2; 
            int totalHoursToEat = totalHoursToEat(piles,speed); 
            if(totalHoursToEat <= h){
                high = speed - 1; 
            }else{
                low = speed + 1; 
            }
        }
        return low; 
    }
    public static int totalHoursToEat(int[] piles, int speed){
        int totalHours = 0; 
        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i]/(double)speed); 
        }
        return totalHours; 
    }
    /* 
    public static int minEatingSpeed(int[] piles, int h){
        int maxSpeed = maxspeed(piles); 
        int low = 1; 
        int high = maxSpeed; 
        int minSpeed = maxSpeed; 
        while(low <= high){
            int speed = (int)(low+high)/2; 
            int pile = 0;
            int hour = 0;
            int bananas = 0; 
            while (pile < piles.length) {
                bananas = piles[pile];
                // if(bananas > 0){
                // bananas = bananas - speed;
                // }
                while (bananas > 0) {
                    bananas = bananas - speed;
                    hour++;
                }
                if (bananas <= 0) {
                    pile=pile+1;
                }
            }
            if (hour <= h && bananas <= 0) {
                minSpeed = Math.min(minSpeed, speed);
                high = speed-1;  
            }else{
                low = speed+1; 
            }
        }
        return minSpeed; 
    }
    */
    private static int maxspeed(int[] arr){
        int max = 0; 
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max; 
    }
}
