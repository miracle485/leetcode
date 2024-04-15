package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author = wangyilin29
 * @date = 2024/4/8
 **/
public class LeetCode756 {
    public static void main(String[] args) {
        List<String> cc = new ArrayList<>();
        cc.add("123");
        cc.add("123");
        System.out.println(cc.stream().distinct().collect(Collectors.toList()));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int length = bottom.length() - 1;
        List<String> cc = new ArrayList<>();
        cc.add(bottom);
        for (int i = 0; i < length; i++) {

            List<String> collect = cc.stream().distinct().collect(Collectors.toList());
            for (String s : collect) {

            }
        }

        return false;
    }
}
