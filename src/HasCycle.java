
class HasListNode {
      int val;
      HasListNode next;
      HasListNode(int x) {
          val = x;
          next = null;
      }
  }
public class HasCycle {
    public boolean hasCycle(HasListNode head) {
        if (head==null||head.next==null)
            return false;
        HasListNode slow=head;
        HasListNode fast=head.next;
        while (slow!=fast){
            if (fast==null||fast.next==null)
            return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
