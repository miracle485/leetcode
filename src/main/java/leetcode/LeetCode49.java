package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> kk = new HashMap<>();
        for (String str : strs) {
            String hashCode = hash(str.toCharArray());
            kk.computeIfAbsent(hashCode, key -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(kk.values());
    }

    private String hash(char[] chars) {
        Map<Integer, Integer> map = new HashMap<>(200);
        for (char c : chars) {
            Integer orDefault = map.getOrDefault(c % 97, 0);
            orDefault++;
            map.put(c % 97, orDefault);
        }
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.append((char) ('a' + entry.getKey())).append(entry.getValue());
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String[] result = new String[]{"chi", "nip", "lab", "mud", "fan", "yak", "kid", "lox", "joy", "rob", "cad", "hug", "ken", "oaf", "pus", "hos", "ton", "any", "sac", "mid", "nip", "ron", "tux", "set", "jug", "axe", "ago", "sob", "ode", "dot", "nit", "pug", "sue", "new", "rub", "sup", "ohs", "ski", "oaf", "don", "cob", "kin", "ark", "gay", "jay", "bur", "dot", "eat", "rca", "wad", "maj", "luz", "gad", "dam", "eon", "ark", "del", "sin", "tat"};
        LeetCode49 leetCode49 = new LeetCode49();
        leetCode49.groupAnagrams(result);
        Character a = 'a';
        System.out.println(a.hashCode());
        System.out.println(((int) 'a'));
    }
}
