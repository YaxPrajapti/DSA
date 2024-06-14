package BinarySearch;

import Arrays.sort2DArray;

public class BookAllocation {
    public static void main(String[] args) {
        // int[] books = {13,31,37,45,46,54,55,63,73,84,85 }; 
        int[] books = {12,34,67,90}; 
        int m = 5; 
        int n = books.length; 
        int pages = findPages(books, n, m); 
        System.out.println(pages);
    }
    public static int findPages(int[] books, int n, int m){
        if(m > n){
            return -1; 
        }
        int mini = Integer.MIN_VALUE; 
        int maxPages = 0; 
        for(int i : books){
            mini = Math.max(mini, i); 
            maxPages += i; 
        }
        int l = mini; 
        int h = maxPages; 
        while(l <= h){
            int mid = (int)(l+h)/2;
            if(possible(books, n, m, mid)){
                h = mid - 1; 
            }
            else{
                l = mid + 1; 
            }
        }
        return l; 
    }
    private static boolean possible(int[] books, int n, int m, int pages){
        int student = 1; 
        int pageAllocated = 0; 
        for(int i = 0; i < n; i++){
            pageAllocated+=books[i]; 
            if(pageAllocated > pages){
                student++; 
                pageAllocated = books[i]; 
            }
        }
        return (student > m) ? false : true; 
    }
}
