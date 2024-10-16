import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    //优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //定义优先队列比较规则
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o2[1];
            }
        });
        //动态窗口初始状态初始化
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    //双端队列
    //这个方法就是使用单调队列存储每一个未被排除的下标，因为我们每次入队列的时候都尽可能保证让较大的进入，同时踢出最小的
    //不是严格意义的滑动窗口移动，但是效果一致
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;


    }
}
