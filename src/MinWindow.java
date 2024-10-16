import java.util.*;

public class MinWindow {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tl = t.length();
        int sl = s.length();
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < sl) {
            ++r;
            if (r < sl && ori.containsKey(s.charAt(r)))
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    public boolean check() {
        Iterator iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val)
                return false;

        }
        return true;
    }
}
