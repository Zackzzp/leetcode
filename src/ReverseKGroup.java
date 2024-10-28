import java.util.List;

public class ReverseKGroup {
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

    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNOde = head;
        int nodeCount = 0;
        while (currentNOde != null) {
            nodeCount++;
            currentNOde = currentNOde.next;
        }
        if (nodeCount < k)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(cur, k);
        return pre;

    }

    //模拟
    public ListNode reverseGroup1(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null)
                    return hair.next;
            }
            ListNode nex = tail.next;
            ListNode reverse[] = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
