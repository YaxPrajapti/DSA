package POTD;

import java.util.HashSet;
import java.util.Set;

public class Dec23Leetcode {
    public static void main(String[] args) {
        String path = "ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS";
        boolean isCrossing = isPathCrossing(path);
        System.out.println(isCrossing);
    }

    public static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N') {
                y++;

            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else if (ch == 'W') {
                x--;
            }
            if (set.contains(x + "," + y)) {
                return true;
            } else {
                set.add(x + "," + y);
            }
        }
        return false;
    }
}
