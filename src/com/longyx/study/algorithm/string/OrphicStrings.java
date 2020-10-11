package com.longyx.study.algorithm.string;
import	java.util.HashSet;
import	java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mr.Longyx
 * @date 2020年10月03日 17:14
 */
public class OrphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<> ();

        // 遍历s字符串
        for(int i=0; i<s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return  false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        Set<Character> set = new HashSet<> (map.values());
        if(set.size() == map.values().size()) {
            return  true;
        }
        return  false;
    }

    public static void main(String[] args) {
        boolean truth = OrphicStrings.isIsomorphic("paper", "title");
        System.out.println(truth);
    }
}
