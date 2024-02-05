public class FindPeakInMountain {
    public static void main(String[] args) {
        // int[] mountainArr = {1,2,3,4,5,3,1}; 
        // int[] mountainArr = {0,1,2,4,2,1}; 
        int[] mountainArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82}; 
        int target = 101; 
        int indexOfTarget = findInMountainArray(target, mountainArr);
        System.out.println(indexOfTarget);
    }
    public static int findInMountainArray(int target, int[] mountainArr){
        int peak = findPeak(mountainArr); 
        System.out.println("Peak element" + peak);
        if(mountainArr[peak] == target){
            return peak; 
        }
        int findInFirstPortion = binarySearch(target, mountainArr, peak); 
        System.out.println("Firt pos: " + findInFirstPortion);
        if(findInFirstPortion != -1){
            return findInFirstPortion; 
        }
        int findInSecondPortion = revBinarySearch(target, mountainArr, peak); 
        System.out.println("Second position: " + findInSecondPortion);
        return findInSecondPortion; 
    }
    private static int binarySearch(int target, int[] mountainArr, int peak){
        int l = 0; 
        int h = peak; 
        while(l <= h){
            int mid = (int)(l+h)/2; 
            if(mountainArr[mid] == target){
                return mid; 
            }
            if(target < mountainArr[mid]){
                h = mid - 1; 
            }else{
                l = mid + 1; 
            }
        }
        return -1; 
    }
    private static int revBinarySearch(int target, int[] mountainArr, int peak){
        int l = peak; 
        int h = mountainArr.length-1; 
        while(h >= l){
            int mid = (int)(l+h)/2; 
            if(mountainArr[mid] == target){
                return mid; 
            }
            if(target < mountainArr[mid]){
                l = mid + 1; 
            }else{
                h = mid - 1; 
            }
        }
        return -1; 
    }
    private static int findPeak(int[] mountainArr){
        int l = 0; 
        int h = mountainArr.length-1;
        while(l < h){
            int mid = (int)(l+h)/2; 
            //we are in increasing portion
            if(mountainArr[mid] < mountainArr[mid+1]){
                l = mid+1; 
            }else{
                h = mid; 
            }
        }
        return l; 
    }

}
