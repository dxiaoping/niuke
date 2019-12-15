package jianzhioffer;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description 输入两个链表，找出它们的第一个公共结点。
 * @auther DuanXiaoping
 * @create 2019-12-12 22:14
 */
public class FindFirstCommonNode {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        Map<ListNode,Boolean> map = new HashMap<>();
        while (pHead1 != null){
            map.put(pHead1,true);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null){
            if (map.get(pHead2) != null){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        FindFirstCommonNode test = new FindFirstCommonNode();
        ListNode head1 = test.new ListNode(2);
        ListNode head5 = test.new ListNode(3);
        ListNode head3 = test.new ListNode(4);
        ListNode head4 = test.new ListNode(5);

        ListNode head = test.new ListNode(1);
        ListNode he = test.new ListNode(0);

        he.next = head1;
        head.next = head5;
        head1.next = head3;
        head5.next = head3;
        head3.next = head4;

        test.FindFirstCommonNode(he,head);
    }
}
