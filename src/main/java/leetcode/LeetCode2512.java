package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode2512 {
    Comparator<Student> comparator = (o1, o2) -> {
        if (o1.getReport() == o2.getReport()) {
            return o1.id - o2.id;
        }
        return o2.getReport() - o1.getReport();
    };

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Student> list = new ArrayList<>();
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            int re = 0;
            String[] s = report[i].split(" ");
            for (String s1 : s) {
                if (positive.contains(s1)) {
                    re += 3;
                } else if (negative.contains(s1)) {
                    re -= 1;
                }
            }
            Student student = new Student();
            student.setId(student_id[i]);
            student.setReport(re);
            list.add(student);
        }

        list.sort(comparator);
        return list.stream().map(Student::getId).limit(k).collect(Collectors.toList());
    }

    static class Student {
        private int report;
        private int id;

        public int getReport() {
            return report;
        }

        public void setReport(int report) {
            this.report = report;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        String[] pos = new String[]{"smart", "brilliant", "studious"};
        String[] ne = new String[]{"not"};
        String[] report = new String[]{"this student is not studious", "the student is smart"};
        int[] stu_id = new int[]{1, 2};
        int k = 2;
        LeetCode2512 leetCode2512 = new LeetCode2512();
        leetCode2512.topStudents(pos, ne, report, stu_id, k);
    }
}
