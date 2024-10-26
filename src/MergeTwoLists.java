
class MtListNode {
    int val;
    MtListNode next;

    MtListNode() {
    }

    MtListNode(int val) {
        this.val = val;
    }

    MtListNode(int val, MtListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoLists {
    public MtListNode mergeTwoLists(MtListNode list1, MtListNode list2) {
        MtListNode prehead = new MtListNode(-1);

        MtListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        // 合并后 list1 和 list2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = list1 == null ? list2 : list1;

        return prehead.next;


    }
}
