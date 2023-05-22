package leetcode;

public class LeetCode2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] start1Str = event1[0].split(":");
        String[] end1Str = event1[1].split(":");
        int start1 = getTimeSecond(start1Str);
        int end1 = getTimeSecond(end1Str);
        String[] start2Str = event2[0].split(":");
        String[] end2Str = event2[1].split(":");
        int start2 = getTimeSecond(start2Str);
        int end2 = getTimeSecond(end2Str);

        if (start2 > start1 && start2 > end1) {
            return false;
        }
        if (start2 < start1 && start1 > end2) {
            return false;
        }
        return end2 >= start1 || end1 >= start2;
    }

    private int getTimeSecond(String[] time) {
        int stHour1 = Integer.valueOf(time[0]) * 3600;
        int stM1 = Integer.valueOf(time[1]) * 60;
        return stHour1 + stM1;
    }
}
