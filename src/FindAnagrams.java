import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if (sl < pl)
            return new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pl; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount))
            ans.add(0);
        for (int i = 0; i < sl - pl; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pl) - 'a'];
            if (Arrays.equals(sCount, pCount))
                ans.add(i + 1);
        }
        return ans;
    }
}
