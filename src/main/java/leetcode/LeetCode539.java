package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode539 {
    public static int findMinDifference(List<String> timePoints) {
        int midMinutes = 60 * 24;
        List<Integer> timeMinutes = new ArrayList<>();
        for (String time : timePoints) {
            String[] times = time.split(":");
            int now = (Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
            timeMinutes.add(now);
        }
        timeMinutes.sort(Comparator.comparingInt(a -> a));
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<timeMinutes.size();i++){
            int curr=timeMinutes.get((i+1)%timeMinutes.size())-timeMinutes.get(i);
            if (curr<0){
                curr+=midMinutes;
            }
            ans=Math.min(ans,curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> time=new ArrayList<>();
        time.add("00:00");
        time.add("23:59");
        time.add("00:00");
        System.out.println(LeetCode539.findMinDifference(time));
    }
}
