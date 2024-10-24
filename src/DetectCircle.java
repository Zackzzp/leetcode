class DcListNode {
    int val;
    DcListNode next;

    DcListNode(int x) {
        val = x;
        next = null;
    }
}

public class DetectCircle {
    public DcListNode detectCycle(DcListNode head) {
        if (head == null)
            return null;
        DcListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return null;
            if (fast == slow) {
                DcListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }


        }

        return null;
    }
}
