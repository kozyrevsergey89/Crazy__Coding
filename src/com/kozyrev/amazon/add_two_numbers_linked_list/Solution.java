package com.kozyrev.amazon.add_two_numbers_linked_list;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cur = 0;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode retNode = res;
        while (l1 != null && l2 != null) {

            int val = l1.val + l2.val + cur;
            cur = (val >= 10) ? 1 : 0;
            val = (val >= 10) ? val % 10 : val;

            // cur = (l1.val + l2.val + cur) % 10;
            res.val += val;
            if (l1.next != null && l2.next != null) {
                res.next = new ListNode(0);
                res = res.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        res.val += cur;
        ListNode remaining;
        if (l1 == null && l2 == null) {
            System.out.println("both null");
            // res.next = null;
            return retNode;
        } else if (l1 == null) {
            System.out.println("l1 null");
            remaining = l2;
        } else if (l2 == null) {
            System.out.println("l2 null");
            remaining = l1;
        } else {
            System.out.println("should never happen");
            remaining = null;// shoud never happen
        }
        if (remaining != null) {
            System.out.println("remaining not null");
            while (remaining != null) {
                res.val += remaining.val;
                if (remaining.next != null) {
                    res.next = new ListNode(0);
                    res = res.next;
                }
                remaining = remaining.next;
            }
            // remaining.next = null;
        }
        return retNode;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
