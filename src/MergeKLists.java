import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //分治思想
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid, r));
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val <= bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr.next;
                bPtr = bPtr.next;
            }
        }
        tail.next = aPtr != null ? aPtr : bPtr;
        return head.next;
    }

    //优先队列合并
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;

        public Status(int val, ListNode ptr) {
            this.val=val;
            this.ptr=ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val-status2.val;
        }
    }
    PriorityQueue<Status> queue=new PriorityQueue<>();
    public ListNode mergeKLists1(ListNode []lists){
        for (ListNode node:lists){
            if (node!=null)
                queue.offer(new Status(node.val,node));
        }
        ListNode head=new ListNode(0);
        ListNode tail=head;
        while (!queue.isEmpty()){
            Status f=queue.poll();
            tail.next=f.ptr;
            tail=tail.next;
            if(f.ptr.next!=null){
                queue.offer(new Status(f.ptr.next.val,f.ptr.next));
            }
        }
        return head.next;
    }
}
