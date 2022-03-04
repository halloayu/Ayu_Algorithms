package com.ayu.algorithms.leetcode;

import java.util.ArrayList;

/**
 * 删除结点
 */
public class Code_019 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0, null);

        removeNthFromEnd(head, 1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0 || head == null)
            return head;

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int num =  list.size();
        int index = num - n + 1;
        if (index < 0) {
            return head;
        }

        if (index == 1) {
            head = head.next;
            return head;
        }

        int i = 1;
        ListNode q = head;
        while (i < index - 1) {
            q = q.next;
            i++;
        }
        // 删除
        q.next = q.next.next;
        return head;
    }

}
