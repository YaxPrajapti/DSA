package POTD;

import java.util.ArrayList;
import java.util.Collections;


class Pair implements Comparable<Pair> {
    int start;
    int end;
    int index;

    Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.end, other.end);
    }
}

public class MaxMeetings {
    public static void main(String[] args) {
        // int N = 6;
        // int[] S = {1,3,0,5,8,5};
        // int[] F = {2,4,6,7,9,9};
        // int N = 1;
        // int[] S = {3};
        // int[] F = {7};
        
        int[] S = { 12 ,6 ,16 ,12 ,6 ,9 ,16 ,6 ,17 ,5, };
        int[] F = { 17, 13, 16, 18, 17, 10, 18, 12, 18, 11 };
        int N = S.length; 
        ArrayList<Integer> meetings = maxMeetings(N, S, F);
        System.out.println(meetings);
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<Pair> meetingPair = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            meetingPair.add(new Pair(S[i], F[i], i + 1));
        }
        Collections.sort(meetingPair);
        int timePassed = -1;
        for (Pair pair : meetingPair) {
            if (pair.start > timePassed) {
                timePassed = pair.end;
                ans.add(pair.index);
            }
        }
        Collections.sort(ans); 
        return ans;
    }
}
