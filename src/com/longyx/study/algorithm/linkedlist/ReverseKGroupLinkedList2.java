package com.longyx.study.algorithm.linkedlist;

/**
 * @author Mr.Longyx
 * @date 2020年10月08日 22:18
 */
public class ReverseKGroupLinkedList2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    // 尾翻链表(方式1)
    public static ListNode reverseKGroupFromEnd(ListNode head, int k) {
        ListNode tmp = head;
        for (int i=1; i<k && tmp != null; ++i){
            tmp = tmp.next;
        }
        // 递归退出条件
        if (tmp == null) return head;

        ListNode rightHead = tmp.next;
        tmp.next = null;

        // 处理单链表翻转
        ListNode newHead = reverseListNode(head);
        // 递归处理右段链表的翻转
        ListNode newTmp = reverseKGroupFromEnd(rightHead, k);

        head.next = newTmp;

        return newHead;
    }

    private static ListNode reverseListNode(ListNode head) {
        // 递归退出条件
        if (head == null || head.next == null) return head;

        // 递归调用处理但链表翻转
        ListNode result = reverseListNode(head.next);

        // 处理指针指向
        head.next.next = head;
        head.next = null;

        return result;
    }

    public static ListNode solve(ListNode head, int k) {
        // 调用逆序函数
        head = reverseListNode(head);
        // 调用每k个一组的逆序函数(从头部开始组起)
        head = reverseKGroupFromEnd(head, k);
        // 再次调用逆序函数
        head = reverseListNode(head);

        return head;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] ins = {1,2,3,4,5,6,7,8};
        ListNode node = createListNode(ins, ins.length);
        node = solve(node, k);

        printList(node);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode createListNode(int[] ins, int n) {
        ListNode head = null, p = null;
        for (int i=0; i<n; ++i) {
            if (head == null) {
                head = p = new ListNode(ins[i]);
            } else {
                p.next = new ListNode(ins[i]);
                p = p.next;
            }
        }
        return head;
    }
}
