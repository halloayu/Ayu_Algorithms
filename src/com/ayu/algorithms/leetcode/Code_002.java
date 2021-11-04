package com.ayu.algorithms.leetcode;

public class Code_002 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //res存放结果，cur为res的尾指针
        ListNode res = new ListNode();
        ListNode cur = res;
        //表示进位
        int carry = 0;
        while (l1 != null || l2 != null){
            //如果其中有一个到达结尾了，那么这个链表这一位的的数字就为0。
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            //两个链表的两位相加
            int sum = a + b + carry;
            //大于10进位
            carry = sum / 10;
            //进位完剩下的余数
            sum %= 10;
            //创建一个节点接入res后面
            cur.next = new ListNode(sum);
            cur = cur.next;
            //分别后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //如果最后还有进位的话，增加一个节点
        if (carry == 1) cur.next = new ListNode(1);
        return res.next;
    }

    /**
     * 单线链表节点
     */
    public class ListNode {
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

}
