public class MinMovesToCaptureQueen {
    public static void main(String[] args) {
        System.out.println(minMovesToCaptureTheQueen(1,1, 8, 8, 2, 3)); // 2
        System.out.println(minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2)); // 1
        System.out.println(minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2)); // 2
        System.out.println(minMovesToCaptureTheQueen(8, 4, 7, 5, 5, 5)); // 2 
        System.out.println(minMovesToCaptureTheQueen(8, 4, 8, 8, 7, 7)); // 1 
        System.out.println(minMovesToCaptureTheQueen(4, 3, 3, 1, 6, 4)); // 1 
        System.out.println(minMovesToCaptureTheQueen(2, 3, 1, 6, 6, 1)); // 1
    }
    public static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f){
        //check if rook can capture; 
            //if rows are same 
        if(a == e){
            //if bishop is in between rook and queen in same row; 
            if(a == c && ((d > b && d < f) || (d < b && d > f))){
                return 2; 
            }
            return 1; 
        }
            //if cols are same 
        if(b == f){
            if(b == d && ((c > a && c  < e) || (c < a && c > e))){
                return 2; 
            }else{
                return 1; 
            }
        }
        //check if bishop can capture; 
        if(((c+d) == (e+f))){
            //if rook is in between; 
            if((a+b == c+d) && ((a > e && a < c) || (a < e && (a > c))) && ((b > f && b < d) || (b < f && b > d))){
                return 2; 
            }else{
                return 1; 
            }
        }
        else if((c-d) == (e-f)){
            if((a-b == c-d) && (((a > e && a < c) || (a < e && (a > c))) && ((b > f && b < d) || (b < f && b > d)))){
                return 2; 
            }else{
                return 1; 
            }
        }
        return 2; 
    }
}
