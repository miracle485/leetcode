package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode506 {
    private static final String[] STRINGS = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

    public static String[] findRelativeRanks(int[] score) {
        String[] results = new String[score.length];
        List<StudentScore> studentScores = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            results[i] = Integer.toString(i);
            studentScores.add(new StudentScore(i, score[i]));
        }
        studentScores.sort((o1, o2) -> o2.score - o1.score);
        for (int i = 0; i < studentScores.size(); i++) {
            StudentScore studentScore= studentScores.get(i);
            if (i < 3) {
                results[studentScore.id]=STRINGS[i];
                continue;
            }
            results[studentScore.id]=Integer.toString(i+1);

        }
        return results;
    }

    private static class StudentScore {
        public int id;
        public int score;

        public StudentScore(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
