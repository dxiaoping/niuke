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
        RandomListNode sss = pHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode copy = null;
        RandomListNode srcP = pHead;
        /** 循环链表问题待解决 */

//        该循环之后会多出一个对象
        while (srcP != null) {
            map.put(srcP, srcP.random);
            copy = new RandomListNode(srcP.label);
            copy.next = srcP.next;
            srcP.next = copy;
            srcP = srcP.next.next;
        }
        while (sss != null) {
            System.out.println(sss+"#");
            sss = sss.next;
        }
        srcP = pHead;
        while (srcP != null) {
            copy = srcP.next;
            copy.random = map.get(srcP) == null ? null : map.get(srcP).next;
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

//        while (pHead != null) {
//            System.out.print(pHead+"# ");
//            pHead = pHead.next;
//        }
        System.out.println("head");
        while (head != null) {
            System.out.print(head+"# ");
            head = head.next;
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
        for (int k = 0; k < 10; k++) {
            listNodes.add(null);
        }
        tempNode = head;
        while (tempNode != null) {
//            tempNode.random = listNodes.get(random.nextInt(11));
            tempNode.random = null;
            tempNode = tempNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedClone test = new LinkedClone();
//        RandomListNode head = test.createLinked();
        RandomListNode head = test.new RandomListNode(1);
        RandomListNode head1 = test.new RandomListNode(2);
        RandomListNode head5 = test.new RandomListNode(3);
        RandomListNode head3 = test.new RandomListNode(4);
        RandomListNode head4 = test.new RandomListNode(5);

        head.next = head1;
        head1.next = head5;
        head5.next = head3;
        head3.next = head4;
        head4.next = null;
        head1.random = null;
        head5.random = head4;
        head4.random = head5;

        RandomListNode arg = head;
//        Integer lab = 0;
//        while (head != null) {
//            System.out.print(head.label + "->" + (lab = head.next == null ? null : head.next.label) + " ");
//            System.out.print(head.label + "->" + (lab = head.random == null ? null : head.random.label) + "#");
//            head = head.next;
//        }
        RandomListNode head2 = test.Clone(arg);
        System.out.println();
//        Integer lab2 = 0;
//        while (head2 != null) {
//            System.out.print(head2.label + "->" + (lab2 = head2.next == null ? null : head2.next.label) + " ");
//            System.out.print(head2.label + "->" + (lab2 = head2.random == null ? null : head2.random.label) + "#");
//            head2 = head2.next;
//        }
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        RandomListNode p = pHead;
        RandomListNode t = pHead;
        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        while (t != null) {
            RandomListNode q = t.next;
            if (t.random != null)
                q.random = t.random.next;
            t = q.next;

        }
        RandomListNode s = new RandomListNode(0);
        RandomListNode s1 = s;
        while (pHead != null) {
            RandomListNode q = pHead.next;
            pHead.next = q.next;
            q.next = s.next;
            s.next = q;
            s = s.next;
            pHead = pHead.next;
        }
        return s1.next;
    }
}

//1->2 1->null#2->3 2->null#3->4 3->5#4->5 4->null#5->null 5->3#