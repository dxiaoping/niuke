package jianzhioffer;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        while (copy != null) {
            copy.next = copy.next.next;
            copy = copy.next.next;
        }
        return head;
    }

    public RandomListNode createLinked() {
        RandomListNode head = new RandomListNode(random.nextInt(1000));
        RandomListNode tempNode = head;
        int i = 0;
        while (i < 10) {
            RandomListNode newNode = new RandomListNode(random.nextInt(1000));
            tempNode.next = newNode;
            tempNode = newNode;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedClone test = new LinkedClone();
        RandomListNode head = test.createLinked();
        while (head != null) {
            if (head.next != null) {
                System.out.println(head.label + "->" + head.next.label);
            } else {
                System.out.println(head.label + "->" + head.next);
            }
//            System.out.println(head.label);
            head = head.next;
        }
    }
}