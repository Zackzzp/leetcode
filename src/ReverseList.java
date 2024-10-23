import java.util.*;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseList {
    //迭代翻转箭头方向
    public ListNode1 reverseList(ListNode1 head) {
        ListNode1 prev = null;
        ListNode1 curr = head;
        while (curr != null) {
            ListNode1 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //递归
    public ListNode1 reverseList1(ListNode1 head){
        if (head==null||head.next==null)
            return head;
        ListNode1 newHead=reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    }
