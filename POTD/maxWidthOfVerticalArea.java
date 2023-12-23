package POTD;

import java.util.Arrays;

public class maxWidthOfVerticalArea {
    public static void main(String[] args) {
        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        int maxarea = maxWidthOfVerticalArea(points);
        System.out.println(maxarea);
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int[] xnodes = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xnodes[i] = points[i][0];
        }
        Arrays.sort(xnodes);
        int maxDistance = 0;
        for (int i = xnodes.length - 1; i >= 1; i--) {
            maxDistance = Math.max(maxDistance, xnodes[i] - xnodes[i - 1]);
        }
        return maxDistance; 
    }
}
