import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int rc = -1, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i != 0)
                occ.remove(s.charAt(i - 1));
            while (rc + 1 < n && !occ.contains(s.charAt(rc + 1))) {
                occ.add(s.charAt(rc + 1));
                rc++;
            }
            ans = Math.max(ans, rc - i + 1);
        }
        return ans;
    }
}
