import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RemoveEthFromEnd {
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

    //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
    //栈
    public ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy=new ListNode(0,head);
        Deque<ListNode> stack=new LinkedList<>();
        ListNode cur=dummy;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev=stack.peek();
        prev.next=prev.next.next;
        ListNode ans=dummy.next;
        return ans;
    }
}
