package com.longyx.study.algorithm.linkedlist;

/**
 * @author Mr.Longyx
 * @date 2020年10月08日 20:48
 */
public class ReverseKGroupLinkedList1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        // 1 2 3 4 5 6 7 8 k = 3时， 将1 2 3分成一个组 4 5 6 7 8分成另一个组
        // head -> 1 2 3
        // tmp -> 4 5 6 7 8
        // 然后将head反转 tmp反转 再将head->next = tmp即可完成
        for (int i=1; i<k && tmp != null; ++i) {
            tmp = tmp.next;
        }
        // 判断是否每k个一组是足额的(递归终止条件)
        if (tmp == null) {
            return head;
        }

        // 后续节点
        ListNode rightNode = tmp.next;
        tmp.next = null;

        // 逆序当前链表节点
        ListNode newHead = reverseListNode(head);
        // 逆序后续链表节点
        ListNode newTmp = reverseKGroup(rightNode, k);

        // 将两部分连接起来
        head.next = newTmp;

        return newHead;
    }

    public static ListNode reverseListNode(ListNode head) {
        // 递归退出条件判断
        if (head == null || head.next == null) {
            return head;
        }
        // 递归翻转当前链表
        ListNode res = reverseListNode(head.next);

        head.next.next = head;
        head.next = null;

        return res;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nodes = {1,2,3,4,5,6,7,8,9,10};
        ListNode pList = createList(nodes, nodes.length);
        pList = reverseKGroup(pList, k);
        printList(pList);
    }

    private static void printList(ListNode h) {
        while (h != null) {
            System.out.print(h.val+" ");
            h = h.next;
        }
        System.out.println();
    }

    private static ListNode createList(int[] nodes, int n) {
        ListNode head = null, p = null;
        for (int i=0; i<n; ++i) {
            if (head == null) {
                head = p = new ListNode(nodes[i]);
            } else {
                p.next = new ListNode(nodes[i]);
                p = p.next;
            }
        }
        return head;
    }
}
