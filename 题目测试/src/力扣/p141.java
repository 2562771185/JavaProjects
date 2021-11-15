package 力扣;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/14 17:04
 * @PROJECT_NAME: JavaProjects
 */
public class p141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode() {

        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head;

        while(p != null && head!=null && p.next!=null){
            p=p.next.next;
            head=head.next;
            if(p == head){
                return true;
            }
        }
        return false;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        int n= Math.max(l1.val, l2.val);
        ListNode res = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null){
            if (p1.val < p2.val){
                ListNode node =new ListNode(p1.val);
                res.next = node;
                p1= p1.next;
            }else{
                ListNode node =new ListNode(p2.val);
                res.next = node;
                p2= p2.next;
            }
        }
        while (p1 != null){
            res.next = p1;
            p1 = p1.next;
        }
        while (p2 != null){
            res.next = p2;
            p2 = p2.next;
        }

        return res;
    }
}
