package POTD;

public class NumberOfBeams {
    public static void main(String[] args) {
        // String[] banks = {"011001","000000","010100","001000"}; 
        String[] banks = {"000","111","000"};
        int num = numberOfBeams(banks); 
        System.out.println(num);
    }
    public static int numberOfBeams(String[] banks){
        int[] laserCount = new int[banks.length]; 
        for(int i = 0; i < banks.length; i++){
            String s = banks[i]; 
            for(int j = 0; j < s.length(); j++){
                char ch = s.charAt(j); 
                if(ch == '1'){
                    laserCount[i]++; 
                }
            }
        }
        int prevLaser = 0; 
        int beamCount = 0; 
        for(int i = 0; i < laserCount.length; i++){
            beamCount += (laserCount[i] * prevLaser); 
            if(laserCount[i] != 0){
                prevLaser = laserCount[i]; 
            }
        }
        return beamCount; 
    }
}
