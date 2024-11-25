import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    //暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; i--) {
            int warmIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (next[j] < warmIndex) {
                    warmIndex = next[j];
                }
            }
            if (warmIndex < Integer.MAX_VALUE) {
                ans[i] = warmIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }

    //单调栈
    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int tempeture = temperatures[i];
            while (!stack.isEmpty() && tempeture > temperatures[stack.peek()]) {
                int preindex = stack.pop();
                ans[preindex] = i - preindex;
            }
            stack.push(i);
        }
        return ans;
    }
}
