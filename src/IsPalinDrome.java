class HwListNode {
     int val;
      HwListNode next;
      HwListNode() {}
     HwListNode(int val) { this.val = val; }
      HwListNode(int val, HwListNode next) { this.val = val; this.next = next; }
  }
public class IsPalinDrome {
    private HwListNode frontPointer;
    public boolean isPalindrome(HwListNode head) {
       frontPointer=head;
       return recursivelyCheck(head);

    }
    private boolean recursivelyCheck(HwListNode currentPointer){
        if (currentPointer!=null){
            if (!recursivelyCheck(currentPointer.next))
                return false;
            if (currentPointer.val!=frontPointer.val)
                return false;
            frontPointer=frontPointer.next;
        }
        return true;
    }
    private boolean isPalinDrome1(HwListNode head){
        if (head==null)
            return true;
        HwListNode firstOfEnd=endOfFirstHalf(head);
        HwListNode secondHalfStart=reverseList(firstOfEnd.next);

        HwListNode p1=head;
        HwListNode p2=secondHalfStart;
        boolean result=true;
        while(result&&p2!=null){
            if (p1.val!=p2.val)
                result=false;
            p1=p1.next;
            p2=p2.next;
        }
        firstOfEnd.next=reverseList(secondHalfStart);
        return result;



    }
    private HwListNode reverseList(HwListNode head){
        HwListNode prev=null;
        HwListNode curr=head;
        while(curr!=null){
            HwListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private HwListNode endOfFirstHalf(HwListNode head){
        HwListNode fast=head,low=head;
    while(fast.next!=null||fast.next.next!=null){
        fast=fast.next.next;
        low=low.next;

    }
    return low;
    }
}

