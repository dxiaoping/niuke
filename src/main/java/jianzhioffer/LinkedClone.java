package jianzhioffer;
import java.util.*;

/**
 * @Description 复杂链表的复制
 * @auther DuanXiaoping
 * @create 2019-12-11 21:32
 */


public class LinkedClone {
    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    Random random = new Random();

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode copy = null;
        RandomListNode srcP = pHead;
        /** 循环链表问题待解决 */
        while (srcP != null) {
            map.put(srcP, srcP.random);
            copy = new RandomListNode(srcP.label);
            copy.next = srcP.next;
            srcP.next = copy;
            srcP = srcP.next.next;
        }
        srcP = pHead;
        while (srcP != null) {
            copy = srcP.next;
            copy.random = map.get(srcP).next;
            srcP = srcP.next.next;
        }
        srcP = pHead;
        copy = srcP.next;
        RandomListNode head = copy;
        while (copy.next != null) {
            srcP = copy.next;
            copy.next = srcP.next;
            copy = srcP.next;
        }
        return head;
    }

    public RandomListNode createLinked() {
        List<RandomListNode> listNodes = new ArrayList<>();
        RandomListNode head = new RandomListNode(random.nextInt(1000));
        listNodes.add(head);
        RandomListNode tempNode = head;
        int i = 0;
        while (i < 10) {
            RandomListNode newNode = new RandomListNode(random.nextInt(1000));
            listNodes.add(newNode);
            tempNode.next = newNode;
            tempNode = newNode;
            i++;
        }
        tempNode = head;
        while (tempNode != null) {
            tempNode.random = listNodes.get(random.nextInt(11));
            tempNode = tempNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedClone test = new LinkedClone();
        RandomListNode head = test.createLinked();
        RandomListNode arg = head;
        Integer lab = 0;
        while (head != null) {
            System.out.print(head.label + "->" + (lab = head.next == null ? null : head.next.label) + " ");
            System.out.print(head.label + "->" + (lab = head.random == null ? null : head.random.label) + "#");
            head = head.next;
        }
        RandomListNode head2 = test.Clone(arg);
        System.out.println();
        Integer lab2 = 0;
        while (head2 != null) {
            System.out.print(head2.label + "->" + (lab2 = head2.next == null ? null : head2.next.label) + " ");
            System.out.print(head2.label + "->" + (lab2 = head2.random == null ? null : head2.random.label) + "#");
            head2 = head2.next;
        }
    }
}