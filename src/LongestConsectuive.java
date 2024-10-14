import java.util.*;

public class LongestConsectuive {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentAns = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentAns++;
                }
                ans = Math.max(currentAns, ans);
            }


        }
        return ans;


    }
}
